package com.benz.usecase.query;

import java.util.Date;

/**
 * Created by hongying.fu on 1/16/2017.
 */
public class LikeCaseResult {
    private String id;
    private String useCaseId;
    private Date createTime;
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUseCaseId() {
        return useCaseId;
    }

    public void setUseCaseId(String useCaseId) {
        this.useCaseId = useCaseId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
