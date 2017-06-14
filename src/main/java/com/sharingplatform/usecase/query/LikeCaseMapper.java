package com.sharingplatform.usecase.query;

import com.sharingplatform.usecase.domain.LikeCase;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * Created by hongying.fu on 1/16/2017.
 */
@Mapper
public interface LikeCaseMapper {
    LikeCase findByUserIdUseCaseId(Map<String, String> condition);
}
