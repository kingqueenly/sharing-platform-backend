package com.benz.usecase.domain.event;

/**
 * Created by paulliu on 2017/1/17.
 */
public class CommentCreatedEvent extends UseCaseEvent {

    public CommentCreatedEvent(Long operatorId, Long caseId) {
        super(operatorId, caseId);
    }
}
