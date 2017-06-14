package com.sharingplatform.usecase.domain;

import com.sharingplatform.framework.domain.DomainEventPublisher;
import com.sharingplatform.usecase.domain.event.CommentCreatedEvent;

import java.util.Date;

/**
 * Created by hongying.fu on 1/9/2017.
 */
public class Comment {
    private Long id;
    private Long useCaseId;
    private String content;
    private Date createTime;
    private UserInfo fromUserInfo;
    private Comment comment;

    public Comment() {
    }

    public Comment(Long useCaseId, String content, Comment parentComment, UserInfo fromUserInfo) {
        this.id = DomainRegistry.commentRepository().nextIdentity();
        this.useCaseId = useCaseId;
        this.content = content;
        this.createTime = new Date(System.currentTimeMillis());
        this.fromUserInfo = fromUserInfo;
        this.comment = parentComment;
    }

    public void create() {
        DomainRegistry.commentRepository().save(this);

        UseCase useCase = DomainRegistry.useCaseRepository().findOne(this.useCaseId);
        CaseCommentLikeShare caseCommentLikeShare = useCase.getCaseCommentLikeShare();
        caseCommentLikeShare.addCommentNum();

        DomainEventPublisher.publishEvent(new CommentCreatedEvent(this.fromUserInfo.getId(), this.useCaseId));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public UserInfo getFromUserInfo() {
        return fromUserInfo;
    }

    public void setFromUserInfo(UserInfo fromUserInfo) {
        this.fromUserInfo = fromUserInfo;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public void delete() {
        DomainRegistry.commentRepository().delete(this);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", useCaseId=" + useCaseId +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", fromUserInfo=" + fromUserInfo +
                '}';
    }
}
