package com.sharingplatform.framework.domain;

/**
 * Created by hongying.fu on 12/21/2016.
 */
public class QueryParameter implements Operator {
    private Long operatorId;

    public QueryParameter() {
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
