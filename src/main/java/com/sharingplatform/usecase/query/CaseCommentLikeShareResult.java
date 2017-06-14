package com.sharingplatform.usecase.query;

import com.sharingplatform.usecase.domain.DomainRegistry;

/**
 * Created by hongying.fu on 1/14/2017.
 */
public class CaseCommentLikeShareResult {
    private String id;
    private Integer likeNum;
    private Integer commentNum;
    private Integer shareNum;
    private Integer viewNum;

    public CaseCommentLikeShareResult() {
    }

    public CaseCommentLikeShareResult(String id, Integer likeNum, Integer commentNum, Integer shareNum, Integer viewNum) {
        this.id = id;
        this.likeNum = likeNum;
        this.commentNum = commentNum;
        this.shareNum = shareNum;
        this.viewNum = viewNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
