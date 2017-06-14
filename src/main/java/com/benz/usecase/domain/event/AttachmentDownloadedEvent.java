package com.benz.usecase.domain.event;

import com.benz.framework.domain.DomainEvent;

/**
 * Created by paulliu on 2017/1/17.
 */
public class AttachmentDownloadedEvent extends UseCaseEvent {

    public AttachmentDownloadedEvent(Long operatorId, Long caseId) {
        super(operatorId, caseId);
    }
}
