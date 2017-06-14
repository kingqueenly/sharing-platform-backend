package com.benz.user.adapter.listener;

import com.benz.framework.domain.DomainEventListener;
import com.benz.usecase.domain.event.AttachmentDownloadedEvent;
import com.benz.user.domain.score.DownloadRule;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by paulliu on 2017/1/17.
 */
@Component
public class AttachmentDownloadedListener implements DomainEventListener<AttachmentDownloadedEvent> {

    @EventListener
    @Override
    public void handle(AttachmentDownloadedEvent domainEvent) {
        new DownloadRule(domainEvent.getOperatorId()).execute();
    }
}