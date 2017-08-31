package com.sharingplatform.faq.application;

import com.sharingplatform.framework.domain.ServiceCommand;

import java.util.Date;

/**
 * Created by AMC on 2017/6/27.
 */
public class QuestionUpdateCommand extends ServiceCommand {

    private Long id;
    private String answer;
    private Boolean useful;

    public Boolean getUseful() {
        return useful;
    }

    public void setUseful(Boolean useful) {
        this.useful = useful;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
