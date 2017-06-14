package com.sharingplatform.framework.query;

import com.sharingplatform.framework.domain.QueryParameter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by hongying.fu on 12/21/2016.
 */
public class BaseQuery {

    protected <T> PagedList<T> paging(QueryParameter parameter, Callable<List<T>> func, PageParameter pageParameter) {

        PageHelper.startPage(pageParameter.getPageNum(), pageParameter.getPageSize());

        List<T> useCaseResultList = null;
        try {
            useCaseResultList = func.call();
        } catch (Exception e) {
            //TODO: exception handling
            e.printStackTrace();
        }

        PageInfo<T> pageInfo = new PageInfo<>(useCaseResultList);

        PagedList<T> pagedList = new PagedList<>(
                useCaseResultList,
                pageInfo.getPageNum(),
                pageInfo.getPageSize(),
                pageInfo.getSize(),
                pageInfo.getTotal(),
                pageInfo.getPages(),
                pageInfo.isIsFirstPage(),
                pageInfo.isIsLastPage(),
                pageInfo.isHasPreviousPage(),
                pageInfo.isHasNextPage());

        return pagedList;
    }

}
