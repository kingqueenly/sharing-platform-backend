package com.sharingplatform.user.query;

import com.sharingplatform.user.application.UserCreateCommand;
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

    //BenzUser findByUserId(String userId);

    List<UserProfile> getDataCommunity(UserParameter parameter);

    List<UserCreateCommand> findWiWUsers();

    Long findId(String userId);
}
