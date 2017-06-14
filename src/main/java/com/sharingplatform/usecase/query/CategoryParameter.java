package com.sharingplatform.usecase.query;

import com.sharingplatform.framework.domain.QueryParameter;

import java.util.List;

/**
 * Created by AMC on 2017/5/31.
 */
public class CategoryParameter  {
    private String category;
    private List<String> phases;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getPhases() {
        return phases;
    }

    public void setPhases(List<String> phases) {
        this.phases = phases;
    }
}
