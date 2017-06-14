package com.sharingplatform.user.adapter.listener;

import com.sharingplatform.framework.domain.DomainEventListener;
import com.sharingplatform.usecase.domain.event.UseCaseUnLikedEvent;
import com.sharingplatform.user.domain.score.UnLikeRule;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by paulliu on 2017/1/17.
 */
@Component
public class UseCaseUnLikedListener implements DomainEventListener<UseCaseUnLikedEvent> {

    @EventListener
    @Override
    public void handle(UseCaseUnLikedEvent domainEvent) {
        new UnLikeRule(domainEvent.getOperatorId()).execute();
    }
}