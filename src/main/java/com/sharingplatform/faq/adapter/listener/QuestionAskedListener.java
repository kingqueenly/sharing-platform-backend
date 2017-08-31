package com.sharingplatform.faq.adapter.listener;

import com.sharingplatform.faq.domain.event.QuestionAskedEvent;
import com.sharingplatform.framework.MailService;
import com.sharingplatform.framework.domain.DomainEventListener;
import com.sharingplatform.usecase.domain.CaseCommentLikeShare;
import com.sharingplatform.usecase.domain.DomainRegistry;
import com.sharingplatform.usecase.domain.UseCase;
import com.sharingplatform.usecase.domain.event.UseCaseViewedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by paulliu on 2017/1/17.
 */
@Component
public class QuestionAskedListener implements DomainEventListener<QuestionAskedEvent> {

    @Autowired
    MailService mailService;

    @EventListener
    @Override
    public void handle(QuestionAskedEvent domainEvent) {
        String to = "19977735@qq.com";
        String subject = "someone asked you a question";
        String content = "question content";
        mailService.sendSimpleMail(to, subject, content);
    }
}
