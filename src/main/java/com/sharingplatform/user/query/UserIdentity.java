package com.sharingplatform.user.query;

/**
 * Created by paulliu on 2017/1/17.
 */
public class UserIdentity {
    private String id;
    private String username;
    private String role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserIdentity() {
    }
}
