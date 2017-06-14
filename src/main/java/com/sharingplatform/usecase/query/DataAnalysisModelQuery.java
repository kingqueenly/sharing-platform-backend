package com.sharingplatform.usecase.query;

import com.sharingplatform.framework.domain.QueryParameter;
import com.sharingplatform.framework.query.BaseQuery;
import com.sharingplatform.framework.query.PageParameter;
import com.sharingplatform.framework.query.PagedList;
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
