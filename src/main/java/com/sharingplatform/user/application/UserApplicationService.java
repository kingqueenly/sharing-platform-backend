package com.sharingplatform.user.application;

import com.sharingplatform.framework.AssertionConcern;
import com.sharingplatform.user.ProvisioningServiceServiceStub;
import com.sharingplatform.user.domain.*;
import com.sharingplatform.user.query.UserQuery;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.impl.httpclient4.HttpTransportPropertiesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by paulliu on 2016/12/7.
 */
@Service
public class UserApplicationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    UserQuery userQuery;

    public void createWiWUsers() {

        List<UserCreateCommand> commands = userQuery.findWiWUsers();

        for (int i = 0; i < commands.size(); i++) {

            System.out.println("Number : " + i);
            UserCreateCommand command = commands.get(i);
            command.setAuthority("user");
            command.setIsDCRemember(false);
            command.setOrganization(command.plants.get(command.getOrganization()));
            Long id = userQuery.findId(command.getUserId());
            if(id == null) {
                createUser(command);
                System.out.println(id);
            }

//            command.setLevel("Iron");
//            command.setScore(5);
//            Long id = DomainRegistry.userRepository().nextIdentity();
//            command.setId(id);
//            command.setAuthority("user");
//            command.setIsDCRemember(false);
//
//            UserCommentLikeShare userCommentLikeShare = new UserCommentLikeShare(
//                    false, 0, 0,
//                    0, 0, 0);
//
//            BenzUser benzUser = new BenzUser(
//                    command.getId(),
//                    command.getUserId(),
//                    command.getAppellation(),
//                    command.getUsername(),
//                    command.getImgUrl(),
//                    command.getOrganization(),
//                    command.getDepartment(),
//                    command.getWorkArea(),
//                    command.getProfessional(),
//                    command.getEmail(),
//                    command.getPhone(),
//                    command.getMobile(),
//                    command.getScore(),
//                    command.getLevel(),
//                    new Authority(command.getAuthority()),
//                    command.getRole(),
//                    command.getIsDCRemember(),
//                    userCommentLikeShare);
//
//            benzUser.create();
//
//            long mills = 100;
//            Thread.sleep(mills);
        }
    }

    public Long createUser(UserCreateCommand command) {
//        String imgHttpUrl = SpringBootApplicationContext.getBean(FileParameters.class).getUrl();

//        command.setImageUrl(" http://localhost:8081/2017/02/07/20170207165045643696.png");
//        command.setImageUrl("/2017/04/14/20170414154305456918.jpg");
        command.setLevel("Iron");
        command.setScore(5);
        if(command.getId() == null) {
            Long id = DomainRegistry.userRepository().nextIdentity();
            command.setId(id);
        }

        UserCommentLikeShare userCommentLikeShare = new UserCommentLikeShare(false, 0, 0, 0,
                0, 0);
//        Role role=parseRole(command.getRole());
        BenzUser benzUser = new BenzUser(
                command.getId(),
                command.getUserId(),
                command.getAppellation(),
                command.getUsername(),
                command.getImgUrl(),
                command.getOrganization(),
                command.getDepartment(),
                command.getWorkArea(),
                command.getProfessional(),
                command.getEmail(),
                command.getPhone(),
                command.getMobile(),
                command.getScore(),
                command.getLevel(),
                new Authority(command.getAuthority()),
                command.getRole(),
                command.getIsDCRemember(),
                userCommentLikeShare);
        benzUser.create();

        return benzUser.getId();
    }

    public void updateUserForCorpDir(UserUpdateCommand command) {
        Long id = userQuery.findId(command.getUserId());
        if(id != null) {
            BenzUser user = existingUser(id);
            user.update(command);
        }
    }

    @Transactional
    public void updateUser(UserUpdateCommand command, HttpServletRequest request) {
        BenzUser user = existingUser(command.getId());

//        Role role=parseRole(command.getRole());
        user.update(command.getAppellation(),
                command.getUsername(),
                command.getImgUrl(),
                command.getOrganization(),
                command.getDepartment(),
                command.getWorkArea(),
                command.getProfessional(),
                command.getEmail(),
                command.getPhone(),
                command.getMobile(),
                new Authority(command.getAuthority()),
                command.getRole(),
                command.getIsDCRemember(),
                command.getDeleted()
        );

        if (request != null) {
            BenzUser u = (BenzUser) request.getSession().getAttribute("user");
            if (u.getId() == command.getId()) {
                request.getSession().setAttribute("user", u);
            }
        }
    }

    public void deleteUser(Long id) {
        BenzUser user = existingUser(id);
        user.setDeleted(true);
        user.update();
    }

    public void deleteUser(String userId) {
        Long id = userQuery.findId(userId);
        if(id != null) {
            BenzUser user = existingUser(id);
            user.setDeleted(true);
            user.update();
        }
    }

    public BenzUser existingUser(Long id) {
        BenzUser user = userRepository.findOne(id);
        AssertionConcern.assertArgumentNotNull(user, "User does not exist");
        return user;
    }

//    public BenzUser findByUserId(String userId) {
//        BenzUser user = new BenzUser();
//        user.setUserId(userId);
//        Example<BenzUser> ex = Example.of(user);
//        List<BenzUser> bu = userRepository.findAll(ex);
//        return bu.get(0);
//    }

    private static final String APP_ID = "CNBIP";
    private static final String SYSTEM = "CD";
    private static final int NUMBER_OF_RECORDS = 50;

    private static final String AUTH_USERNAME = "CNBIP_prov_00";
    private static final String AUTH_PASSWORD = "wa7TMZNkhcPp7ytXUJlG";
    private static final String PROXY_NAME = "53.90.130.51";
    private static final int PROXY_PORT = 3128;

    private static final String TARGET_ENDPOINT = "https://cd-appstest.e.corpintra.net/pservice/services/ProvisioningService";
    //private static final String TARGET_ENDPOINT = "http://localhost:8090/pservice/services/ProvisioningService";

    private ProvisioningServiceServiceStub buildProvisioningService() {
        try {

            Map<String, Object> properties = new HashMap<String, Object>();
            HttpTransportPropertiesImpl.Authenticator auth = new HttpTransportPropertiesImpl.Authenticator();
            auth.setUsername(AUTH_USERNAME);
            auth.setPassword(AUTH_PASSWORD);
            properties.put(HTTPConstants.AUTHENTICATE, auth);

//            HttpTransportPropertiesImpl.ProxyProperties proxy = new HttpTransportPropertiesImpl.ProxyProperties();
//            proxy.setProxyName(PROXY_NAME);
//            proxy.setProxyPort(PROXY_PORT);
//            properties.put(HTTPConstants.PROXY, proxy);

            Options options = new Options();
            EndpointReference epr = new EndpointReference(TARGET_ENDPOINT);
            options.setTo(epr);
            options.setProperties(properties);

            ProvisioningServiceServiceStub stub = new ProvisioningServiceServiceStub(TARGET_ENDPOINT);
            stub._getServiceClient().setOptions(options);
            return stub;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n\n\n");
            return null;
        }
    }

    public void syncWithCorpDir() {
        try {
            ProvisioningServiceServiceStub.GetMyChanges getMyChanges = new ProvisioningServiceServiceStub.GetMyChanges();
            getMyChanges.setAppId(APP_ID);
            getMyChanges.setSystem(SYSTEM);
            getMyChanges.setNumberOfRecords(NUMBER_OF_RECORDS);

            ProvisioningServiceServiceStub stub = buildProvisioningService();
            ProvisioningServiceServiceStub.GetMyChangesResponse getMyChangesResponse = stub.getMyChanges(getMyChanges);
            ProvisioningServiceServiceStub.GetMyChangesResult getMyChangesResult = getMyChangesResponse.getGetMyChangesReturn();
            while (getMyChangesResult.getNumberOfRecords() > 0) {
                ProvisioningServiceServiceStub.ArrayOfChangeRecord arrayOfChangeRecord = getMyChangesResult.getChangeRecords();
                ProvisioningServiceServiceStub.ChangeRecord[] changeRecords = arrayOfChangeRecord.getItem();
                for (ProvisioningServiceServiceStub.ChangeRecord changeRecord : changeRecords) {
                    updateDatabase(changeRecord);
                }

                ProvisioningServiceServiceStub.SetMyLastProcessedId setMyLastProcessedId = new ProvisioningServiceServiceStub.SetMyLastProcessedId();
                setMyLastProcessedId.setAppId(APP_ID);
                setMyLastProcessedId.setSystem(SYSTEM);
                setMyLastProcessedId.setMyLastProcessedId(getMyChangesResult.getMyLastProcessedIDServiceUpdate());
                stub.setMyLastProcessedId(setMyLastProcessedId);

                getMyChangesResponse = stub.getMyChanges(getMyChanges);
                getMyChangesResult = getMyChangesResponse.getGetMyChangesReturn();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n\n\n");
        }
    }

    private void updateDatabase(ProvisioningServiceServiceStub.ChangeRecord changeRecord) {
        Long id = changeRecord.getId();
        String type = changeRecord.getType();
        if ("add".equals(type)) {
            UserCreateCommand command = new UserCreateCommand(changeRecord);
            createUser(command);
        } else if ("del".equals(type)) {
            //soft delete
            String userId = getUserIdForDel(changeRecord);
            deleteUser(userId);
        } else if ("mod".equals(type)) {
            UserUpdateCommand command = new UserUpdateCommand(changeRecord);
            updateUserForCorpDir(command);
        }
    }

    private String getUserIdForDel(ProvisioningServiceServiceStub.ChangeRecord changeRecord) {
        ProvisioningServiceServiceStub.ArrayOfAttribute arrayOfAttribute = changeRecord.getOldAttrs();
        ProvisioningServiceServiceStub.Attribute[] attributes = arrayOfAttribute.getItem();
        for (ProvisioningServiceServiceStub.Attribute attr : attributes) {
            String attrName = attr.getName();
            String attrValue = "";
            if (attr.getValues() != null && attr.getValues().getItem() != null) {
                attrValue = attr.getValues().getItem()[0];
            }

            if ("uid".equals(attrName)) {
                return attrValue;
            }
        }
        return null;
    }
}
