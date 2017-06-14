package com.benz.user.adapter.listener;

import com.benz.framework.domain.DomainEventListener;
import com.benz.usecase.domain.event.UseCaseViewedEvent;
import com.benz.user.domain.score.ViewCaseRule;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by paulliu on 2017/1/17.
 */
@Component
public class UseCaseViewedListener implements DomainEventListener<UseCaseViewedEvent> {

    @EventListener
    @Override
    public void handle(UseCaseViewedEvent domainEvent) {
        new ViewCaseRule(domainEvent.getOperatorId()).execute();
    }
}