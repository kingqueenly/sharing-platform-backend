package com.sharingplatform.interceptor.adapter.service;


import com.sharingplatform.interceptor.domain.UserCreateCommand;

/**
 * Created by hongying.fu on 4/12/2017.
 */
public interface UserInfoService {
    void create(UserCreateCommand user);
}
