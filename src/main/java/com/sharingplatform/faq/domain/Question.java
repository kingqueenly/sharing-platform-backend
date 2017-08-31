package com.sharingplatform.faq.domain;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by AMC on 2017/6/27.
 */
public class Question {

    private Long id;
    private Boolean useful;
    @Column(columnDefinition = "varchar2(500)")
    private String question;
    private Long replyerId;
    private Date replyTime;
    @Column(columnDefinition = "varchar2(2000)")
    private String answer;
    private Long creatorId;
    private Date createTime;

    public Question() {
    }

    public Question(String question, Long creatorId) {
        this.id = DomainRegistry.questionRepository().nextIdentity();
        this.question = question;
        this.createTime = new Date();
        this.creatorId = creatorId;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getUseful() {
        return useful;
    }

    public void setUsefull(Boolean useful) {
        this.useful = useful;
    }

    public void setReplyerId(Long replyerId) {
        this.replyerId = replyerId;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void create() {
        DomainRegistry.questionRepository().save(this);
    }

    public void update() {
        DomainRegistry.questionRepository().save(this);
    }

}