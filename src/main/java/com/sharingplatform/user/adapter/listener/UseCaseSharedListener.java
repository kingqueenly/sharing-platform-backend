package com.benz.user.adapter.listener;

import com.benz.framework.domain.DomainEventListener;
import com.benz.usecase.domain.event.UseCaseSharedEvent;
import com.benz.user.domain.score.ShareRule;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by paulliu on 2017/1/17.
 */
@Component
public class UseCaseSharedListener implements DomainEventListener<UseCaseSharedEvent> {

    @EventListener
    @Override
    public void handle(UseCaseSharedEvent domainEvent) {
        new ShareRule(domainEvent.getOperatorId()).execute();
    }
}