package com.sharingplatform.faq.query;

import com.sharingplatform.framework.domain.QueryParameter;

/**
 * Created by AMC on 2017/6/28.
 */
public class FAQQueryParameter extends QueryParameter {

    private Long creatorId;
    private Long questionId;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

}
