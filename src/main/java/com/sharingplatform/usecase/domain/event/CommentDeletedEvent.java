package com.benz.usecase.domain.event;

/**
 * Created by paulliu on 2017/1/17.
 */
public class CommentDeletedEvent extends UseCaseEvent {

    public CommentDeletedEvent(Long operatorId, Long caseId) {
        super(operatorId, caseId);
    }
}
