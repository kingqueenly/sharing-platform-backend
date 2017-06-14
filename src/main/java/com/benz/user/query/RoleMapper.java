package com.benz.user.query;

import com.benz.framework.domain.QueryParameter;
import com.benz.usecase.query.BUResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by paulliu on 2016/12/24.
 */
@Mapper
public interface RoleMapper {

    List<RoleResult> findAll(QueryParameter parameter);

}
