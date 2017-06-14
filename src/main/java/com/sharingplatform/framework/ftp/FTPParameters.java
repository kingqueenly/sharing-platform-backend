package com.benz.framework.ftp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by hongying.fu on 12/21/2016.
 */
@Component
@ConfigurationProperties(prefix = "ftp")
public class FTPParameters {
    private String url;
    private int port;
    private String username;
    private String password;
    private String attachmentDirectory;
    private String avatarDirectory;
    private String httpUrl;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAttachmentDirectory() {
        return attachmentDirectory;
    }

    public void setAttachmentDirectory(String attachmentDirectory) {
        this.attachmentDirectory = attachmentDirectory;
    }

    public String getAvatarDirectory() {
        return avatarDirectory;
    }

    public void setAvatarDirectory(String avatarDirectory) {
        this.avatarDirectory = avatarDirectory;
    }

    public String getHttpUrl() {
        return httpUrl;
    }

    public void setHttpUrl(String httpUrl) {
        this.httpUrl = httpUrl;
    }
}
