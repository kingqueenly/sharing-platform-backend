package com.sharingplatform.user.adapter.listener;

import com.sharingplatform.framework.domain.DomainEventListener;
import com.sharingplatform.usecase.domain.event.CommentCreatedEvent;
import com.sharingplatform.user.domain.score.CommentRule;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by paulliu on 2017/1/17.
 */
@Component
public class CommentCreatedListener implements DomainEventListener<CommentCreatedEvent> {

    @EventListener
    @Override
    public void handle(CommentCreatedEvent domainEvent) {
        new CommentRule(domainEvent.getOperatorId()).execute();
    }
}