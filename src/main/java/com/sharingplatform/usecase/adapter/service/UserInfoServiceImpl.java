package com.benz.usecase.adapter.service;

import com.benz.usecase.domain.UserInfo;
import com.benz.usecase.domain.UserInfoService;
import com.benz.user.query.UserQuery;
import com.benz.user.query.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hongying.fu on 1/10/2017.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserQuery userQuery;

    @Override
    public UserInfo findById(Long id) {
        UserProfile userProfile = userQuery.findById(id);
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userProfile.getId());
        userInfo.setUsername(userProfile.getUsername());
        userInfo.setDepartment(userProfile.getDepartment());
        userInfo.setImgUrl(userProfile.getImgUrl());
        return userInfo;
    }
}
