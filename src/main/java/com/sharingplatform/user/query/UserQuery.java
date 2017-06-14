package com.sharingplatform.user.query;

import com.sharingplatform.framework.query.BaseQuery;
import com.sharingplatform.framework.query.PageParameter;
import com.sharingplatform.framework.query.PagedList;
import com.sharingplatform.user.domain.BenzUser;
import com.sharingplatform.user.domain.Department;
import com.sharingplatform.user.domain.Organization;
import com.sharingplatform.user.domain.event.LoginedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.Callable;

/**
 * Created by hongying.fu on 1/10/2017.
 */
@Service
public class UserQuery extends BaseQuery {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ApplicationEventPublisher publisher;

    public UserProfile findById(Long id) {
        return userMapper.findById(id);
    }

    /*this method used for get profile when logs in.
    please ensure that only one caller for this method*/
    public UserProfile profile(Long id) {
        System.out.println("detail user:"+id);
        UserProfile userProfile = userMapper.findById(id);

        if (userProfile != null)
            this.publisher.publishEvent(new LoginedEvent(userProfile.getId()));

        return userProfile;
    }

    public UserIdentity auth(String username) {
        UserIdentity userIdentity = userMapper.auth(username);
        return userIdentity;
    }

    public PagedList<UserProfile> findAll(final UserParameter parameter, Integer pageNum) {

        PagedList<UserProfile> userProfilePagedList = paging(parameter, new Callable<List<UserProfile>>() {
            public List<UserProfile> call() {
                if(parameter!=null){
                    if(parameter.getUsername()!= null && !"".equals(parameter.getUsername())){
                        parameter.setUsername(parameter.getUsername().toUpperCase());
                    }
                    if(parameter.getDepartment()!= null && !"".equals(parameter.getDepartment())){
                        parameter.setDepartment(parameter.getDepartment().toUpperCase());
                    }
                    if(parameter.getProfessional()!= null && !"".equals(parameter.getProfessional())){
                        parameter.setProfessional(parameter.getProfessional().toUpperCase());
                    }
                }
//                List<UserProfile> list =userMapper.findAll(parameter);
                return userMapper.findAll(parameter);
//                return list;
            }
        }, new PageParameter(pageNum));
        return userProfilePagedList;
    }

    public List<LevelResult> getLevelRule() {
        return userMapper.getLevelRule();
    }

    public BenzUser findByUserId(String userId) {
        BenzUser user = userMapper.findByUserId(userId);
        return user;
    }

    public List<Organization> getDataCommunity(UserParameter parameter) {
        List<Organization> organizationLists = new ArrayList<>();
        List<UserProfile> list = userMapper.getDataCommunity(parameter);
        Map<String,Map<String,List<UserProfile>>> map = new HashMap<>();

        for (UserProfile userProfile : list){
            String organizationName = userProfile.getOrganization();
            Map<String,List<UserProfile>> organizationMap = map.get(organizationName);
            if(organizationMap==null){ // organization is not exits
                organizationMap = new HashMap<>(); //create organization
                List<UserProfile> departmentRemembers = new ArrayList<>(); //create department
                departmentRemembers.add(userProfile); //add user to department
                organizationMap.put(userProfile.getDepartment(),departmentRemembers); //add department to organization
                map.put(organizationName,organizationMap); //add organization to map
            }else {
                String departmentName = userProfile.getDepartment();
                List<UserProfile> departmentRemembers = organizationMap.get(departmentName);
                if(departmentRemembers == null){ // department is not exits
                    departmentRemembers = new ArrayList<>(); //create department
                    departmentRemembers.add(userProfile); //add user to department
                    organizationMap.put(departmentName,departmentRemembers); // add department to organization
                }else {
                    departmentRemembers.add(userProfile);
                }
            }
        }

        Set<String> orgNames= map.keySet();
        for (String orgName :orgNames){
            Organization organizationList = new Organization();
            organizationList.setName(orgName);
            List<Department> departmentLists = new ArrayList<>();
            Map<String,List<UserProfile>> departmentMap = map.get(orgName);
            Set<String> depNames = departmentMap.keySet();
            for(String depName : depNames){
                Department departmentList = new Department();
                departmentList.setName(depName);
                departmentList.setRemembers(departmentMap.get(depName));
                departmentLists.add(departmentList);
            }
            organizationList.setDepartments(departmentLists);
            organizationLists.add(organizationList);
        }
        return organizationLists;
    }
}
