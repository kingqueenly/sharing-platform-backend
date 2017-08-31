package com.sharingplatform.usecase.domain;

import javax.persistence.*;

import com.sharingplatform.framework.domain.DomainEventPublisher;
import com.sharingplatform.usecase.domain.event.UseCaseCreatedEvent;

import java.util.Date;
import java.util.List;

/**
 * Created by paulliu on 2016/12/12.
 */
public class UseCase {
    private Long id;
    private CaseSubject subject;
//    private ValueList values;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinTable(
        name="use_case_value",
        joinColumns=@JoinColumn(name="use_case_id", referencedColumnName="ID"),
        inverseJoinColumns=@JoinColumn(name="value_id", referencedColumnName="ID"))
    private List<Value> values;
    @Column(columnDefinition = "varchar2(4000)")
    private String scenario;
//    private DataSourceList dataSources;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinTable(
        name="use_case_data_source",
        joinColumns=@JoinColumn(name="use_case_id", referencedColumnName="ID"),
        inverseJoinColumns=@JoinColumn(name="data_source_id", referencedColumnName="ID"))
    private List<DataSource> dataSources;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinTable(
            name="use_case_contributionbu",
            joinColumns=@JoinColumn(name="use_case_id", referencedColumnName="ID"),
            inverseJoinColumns=@JoinColumn(name="contributionbu_id", referencedColumnName="ID"))
    private List<ContributionBU> contributionBU;

    @Column(columnDefinition = "varchar2(4000)")
    private String dataTypeDescription;
//    private DataAnalysisModelList dataAnalysisModels;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @JoinTable(
        name="use_case_data_analysis_model",
        joinColumns=@JoinColumn(name="use_case_id", referencedColumnName="ID"),
        inverseJoinColumns=@JoinColumn(name="data_analysis_model_id", referencedColumnName="ID"))
    private List<DataAnalysisModel> dataAnalysisModels;
    @Column(columnDefinition = "varchar2(500)")
    private String dataAnalysisModelOther;
    @Column(columnDefinition = "varchar2(500)")
    private String dataSourceOther;
    private AnalysisMethodResult analysisMethodResult;
    private ValidationMethodResult validationMethodResult;
    private ImplMethodResult implMethodResult;
    private String stage;
    private TimeFrame timeFrame;
    @Column(columnDefinition = "varchar2(4000)")
    private String needHelp;
    private AttachmentList attachments;
    private CaseCommentLikeShare caseCommentLikeShare;
    private UserInfo userInfo;
    private Date createTime;
    private String referenceCase;
    private String phase;

    public String getReferenceCase() {
        return referenceCase;
    }

    public void setReferenceCase(String referenceCase) {
        this.referenceCase = referenceCase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CaseSubject getSubject() {
        return subject;
    }

    public void setSubject(CaseSubject subject) {
        this.subject = subject;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public ValidationMethodResult getValidationMethodResult() {
        return validationMethodResult;
    }

    public void setValidationMethodResult(ValidationMethodResult validationMethodResult) {
        this.validationMethodResult = validationMethodResult;
    }

    public List<DataSource> getDataSources() {
        return dataSources;
    }

    public void setDataSources(List<DataSource> dataSources) {
        this.dataSources = dataSources;
    }

    public String getDataTypeDescription() {
        return dataTypeDescription;
    }

    public void setDataTypeDescription(String dataTypeDescription) {
        this.dataTypeDescription = dataTypeDescription;
    }

    public AnalysisMethodResult getAnalysisMethodResult() {
        return analysisMethodResult;
    }

    public void setAnalysisMethodResult(AnalysisMethodResult analysisMethodResult) {
        this.analysisMethodResult = analysisMethodResult;
    }

    public ImplMethodResult getImplMethodResult() {
        return implMethodResult;
    }

    public void setImplMethodResult(ImplMethodResult implMethodResult) {
        this.implMethodResult = implMethodResult;
    }

    public List<ContributionBU> getContributionBU() {
        return contributionBU;
    }

    public void setContributionBU(List<ContributionBU> contributionBU) {
        this.contributionBU = contributionBU;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public TimeFrame getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(TimeFrame timeFrame) {
        this.timeFrame = timeFrame;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNeedHelp() {
        return needHelp;
    }

    public void setNeedHelp(String needHelp) {
        this.needHelp = needHelp;
    }

    public CaseCommentLikeShare getCaseCommentLikeShare() {
        return caseCommentLikeShare;
    }

    public void setCaseCommentLikeShare(CaseCommentLikeShare caseCommentLikeShare) {
        this.caseCommentLikeShare = caseCommentLikeShare;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<DataAnalysisModel> getDataAnalysisModels() {
        return dataAnalysisModels;
    }

    public void setDataAnalysisModels(List<DataAnalysisModel> dataAnalysisModels) {
        this.dataAnalysisModels = dataAnalysisModels;
    }

    public String getDataSourceOther() {
        return dataSourceOther;
    }

    public void setDataSourceOther(String dataSourceOther) {
        this.dataSourceOther = dataSourceOther;
    }

    public String getDataAnalysisModelOther(){ return dataAnalysisModelOther; }

    public void setDataAnalysisModelOther(String dataAnalysisModelOther){
        this.dataAnalysisModelOther = dataAnalysisModelOther;
    }

    public AttachmentList getAttachments() {
        return attachments;
    }

    public void setAttachments(AttachmentList attachments) {
        this.attachments = attachments;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public UseCase() {
    }

    public UseCase(CaseSubject subject, List<Value> values, String scenario, List<DataSource> dataSources, String dataSourceOther, String dataTypeDescription, List<DataAnalysisModel> dataAnalysisModels, String dataAnalysisModelOther, AnalysisMethodResult analysisMethodResult, ValidationMethodResult validationMethodResult, ImplMethodResult implMethodResult, List<ContributionBU> contributionBU, String stage, TimeFrame timeFrame, String needHelp, AttachmentList attachments, CaseCommentLikeShare caseCommentLikeShare, UserInfo userInfo, String referenceCase,String phase) {
        this.id = DomainRegistry.useCaseRepository().nextIdentity();
        this.subject = subject;
        this.values = values;
        this.scenario = scenario;
        this.dataSources = dataSources;
        this.dataSourceOther = dataSourceOther;
        this.dataTypeDescription = dataTypeDescription;
        this.dataAnalysisModels = dataAnalysisModels;
        this.dataAnalysisModelOther = dataAnalysisModelOther;
        this.analysisMethodResult = analysisMethodResult;
        this.validationMethodResult = validationMethodResult;
        this.implMethodResult = implMethodResult;
        this.contributionBU = contributionBU;
        this.stage = stage;
        this.timeFrame = timeFrame;
        this.needHelp = needHelp;
        this.attachments = attachments;
        this.caseCommentLikeShare = caseCommentLikeShare;
        this.userInfo = userInfo;
        this.createTime = new Date(System.currentTimeMillis());
        this.referenceCase = referenceCase;
        this.phase=phase;
    }

    public void create() {
        DomainRegistry.useCaseRepository().save(this);

        DomainEventPublisher.publishEvent(new UseCaseCreatedEvent(this.userInfo.getId(), this.id));
    }

    public void update(CaseSubject subject, List<Value> values, String scenario, List<DataSource> dataSource, String dataSourceOther, String dataTypeDescription, List<DataAnalysisModel> dataAnalysisModels,
                       String dataAnalysisModelOther, AnalysisMethodResult analysisMethodResult, ValidationMethodResult validationMethodResult, ImplMethodResult implMethodResult,
                       List<ContributionBU> contributionBU, String stage, TimeFrame timeFrame,
                       String help, List<Attachment> attachments,String phase) {
        setSubject(subject);
        setValues(values);
        setScenario(scenario);
        setDataSources(dataSource);
        setDataSourceOther(dataSourceOther);
        setDataTypeDescription(dataTypeDescription);
        setDataAnalysisModels(dataAnalysisModels);
        setDataAnalysisModelOther(dataAnalysisModelOther);
        setContributionBU(contributionBU);
        setStage(stage);
        setTimeFrame(timeFrame);
        setNeedHelp(help);
        this.attachments.resetTo(attachments);
        this.analysisMethodResult.resetTo(analysisMethodResult);
        this.validationMethodResult.resetTo(validationMethodResult);
        this.implMethodResult.resetTo(implMethodResult);
        setPhase(phase);

        DomainRegistry.useCaseRepository().save(this);
    }



    public void delete() {
        DomainRegistry.useCaseRepository().delete(this);
    }
}
