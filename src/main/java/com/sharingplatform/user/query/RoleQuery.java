package com.sharingplatform.user.query;

import com.sharingplatform.framework.domain.QueryParameter;
import com.sharingplatform.framework.query.BaseQuery;
import com.sharingplatform.framework.query.PageParameter;
import com.sharingplatform.framework.query.PagedList;
import com.sharingplatform.usecase.query.BUMapper;
import com.sharingplatform.usecase.query.BUResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by hongying.fu on 12/15/2016.
 */
@Service
public class RoleQuery extends BaseQuery {

    @Autowired
    private RoleMapper roleMapper;

    public PagedList<RoleResult> findAll(final QueryParameter parameter, Integer pageNum) {

        PagedList<RoleResult> useCaseResultPagedList = paging(parameter, new Callable<List<RoleResult>>() {
            public List<RoleResult> call() {
                return roleMapper.findAll(parameter);
            }
        }, new PageParameter(pageNum));

        return useCaseResultPagedList;
    }
}