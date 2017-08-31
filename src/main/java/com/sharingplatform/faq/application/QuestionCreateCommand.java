package com.sharingplatform.faq.application;

import com.sharingplatform.framework.domain.ServiceCommand;

/**
 * Created by AMC on 2017/6/27.
 */
public class QuestionCreateCommand extends ServiceCommand {

    private String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
