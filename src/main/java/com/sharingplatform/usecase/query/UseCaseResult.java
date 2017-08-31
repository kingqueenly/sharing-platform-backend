package com.sharingplatform.usecase.query;

import java.util.List;

/**
 * Created by hongying.fu on 12/15/2016.
 */
public class UseCaseResult {
    private String id;
    private String subject;
    private List<ValueResult> values;
    private String vtext;
    private String scenario;
    private List<ValueResult> dataSource;
    private String dataSourceOther;
    private String dataTypeDescription;
    private List<ValueResult> dataAnalysisModel;
    private String dataAnalysisModelOther;
    private String analysisMethodResultText;
    private String validationMethodResultText;
    private String implMethodResultText;
    private List<BUResult> contributionBU;
    private String stage;
    private String fromDate;
    private String toDate;
    private String needHelp;
    private String createTime;
    private List<FileResult> validationMethodResultFiles;
    private List<FileResult> analysisMethodResultFiles;
    private List<FileResult> implMethodResultFiles;
    private List<FileResult> attachments;
    private String viewNum;
    private String commentNum;
    private String likeNum;
    private String shareNum;
    private String userId;
    private String userName;
    private String email;
    private String userImgUrl;
    private String userDepartment;
    private Integer userScore;
    private String userLevel;
    private String referenceCase;
    private String phase;
    public UseCaseResult() {
    }

    public UseCaseResult(String email, String id, String subject, List<ValueResult> values, String vtext, String scenario, List<ValueResult> dataSource, String dataSourceOther, String dataTypeDescription, List<ValueResult> dataAnalysisModel, String dataAnalysisModelOther, String analysisMethodResultText, String validationMethodResultText, String implMethodResultText, List<BUResult> contributionBU, String stage, String fromDate, String toDate, String needHelp, String createTime, List<FileResult> validationMethodResultFiles, List<FileResult> analysisMethodResultFiles, List<FileResult> implMethodResultFiles, List<FileResult> attachments, String viewNum, String commentNum, String likeNum, String shareNum, String userId, String userName, String userImgUrl, String userDepartment, Integer userScore, String userLevel, String referenceCase, String phase) {
        this.id = id;
        this.email = email;
        this.subject = subject;
        this.values = values;
        this.vtext = vtext;
        this.scenario = scenario;
        this.dataSource = dataSource;
        this.dataSourceOther = dataSourceOther;
        this.dataTypeDescription = dataTypeDescription;
        this.dataAnalysisModel = dataAnalysisModel;
        this.dataAnalysisModelOther = dataAnalysisModelOther;
        this.analysisMethodResultText = analysisMethodResultText;
        this.validationMethodResultText = validationMethodResultText;
        this.implMethodResultText = implMethodResultText;
        this.contributionBU = contributionBU;
        this.stage = stage;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.needHelp = needHelp;
        this.createTime = createTime;
        this.validationMethodResultFiles = validationMethodResultFiles;
        this.analysisMethodResultFiles = analysisMethodResultFiles;
        this.implMethodResultFiles = implMethodResultFiles;
        this.attachments = attachments;
        this.viewNum = viewNum;
        this.commentNum = commentNum;
        this.likeNum = likeNum;
        this.shareNum = shareNum;
        this.userId = userId;
        this.userName = userName;
        this.userImgUrl = userImgUrl;
        this.userDepartment = userDepartment;
        this.userScore = userScore;
        this.userLevel = userLevel;
        this.referenceCase = referenceCase;
        this.phase=phase;
    }

    public String getReferenceCase() {
        return referenceCase;
    }

    public void setReferenceCase(String referenceCase) {
        this.referenceCase = referenceCase;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<ValueResult> getValues() {
        return values;
    }

    public void setValues(List<ValueResult> values) {
        this.values = values;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getDataTypeDescription() {
        return dataTypeDescription;
    }

    public void setDataTypeDescription(String dataTypeDescription) {
        this.dataTypeDescription = dataTypeDescription;
    }

    public String getAnalysisMethodResultText() {
        return analysisMethodResultText;
    }

    public void setAnalysisMethodResultText(String analysisMethodResultText) {
        this.analysisMethodResultText = analysisMethodResultText;
    }

    public String getValidationMethodResultText() {
        return validationMethodResultText;
    }

    public void setValidationMethodResultText(String validationMethodResultText) {
        this.validationMethodResultText = validationMethodResultText;
    }

    public String getImplMethodResultText() {
        return implMethodResultText;
    }

    public void setImplMethodResultText(String implMethodResultText) {
        this.implMethodResultText = implMethodResultText;
    }

    public List<BUResult> getContributionBU() {
        return contributionBU;
    }

    public void setContributionBU(List<BUResult> contributionBU) {
        this.contributionBU = contributionBU;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getNeedHelp() {
        return needHelp;
    }

    public void setNeedHelp(String needHelp) {
        this.needHelp = needHelp;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<FileResult> getValidationMethodResultFiles() {
        return validationMethodResultFiles;
    }

    public void setValidationMethodResultFiles(List<FileResult> validationMethodResultFiles) {
        this.validationMethodResultFiles = validationMethodResultFiles;
    }

    public List<FileResult> getAnalysisMethodResultFiles() {
        return analysisMethodResultFiles;
    }

    public void setAnalysisMethodResultFiles(List<FileResult> analysisMethodResultFiles) {
        this.analysisMethodResultFiles = analysisMethodResultFiles;
    }

    public List<FileResult> getImplMethodResultFiles() {
        return implMethodResultFiles;
    }

    public void setImplMethodResultFiles(List<FileResult> implMethodResultFiles) {
        this.implMethodResultFiles = implMethodResultFiles;
    }

    public List<FileResult> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<FileResult> attachments) {
        this.attachments = attachments;
    }

    public String getViewNum() {
        return viewNum;
    }

    public void setViewNum(String viewNum) {
        this.viewNum = viewNum;
    }

    public String getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(String commentNum) {
        this.commentNum = commentNum;
    }

    public String getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(String likeNum) {
        this.likeNum = likeNum;
    }

    public String getShareNum() {
        return shareNum;
    }

    public void setShareNum(String shareNum) {
        this.shareNum = shareNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImgUrl() {
        return userImgUrl;
    }

    public void setUserImgUrl(String userImgUrl) {
        this.userImgUrl = userImgUrl;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }

    public Integer getUserScore() {
        return userScore;
    }

    public void setUserScore(Integer userScore) {
        this.userScore = userScore;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public List<ValueResult> getDataSource() {
        return dataSource;
    }

    public void setDataSource(List<ValueResult> dataSource) {
        this.dataSource = dataSource;
    }

    public List<ValueResult> getDataAnalysisModel() {
        return dataAnalysisModel;
    }

    public void setDataAnalysisModel(List<ValueResult> dataAnalysisModel) {
        this.dataAnalysisModel = dataAnalysisModel;
    }

    public String getDataAnalysisModelOther() {
        return dataAnalysisModelOther;
    }

    public void setDataAnalysisModelOther(String dataAnalysisModelOther) {
        this.dataAnalysisModelOther = dataAnalysisModelOther;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataSourceOther() {
        return dataSourceOther;
    }

    public void setDataSourceOther(String dataSourceOther) {
        this.dataSourceOther = dataSourceOther;
    }

    public String getVtext() {
        return vtext;
    }

    public void setVtext(String vtext) {
        this.vtext = vtext;
    }

    @Override
    public String toString() {
        return "UseCaseResult{" +
                "id='" + id + '\'' +
                ", subject='" + subject + '\'' +
                ", vtext='" + vtext + '\'' +
                ", values='" + values + '\'' +
                ", scenario='" + scenario + '\'' +
                ", dataSource=" + dataSource +
                ", dataSourceOther=" + dataSourceOther +
                ", dataTypeDescription='" + dataTypeDescription + '\'' +
                ", dataAnalysisModel=" + dataAnalysisModel +
                ", dataAnalysisModelOther=" + dataAnalysisModelOther +
                ", analysisMethodResultText='" + analysisMethodResultText + '\'' +
                ", validationMethodResultText='" + validationMethodResultText + '\'' +
                ", implMethodResultText='" + implMethodResultText + '\'' +
                ", contributionBU='" + contributionBU + '\'' +
                ", stage='" + stage + '\'' +
                ", email='" + email + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", needHelp='" + needHelp + '\'' +
                ", createTime='" + createTime + '\'' +
                ", validationMethodResultFiles=" + validationMethodResultFiles +
                ", analysisMethodResultFiles=" + analysisMethodResultFiles +
                ", implMethodResultFiles=" + implMethodResultFiles +
                ", attachments=" + attachments +
                ", viewNum='" + viewNum + '\'' +
                ", commentNum='" + commentNum + '\'' +
                ", likeNum='" + likeNum + '\'' +
                ", shareNum='" + shareNum + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userImgUrl='" + userImgUrl + '\'' +
                ", userDepartment='" + userDepartment + '\'' +
                ", userScore=" + userScore +
                ", userLevel='" + userLevel + '\'' +
                ", referenceCase='" + referenceCase + '\'' +
                ", phase='" + phase + '\'' +
                '}';
    }
}
