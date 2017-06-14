package com.benz.user.domain;

import com.benz.framework.AssertionConcern;

/**
 * Created by paulliu on 2017/1/19.
 */
public class Authority {
    private String id;
    private String name;

    public Authority() {
    }

    public Authority(String id) {
        AssertionConcern.assertArgumentNotEmpty(id, "Authority cannot be empty");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
