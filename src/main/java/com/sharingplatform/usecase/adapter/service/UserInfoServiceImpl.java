package com.sharingplatform.usecase.adapter.service;

import com.sharingplatform.usecase.domain.UserInfo;
import com.sharingplatform.usecase.domain.UserInfoService;
import com.sharingplatform.user.query.UserQuery;
import com.sharingplatform.user.query.UserProfile;
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
