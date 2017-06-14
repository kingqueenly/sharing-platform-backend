package com.benz.user.adapter.listener;

import com.benz.framework.domain.DomainEventListener;
import com.benz.usecase.domain.event.CommentCreatedEvent;
import com.benz.user.domain.score.CommentRule;
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