package com.sharingplatform.usecase.adapter.listener;

import com.sharingplatform.framework.domain.DomainEventListener;
import com.sharingplatform.usecase.domain.CaseCommentLikeShare;
import com.sharingplatform.usecase.domain.DomainRegistry;
import com.sharingplatform.usecase.domain.UseCase;
import com.sharingplatform.usecase.domain.event.UseCaseViewedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by paulliu on 2017/1/17.
 */
@Component
public class UseCaseViewedListener2 implements DomainEventListener<UseCaseViewedEvent> {

    @EventListener
    @Override
    public void handle(UseCaseViewedEvent domainEvent) {
        UseCase useCase = DomainRegistry.useCaseRepository().getOne(domainEvent.getUseCaseId());
        CaseCommentLikeShare caseCommentLikeShare = useCase.getCaseCommentLikeShare();
        caseCommentLikeShare.addViewNum();
    }
}
