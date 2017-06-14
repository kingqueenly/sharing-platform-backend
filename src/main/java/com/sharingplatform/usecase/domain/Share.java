package com.benz.usecase.domain;

import com.benz.framework.domain.DomainEventPublisher;
import com.benz.usecase.domain.event.UseCaseSharedEvent;

import java.util.Date;

/**
 * Created by hongying.fu on 1/9/2017.
 */
public class Share {
    private Long id;
    private Long useCaseId;
    private UserInfo userInfo;
    private Date createTime;

    public Share() {
    }

    public Share(Long useCaseId, UserInfo userInfo) {
        this.id = DomainRegistry.shareRepository().nextIdentity();
        this.useCaseId = useCaseId;
        this.userInfo = userInfo;
        this.createTime = new Date(System.currentTimeMillis());
    }

    public void create() {
        DomainRegistry.shareRepository().save(this);

        UseCase useCase = DomainRegistry.useCaseRepository().findOne(this.useCaseId);
        CaseCommentLikeShare caseCommentLikeShare = useCase.getCaseCommentLikeShare();
        caseCommentLikeShare.addShareNum();

        DomainEventPublisher.publishEvent(new UseCaseSharedEvent(this.userInfo.getId(), this.useCaseId));
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
}
