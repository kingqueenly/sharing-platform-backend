package com.sharingplatform.usecase.query;

import java.util.Date;
import java.util.List;

/**
 * Created by hongying.fu on 1/13/2017.
 */
public class CommentResult {
    private String id;
    private String content;
    private Date createTime;
    private Long userId;
    private String userName;
    private String userImgUrl;
    private List<CommentResult> children;

    public CommentResult() {
    }

    public CommentResult(String id, String content, Date createTime, String userName, String userImgUrl, List<CommentResult> children) {
        this.id = id;
        this.content = content;
        this.createTime = createTime;
        this.userName = userName;
        this.userImgUrl = userImgUrl;
        this.children = children;
    }

    public CommentResult(String id, String content, Date createTime, Long userId, String userName, String userImgUrl, List<CommentResult> children) {
        this.id = id;
        this.content = content;
        this.createTime = createTime;
        this.userId = userId;
        this.userName = userName;
        this.userImgUrl = userImgUrl;
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImgUrl() {
        return userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }

    public List<CommentResult> getChildren() {
        return children;
    }

    public void setChildren(List<CommentResult> children) {
        this.children = children;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
