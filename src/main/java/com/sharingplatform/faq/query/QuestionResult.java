package com.sharingplatform.faq.query;

import java.util.Date;

/**
 * Created by AMC on 2017/6/28.
 */
public class QuestionResult {

    private Long id;
    private Boolean useful;
    private String question;
    private Long replyerId;
    private String replyTime;
    private String answer;
    private Long creatorId;
    private String createTime;

    private String creatorName;
    private String replyerName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getUseful() {
        return useful;
    }

    public void setUseful(Boolean useful) {
        this.useful = useful;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getReplyerId() {
        return replyerId;
    }

    public void setReplyerId(Long replyerId) {
        this.replyerId = replyerId;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getReplyerName() {
        return replyerName;
    }

    public void setReplyerName(String replyerName) {
        this.replyerName = replyerName;
    }

}
