package com.benz.usecase.query;

import com.benz.framework.domain.QueryParameter;
import com.benz.usecase.domain.CaseCommentLikeShare;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by paulliu on 2016/12/24.
 */
@Mapper
public interface BUMapper {

    List<BUResult> findAll(QueryParameter parameter);

    List<ValueResult> findAllCompanies();

    List<ValueResult> findDeptByCompany(String company);

}
