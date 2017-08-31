package com.sharingplatform.faq.domain.event;

/**
 * Created by AMC on 2017/8/2.
 */
public class QuestionAskedEvent extends QuestionEvent {

    public QuestionAskedEvent(Long operatorId, Long questionId) {
        super(operatorId, questionId);
    }
}