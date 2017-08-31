package com.sharingplatform.datagovernance.query;

import com.sharingplatform.usecase.query.ValueResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by AMC on 2017/7/31.
 */
@Mapper
public interface ApplicationMapper {

    ApplicationResult findById(Long id);
}
