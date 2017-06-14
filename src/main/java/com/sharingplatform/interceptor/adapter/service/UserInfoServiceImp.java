package com.benz.interceptor.adapter.service;


import com.benz.interceptor.domain.UserCreateCommand;
import com.benz.user.application.UserApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by hongying.fu on 4/12/2017.
 */
@Component
public class UserInfoServiceImp implements UserInfoService {

    @Autowired
    private UserApplicationService userApplicationService;

    @Override
    public void create(UserCreateCommand user) {

        com.benz.user.application.UserCreateCommand createCommand= new com.benz.user.application.UserCreateCommand();
        createCommand.setUserId(user.getUserId());
        createCommand.setAuthority(user.getAuthority());
        createCommand.setUsername(user.getUserId());
        createCommand.setIsDCRemember(user.getIsDCRemember());
        userApplicationService.createUser(createCommand);
    }
}
