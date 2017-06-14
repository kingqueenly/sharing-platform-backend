package com.sharingplatform.usecase.domain;

/**
 * Created by hongying.fu on 1/9/2017.
 */
public class CaseCommentLikeShare {
    private Long id;
    private Integer likeNum;
    private Integer commentNum;
    private Integer shareNum;
    private Integer viewNum;

    public CaseCommentLikeShare() {
    }

    public CaseCommentLikeShare(Integer likeNum, Integer commentNum, Integer shareNum, Integer viewNum) {
        this.id = DomainRegistry.caseCommentLikeShareRepository().nextIdentity();
        this.likeNum = likeNum;
        this.commentNum = commentNum;
        this.shareNum = shareNum;
        this.viewNum = viewNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getShareNum() {
        return shareNum;
    }

    public void setShareNum(Integer shareNum) {
        this.shareNum = shareNum;
    }

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }

    public void addShareNum() {
        setShareNum(++shareNum);
        DomainRegistry.caseCommentLikeShareRepository().save(this);
    }

    public void addLikeNum() {
        setLikeNum(++likeNum);
        DomainRegistry.caseCommentLikeShareRepository().save(this);
    }

    public void subLikeNum() {
        setLikeNum(--likeNum);
        DomainRegistry.caseCommentLikeShareRepository().save(this);
    }

    public void addViewNum() {
        setViewNum(++viewNum);
        DomainRegistry.caseCommentLikeShareRepository().save(this);
    }

    public void addCommentNum() {
        setCommentNum(++commentNum);
        DomainRegistry.caseCommentLikeShareRepository().save(this);

    }

    public void subCommentNum(Integer count) {
        setCommentNum(commentNum-count);
        DomainRegistry.caseCommentLikeShareRepository().save(this);

    }
}
