package com.benz.usecase.query;

import com.benz.framework.domain.QueryParameter;
import com.benz.framework.query.BaseQuery;
import com.benz.framework.query.PageParameter;
import com.benz.framework.query.PagedList;
import com.benz.usecase.domain.event.UseCaseViewedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by hongying.fu on 12/15/2016.
 */
@Service
public class BUQuery extends BaseQuery {

    @Autowired
    private BUMapper buMapper;

    public PagedList<BUResult> findAll(final QueryParameter parameter, Integer pageNum, Integer pageSize) {

        PagedList<BUResult> useCaseResultPagedList = paging(parameter, new Callable<List<BUResult>>() {
            public List<BUResult> call() {
                return buMapper.findAll(parameter);
            }
        }, new PageParameter(pageNum, pageSize));

        return useCaseResultPagedList;
    }

    public PagedList<ValueResult> findAllCompanies() {
        List<ValueResult> list=buMapper.findAllCompanies();
        PagedList<ValueResult> pagedList = new PagedList<ValueResult>();
        pagedList.setList(list);
        return pagedList;
    }

    public PagedList<ValueResult> findDeptByCompany(String company) {
        List<ValueResult> list=buMapper.findDeptByCompany(company);
        PagedList<ValueResult> pagedList = new PagedList<ValueResult>();
        pagedList.setList(list);
        return pagedList;
    }
}