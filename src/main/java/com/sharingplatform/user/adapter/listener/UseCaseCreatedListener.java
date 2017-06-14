package com.sharingplatform.user.adapter.listener;

import com.sharingplatform.framework.domain.DomainEventListener;
import com.sharingplatform.usecase.domain.event.UseCaseCreatedEvent;
import com.sharingplatform.user.domain.score.CreateCaseRule;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by paulliu on 2017/1/17.
 */
@Component
public class UseCaseCreatedListener implements DomainEventListener<UseCaseCreatedEvent> {

    @EventListener
    @Override
    public void handle(UseCaseCreatedEvent domainEvent) {
        new CreateCaseRule(domainEvent.getOperatorId()).execute();
    }
}