package com.sharingplatform.usecase.query;

import com.sharingplatform.framework.domain.QueryParameter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by hongying.fu on 2/13/2017.
 */
@Mapper
public interface DataAnalysisModelMapper {
    List<ValueResult> findAll(QueryParameter parameter);
}
