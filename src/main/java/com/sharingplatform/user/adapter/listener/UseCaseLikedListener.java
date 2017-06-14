package com.sharingplatform.user.adapter.listener;

import com.sharingplatform.framework.domain.DomainEventListener;
import com.sharingplatform.usecase.domain.event.UseCaseLikedEvent;
import com.sharingplatform.user.domain.score.LikeRule;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by paulliu on 2017/1/17.
 */
@Component
public class UseCaseLikedListener implements DomainEventListener<UseCaseLikedEvent> {

    @EventListener
    @Override
    public void handle(UseCaseLikedEvent domainEvent) {
        new LikeRule(domainEvent.getOperatorId()).execute();
    }
}