package com.benz.usecase.query;

import com.benz.framework.domain.QueryParameter;
import com.benz.framework.query.BaseQuery;
import com.benz.framework.query.PageParameter;
import com.benz.framework.query.PagedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by hongying.fu on 2/13/2017.
 */
@Service
public class DataAnalysisModelQuery extends BaseQuery {
    @Autowired
    private DataAnalysisModelMapper dataAnalysisModelMapper;

    public PagedList<ValueResult> findAll(final QueryParameter parameter, Integer pageNum) {
        PagedList<ValueResult> useCaseResultPagedList = paging(parameter, new Callable<List<ValueResult>>() {
            public List<ValueResult> call() {
                return dataAnalysisModelMapper.findAll(parameter);
            }
        }, new PageParameter(pageNum));

        return useCaseResultPagedList;
    }

    public PagedList<ValueResult> findAll(QueryParameter parameter) {
        List<ValueResult> list=dataAnalysisModelMapper.findAll(parameter);
        PagedList<ValueResult> useCaseResultPagedList = new PagedList<ValueResult>();
        useCaseResultPagedList.setList(list);
        return useCaseResultPagedList;
    }
}
