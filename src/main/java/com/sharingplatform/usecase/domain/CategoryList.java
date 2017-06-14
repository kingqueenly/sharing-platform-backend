package com.sharingplatform.usecase.domain;

import java.util.List;

/**
 * Created by hongying.fu on 4/19/2017.
 */
public class CategoryList {
    private String category;
    private List<StageList> list;

    public CategoryList() {
    }

    public CategoryList(String category, List<StageList> list) {
        this.category = category;
        this.list = list;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<StageList> getList() {
        return list;
    }

    public void setList(List<StageList> list) {
        this.list = list;
    }
}
