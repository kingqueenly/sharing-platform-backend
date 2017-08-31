package com.sharingplatform.faq.application;

import com.sharingplatform.faq.domain.Question;
import com.sharingplatform.faq.domain.QuestionRepository;
import com.sharingplatform.faq.domain.event.QuestionAskedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by AMC on 2017/6/27.
 */
@Service
public class QuestionApplicationService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    public Long createQuestion(QuestionCreateCommand command) {
        Question question = new Question(command.getQuestion(), command.getOperatorId());
        question.create();

        this.publisher.publishEvent(new QuestionAskedEvent(command.getOperatorId(),question.getId()));

        return question.getId();
    }

    public void replyQuestion(QuestionUpdateCommand command) {
        Question question = questionRepository.findOne(command.getId());
        question.setAnswer(command.getAnswer());
        question.setReplyerId(command.getOperatorId());
        question.setReplyTime(new Date());
        question.update();
    }

    public void updateQuestion(QuestionUpdateCommand command) {
        Question question = questionRepository.findOne(command.getId());
        question.setUsefull(command.getUseful());
        question.update();
    }
}
