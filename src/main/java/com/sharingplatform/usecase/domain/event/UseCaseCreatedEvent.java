package com.sharingplatform.usecase.domain.event;

/**
 * Created by paulliu on 2017/1/17.
 */
public class UseCaseCreatedEvent extends UseCaseEvent {
    public UseCaseCreatedEvent(Long operatorId, Long caseId) {
        super(operatorId, caseId);
    }
}
