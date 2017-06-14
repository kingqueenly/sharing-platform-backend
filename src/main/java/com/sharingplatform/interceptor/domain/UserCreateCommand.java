package com.sharingplatform.interceptor.domain;

/**
 * Created by hongying.fu on 4/12/2017.
 */
public class UserCreateCommand {
    private String userId;
    private String authority;
    private Boolean isDCRemember;

    public UserCreateCommand() {
    }

    public UserCreateCommand(String userId, String authority, Boolean isDCRemember) {
        this.userId = userId;
        this.authority = authority;
        this.isDCRemember = isDCRemember;
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

    public Boolean getIsDCRemember() {
        return isDCRemember;
    }

    public void setIsDCRemember(Boolean DCRemember) {
        isDCRemember = DCRemember;
    }
}
