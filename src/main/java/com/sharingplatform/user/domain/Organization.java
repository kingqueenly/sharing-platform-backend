package com.sharingplatform.user.domain;

import java.util.List;

/**
 * Created by hongying.fu on 5/5/2017.
 */
public class Organization {
    private String name;
    private List<Department> departments;

    public Organization() {
    }

    public Organization(String name, List<Department> departments) {
        this.name = name;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
