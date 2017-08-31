package com.sharingplatform.datagovernance.query;

import java.util.Date;

/**
 * Created by AMC on 2017/8/18.
 */
public class TaskResult {
    private Long id;
    private Long flowInstanceId;
    private String taskKey;
    private String stepKey;
    private String applicationName;
    private String userId;
    private Date createTime;
    private Date updateTime;
    private Long applicationFormId;
    private String status;
    private String comments;
    private String buttonName;
    private Date applicationSubmitTime;
    private String applicant;
    private Long prevFormId;

    public Long getPrevFormId() {
        return prevFormId;
    }

    public void setPrevFormId(Long prevFormId) {
        this.prevFormId = prevFormId;
    }

    public Date getApplicationSubmitTime() {
        return applicationSubmitTime;
    }

    public void setApplicationSubmitTime(Date applicationSubmitTime) {
        this.applicationSubmitTime = applicationSubmitTime;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFlowInstanceId() {
        return flowInstanceId;
    }

    public void setFlowInstanceId(Long flowInstanceId) {
        this.flowInstanceId = flowInstanceId;
    }

    public String getTaskKey() {
        return taskKey;
    }

    public void setTaskKey(String taskKey) {
        this.taskKey = taskKey;
    }

    public String getStepKey() {
        return stepKey;
    }

    public void setStepKey(String stepKey) {
        this.stepKey = stepKey;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getApplicationFormId() {
        return applicationFormId;
    }

    public void setApplicationFormId(Long applicationFormId) {
        this.applicationFormId = applicationFormId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

}
