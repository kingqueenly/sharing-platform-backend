package com.sharingplatform.user.application;

import com.sharingplatform.user.ProvisioningServiceServiceStub;

/**
 * Created by paulliu on 2016/12/7.
 */
public class UserCreateCommand extends UserCommand {
    private Long id;
    private String userId;
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
    private Integer score;
    private String level;
    private String authority;
    private String role;
    private Boolean isDCRemember;

    public UserCreateCommand() {
    }

    public UserCreateCommand(ProvisioningServiceServiceStub.ChangeRecord changeRecord) {
        this.authority = "user";
        this.isDCRemember = false;
        ProvisioningServiceServiceStub.ArrayOfAttribute arrayOfAttribute = changeRecord.getNewAttrs();
        ProvisioningServiceServiceStub.Attribute[] attributes = arrayOfAttribute.getItem();
        this.id = changeRecord.getId();
        for (ProvisioningServiceServiceStub.Attribute attr : attributes) {
            String attrName = attr.getName();
            String attrValue = "";
            if (attr.getValues() != null && attr.getValues().getItem() != null) {
                attrValue = attr.getValues().getItem()[0];
            }

            if ("c".equals(attrName)) {

            } else if ("cn".equals(attrName)) {
                this.username = attrValue;
            } else if ("dcxDepartmentAbbr".equals(attrName)) {
                this.department = attrValue;
            } else if ("dcxDepartmentName".equals(attrName)) {

            } else if ("dcxLocationCode".equals(attrName)) {

            } else if ("dcxPlant1".equals(attrName)) {
                this.organization = plants.get(attrValue);
            } else if ("dcxSex".equals(attrName)) {

            } else if ("uid".equals(attrName)) {
                this.userId = attrValue;
            } else if ("mobile".equals(attrName)) {
                this.mobile = attrValue;
            } else if ("mail".equals(attrName)) {
                this.email = attrValue;
            } else if ("telephoneNumber".equals(attrName)) {
                this.phone = attrValue;
            }
        }
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
    public Boolean getIsDCRemember() {
        return isDCRemember;
    }

    public void setIsDCRemember(Boolean DCRemember) {
        isDCRemember = DCRemember;
    }
}
