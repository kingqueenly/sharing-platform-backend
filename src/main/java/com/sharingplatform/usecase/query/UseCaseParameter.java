package com.benz.usecase.query;

import com.benz.framework.domain.QueryParameter;

/**
 * Created by hongying.fu on 12/16/2016.
 */
public class UseCaseParameter extends QueryParameter {
    private String subject;
    private String valueType;
    private Long createUserId;
    private Long likeUserId;
    private String contributionBU;
    private String phase;
    private String stage;
    private String objective;
    private String company;
    private String dept;

    public UseCaseParameter(String subject, String valueType, Long createUserId, Long likeUserId, String contributionBU, String phase, String stage, String objective, String company, String dept) {
        this.subject = subject;
        this.valueType = valueType;
        this.createUserId = createUserId;
        this.likeUserId = likeUserId;
        this.contributionBU = contributionBU;
        this.phase = phase;
        this.stage = stage;
        this.objective = objective;
        this.company = company;
        this.dept = dept;
    }

    public UseCaseParameter() {
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getLikeUserId() {
        return likeUserId;
    }

    public void setLikeUserId(Long likeUserId) {
        this.likeUserId = likeUserId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getContributionBU() {
        return contributionBU;
    }

    public void setContributionBU(String contributionBU) {
        this.contributionBU = contributionBU;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
