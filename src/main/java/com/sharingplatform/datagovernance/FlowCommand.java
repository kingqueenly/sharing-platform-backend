package com.sharingplatform.datagovernance;

import com.sharingplatform.datagovernance.application.DataUsageApplicationCommand;

/**
 * Created by AMC on 2017/8/17.
 */
public class FlowCommand {

    private DataUsageApplicationCommand application;
    private String comments;
    private String supervisor;
    private String stepKey;
    private String taskKey;
    private String buttonName;
    private String userId;
    private Long taskId;

    public DataUsageApplicationCommand getApplication() {
        return application;
    }

    public void setApplication(DataUsageApplicationCommand application) {
        this.application = application;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getStepKey() {
        return stepKey;
    }

    public void setStepKey(String stepKey) {
        this.stepKey = stepKey;
    }

    public String getTaskKey() {
        return taskKey;
    }

    public void setTaskKey(String taskKey) {
        this.taskKey = taskKey;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}
