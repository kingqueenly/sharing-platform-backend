package com.sharingplatform.datagovernance.query;

import com.sharingplatform.framework.domain.QueryParameter;

/**
 * Created by AMC on 2017/8/18.
 */
public class TaskQueryParameter extends QueryParameter {
    private String userId;
    private String status;
    private Long flowInstanceId;
    private Long taskId;

    public Long getFlowInstanceId() {
        return flowInstanceId;
    }

    public void setFlowInstanceId(Long flowInstanceId) {
        this.flowInstanceId = flowInstanceId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
