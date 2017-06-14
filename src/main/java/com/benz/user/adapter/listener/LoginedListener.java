package com.benz.user.adapter.listener;

import com.benz.framework.domain.DomainEventListener;
import com.benz.user.domain.event.LoginedEvent;
import com.benz.user.domain.score.LoginRule;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by paulliu on 2017/1/17.
 */
@Component
public class LoginedListener implements DomainEventListener<LoginedEvent> {

    @EventListener
    @Override
    public void handle(LoginedEvent domainEvent) {
        new LoginRule(domainEvent.getOperatorId()).execute();
    }
}