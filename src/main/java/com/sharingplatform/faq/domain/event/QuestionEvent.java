package com.sharingplatform.faq.domain.event;

import com.sharingplatform.framework.domain.DomainEvent;

/**
 * Created by AMC on 2017/8/2.
 */
public abstract class QuestionEvent implements DomainEvent {

    Long operatorId;
    Long questionId;

    @Override
    public Long getOperatorId() {
        return operatorId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public QuestionEvent(Long operatorId, Long questionId) {
        this.operatorId = operatorId;
        this.questionId = questionId;
    }
}
