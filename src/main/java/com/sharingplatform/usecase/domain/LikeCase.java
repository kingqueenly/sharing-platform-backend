package com.benz.usecase.domain;

import com.benz.framework.domain.DomainEventPublisher;
import com.benz.usecase.domain.event.UseCaseLikedEvent;
import com.benz.usecase.domain.event.UseCaseUnLikedEvent;

import java.util.Date;

/**
 * Created by hongying.fu on 1/9/2017.
 */
public class LikeCase {
    private Long id;
    private Long useCaseId;
    private Date createTime;
    private UserInfo userInfo;

    public LikeCase() {
    }

    public LikeCase(Long useCaseId, UserInfo userInfo) {
        this.id = DomainRegistry.likeCaseRepository().nextIdentity();
        this.createTime = new Date(System.currentTimeMillis());
        this.useCaseId = useCaseId;
        this.userInfo = userInfo;
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

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void create() {
        DomainRegistry.likeCaseRepository().save(this);

        UseCase useCase = DomainRegistry.useCaseRepository().findOne(this.useCaseId);
        CaseCommentLikeShare caseCommentLikeShare = useCase.getCaseCommentLikeShare();
        caseCommentLikeShare.addLikeNum();

        DomainEventPublisher.publishEvent(new UseCaseLikedEvent(this.userInfo.getId(), this.useCaseId));
    }

    public void delete(Long caseId) {
        DomainRegistry.likeCaseRepository().delete(this);

        UseCase useCase = DomainRegistry.useCaseRepository().findOne(caseId);
        CaseCommentLikeShare caseCommentLikeShare = useCase.getCaseCommentLikeShare();
        caseCommentLikeShare.subLikeNum();

        DomainEventPublisher.publishEvent(new UseCaseUnLikedEvent(this.userInfo.getId(), this.useCaseId));

    }

}
