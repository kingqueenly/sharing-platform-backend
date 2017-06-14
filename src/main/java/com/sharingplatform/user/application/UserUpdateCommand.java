package com.benz.user.application;

import com.benz.framework.domain.ServiceCommand;

/**
 * Created by paulliu on 2016/12/7.
 */
public class UserUpdateCommand extends ServiceCommand {
    private Long id;
    private String appellation;//Mr. Miss. Ms.
    private String username;
//    private String password;
    private String imgUrl;
    private String organization;
    private String department;
    private String workArea;
    private String professional;
    private String email;
    private String phone;
    private String mobile;
    private String authority;
    private String role;
    private Boolean isDCRemember;
    private Boolean deleted;

    public UserUpdateCommand() {
    }
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public String getWorkArea() {
        return workArea;
    }

    public void setWorkArea(String workArea) {
        this.workArea = workArea;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
    public Boolean getIsDCRemember() {
        return isDCRemember;
    }

    public void setIsDCRemember(Boolean DCRemember) {
        isDCRemember = DCRemember;
    }
}
