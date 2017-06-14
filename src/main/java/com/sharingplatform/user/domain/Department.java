package com.sharingplatform.user.domain;

import com.sharingplatform.user.query.UserProfile;

import java.util.List;

/**
 * Created by hongying.fu on 5/5/2017.
 */
public class Department {
    private String name;
    private List<UserProfile> remembers;

    public Department() {
    }

    public Department(String name, List<UserProfile> remembers) {
        this.name = name;
        this.remembers = remembers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserProfile> getRemembers() {
        return remembers;
    }

    public void setRemembers(List<UserProfile> remembers) {
        this.remembers = remembers;
    }
}
