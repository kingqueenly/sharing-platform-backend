package com.benz.usecase.application;

import com.benz.framework.domain.ServiceCommand;

/**
 * Created by hongying.fu on 1/13/2017.
 */
public class CommentCommand extends ServiceCommand {
    private Long useCaseId;
    private String content;
    private Long parentCommentId;

    public CommentCommand() {
    }

    public Long getUseCaseId() {
        return useCaseId;
    }

    public void setUseCaseId(Long useCaseId) {
        this.useCaseId = useCaseId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public CommentCommand(Long useCaseId, String content, Long parentCommentId) {
        this.useCaseId = useCaseId;
        this.content = content;
        this.parentCommentId = parentCommentId;
    }
}
