package com.sharingplatform.usecase.domain.event;

import com.sharingplatform.framework.domain.DomainEvent;

/**
 * Created by paulliu on 2017/1/17.
 */
public class AttachmentDownloadedEvent extends UseCaseEvent {

    public AttachmentDownloadedEvent(Long operatorId, Long caseId) {
        super(operatorId, caseId);
    }
}
