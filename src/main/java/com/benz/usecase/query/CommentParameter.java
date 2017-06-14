package com.benz.usecase.query;

import com.benz.framework.domain.QueryParameter;

/**
 * Created by hongying.fu on 1/13/2017.
 */
public class CommentParameter extends QueryParameter{
    private String useCaseId;

    public CommentParameter() {
    }

    public CommentParameter(String useCaseId) {
        this.useCaseId = useCaseId;
    }

    public String getUseCaseId() {
        return useCaseId;
    }

    public void setUseCaseId(String useCaseId) {
        this.useCaseId = useCaseId;
    }
}
