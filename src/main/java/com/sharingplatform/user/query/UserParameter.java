package com.benz.user.query;

import com.benz.framework.domain.QueryParameter;

/**
 * Created by paulliu on 2017/1/19.
 */
public class UserParameter extends QueryParameter {
    private String username;
    private String department;
    private String professional;
    private String role;

    public UserParameter() {
    }

    public UserParameter(String username, String department, String professional, String role) {
        this.username = username;
        this.department = department;
        this.professional = professional;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserParameter{" +
                "username='" + username + '\'' +
                ", department='" + department + '\'' +
                ", professional='" + professional + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
