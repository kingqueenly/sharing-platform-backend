package com.sharingplatform.usecase.domain.event;

/**
 * Created by paulliu on 2017/1/17.
 */
public class UseCaseLikedEvent extends UseCaseEvent {

    public UseCaseLikedEvent(Long operatorId, Long caseId) {
        super(operatorId, caseId);
    }
}
