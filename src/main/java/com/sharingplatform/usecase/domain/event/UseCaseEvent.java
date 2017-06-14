package com.benz.usecase.domain.event;

import com.benz.framework.domain.DomainEvent;

/**
 * Created by paulliu on 2017/1/17.
 */
public abstract class UseCaseEvent implements DomainEvent {

    private Long operatorId;
    private Long caseId;

    @Override
    public Long getOperatorId() {
        return operatorId;
    }

    public Long getUseCaseId() {
        return caseId;
    }

    public UseCaseEvent(Long operatorId, Long caseId) {
        this.operatorId = operatorId;
        this.caseId = caseId;
    }
}
