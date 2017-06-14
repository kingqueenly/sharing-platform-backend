package com.benz.user.query;

import com.benz.user.domain.BenzUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by hongying.fu on 1/10/2017.
 */
@Mapper
public interface UserMapper {

    UserProfile findById(Long id);

    UserIdentity auth(String username);

    List<UserProfile> findAll(UserParameter userParameter);

    List<LevelResult> getLevelRule();

    BenzUser findByUserId(String userId);

    List<UserProfile> getDataCommunity(UserParameter parameter);
}
