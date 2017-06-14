package com.benz.usecase.query;

import com.benz.framework.domain.QueryParameter;

import java.util.List;

/**
 * Created by AMC on 2017/5/31.
 */
public class CategoryListParameter extends QueryParameter{

    private List<CategoryParameter> categoryParameterList;

    public List<CategoryParameter> getCategoryParameterList() {
        return categoryParameterList;
    }

    public void setCategoryParameterList(List<CategoryParameter> categoryParameterList) {
        this.categoryParameterList = categoryParameterList;
    }

}
