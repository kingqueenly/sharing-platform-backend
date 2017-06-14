package com.sharingplatform.user.adapter.listener;

import com.sharingplatform.framework.domain.DomainEventListener;
import com.sharingplatform.usecase.domain.event.CommentDeletedEvent;
import com.sharingplatform.user.domain.score.DeleteCommentRule;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by paulliu on 2017/1/17.
 */
@Component
public class CommentDeletedListener implements DomainEventListener<CommentDeletedEvent> {

    @EventListener
    @Override
    public void handle(CommentDeletedEvent domainEvent) {
        new DeleteCommentRule(domainEvent.getOperatorId()).execute();
    }
}