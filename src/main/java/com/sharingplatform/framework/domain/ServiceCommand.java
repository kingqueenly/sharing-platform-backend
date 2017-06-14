package com.sharingplatform.framework.domain;

/**
 * Created by paulliu on 2017/1/16.
 */
public class ServiceCommand implements Operator {
    private Long operatorId;

    public ServiceCommand() {
    }

    @Override
    public Long getOperatorId() {
        return operatorId;
    }

    @Override
    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }
}
