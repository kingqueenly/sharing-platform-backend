package com.benz.user.adapter.web;

import com.benz.framework.domain.ServiceCommand;
import com.benz.framework.query.PagedList;
import com.benz.user.application.UserApplicationService;
import com.benz.user.application.UserCreateCommand;
import com.benz.user.application.UserUpdateCommand;
import com.benz.user.domain.Organization;
import com.benz.user.query.LevelResult;
import com.benz.user.query.UserParameter;
import com.benz.user.query.UserProfile;
import com.benz.user.query.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by hongying.fu on 1/10/2017.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserApplicationService userApplicationService;
    @Autowired
    private UserQuery userQuery;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Long create(@RequestBody UserCreateCommand command) {
//        System.out.println(command.toString());
        return userApplicationService.createUser(command);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public void update(@PathVariable Long id, @RequestBody UserUpdateCommand command,HttpServletRequest request) {
        command.setId(id);
        userApplicationService.updateUser(command,request);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void update(@PathVariable Long id) {
        userApplicationService.deleteUser(id);
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public UserProfile findOne(ServiceCommand command, HttpServletRequest request) {
//        BenzUser user = (BenzUser) request.getSession().getAttribute("user");
        return userQuery.profile(command.getOperatorId());
//        return userQuery.profile(user.getId());
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public UserProfile findOne(@PathVariable Long id) {
        System.out.println("controller detail user:"+id);
        return userQuery.profile(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public PagedList<UserProfile> search(@RequestBody(required = false) UserParameter parameter) {
        return userQuery.findAll(parameter, 1);
    }

    @RequestMapping(value = "/search/{pageNum}", method = RequestMethod.POST)
    public PagedList<UserProfile> search(@PathVariable Integer pageNum, @RequestBody(required = false) UserParameter parameter) {

        return userQuery.findAll(parameter, pageNum);
    }

    @RequestMapping(value = "/rule", method = RequestMethod.GET)
    public List<LevelResult> getLevelRule(){
        return userQuery.getLevelRule();
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout(HttpServletRequest request, HttpServletResponse response){
       request.getSession().removeAttribute("user");
    }

    @RequestMapping(value = "/dataCommunity", method = RequestMethod.POST)
    public List<Organization> dataCommunity(@RequestBody UserParameter parameter){
        System.out.println("UserParameter parameter:"+parameter);
        return userQuery.getDataCommunity(parameter);
    }
}
