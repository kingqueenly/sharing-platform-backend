package com.sharingplatform.datagovernance.query;

import com.sharingplatform.usecase.query.ValueResult;
import com.sharingplatform.user.query.UserParameter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by AMC on 2017/7/31.
 */
@Mapper
public interface SystemNameMapper {

    List<SystemNameConfigResult> findAllSystemNameConfig();

    List<SystemNameResult> findAllSystemName();

    List<String> findDataOwnerIds(List<String> systemNames);

    List<String> findItOwnerIds(List<String> systemNames);
}
