package com.sharingplatform.usecase.query;

import com.sharingplatform.framework.domain.QueryParameter;
import com.sharingplatform.usecase.domain.CaseCommentLikeShare;
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
