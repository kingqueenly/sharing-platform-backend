package com.benz.usecase.query;

import com.benz.framework.domain.QueryParameter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by hongying.fu on 2/13/2017.
 */
@Mapper
public interface DataSourceMapper {
    List<ValueResult> findAll(QueryParameter parameter);
}
