package com.sharingplatform.usecase.application;

import com.sharingplatform.usecase.domain.ContributionBU;

import java.util.List;

/**
 * Created by paulliu on 2016/12/13.
 */
public class UseCaseUpdateCommand {

    private Long id;
    private String subject;
    private List<ValueCommand> values;
    private String scenario;
    private List<ValueCommand>  dataSource;
    private String dataTypeDescription;
    private List<ValueCommand>  dataAnalysisModel;
    private String analysisMethodResultText;
    private List<FileCommand> analysisMethodResultFiles;
    private String validationMethodResultText;
    private List<FileCommand> validationMethodResultFiles;
    private String implMethodResultText;
    private List<FileCommand> implMethodResultFiles;
    private List<ContributionBU> contributionBU;
    private String stage;
    private String fromDate;
    private String toDate;
//    private String contact;
    private String needHelp;
    private List<AttachmentCommand> attachments;
    private String phase;
    public UseCaseUpdateCommand() {
    }

    public UseCaseUpdateCommand(Long id, String subject, List<ValueCommand> values, String scenario, List<ValueCommand> dataSource, String dataTypeDescription, List<ValueCommand> dataAnalysisModel, String analysisMethodResultText, List<FileCommand> analysisMethodResultFiles, String validationMethodResultText, List<FileCommand> validationMethodResultFiles, String implMethodResultText, List<FileCommand> implMethodResultFiles, List<ContributionBU> contributionBU, String stage, String fromDate, String toDate, String needHelp, List<AttachmentCommand> attachments, String phase) {
        this.id = id;
        this.subject = subject;
        this.values = values;
        this.scenario = scenario;
        this.dataSource = dataSource;
        this.dataTypeDescription = dataTypeDescription;
        this.dataAnalysisModel = dataAnalysisModel;
        this.analysisMethodResultText = analysisMethodResultText;
        this.analysisMethodResultFiles = analysisMethodResultFiles;
        this.validationMethodResultText = validationMethodResultText;
        this.validationMethodResultFiles = validationMethodResultFiles;
        this.implMethodResultText = implMethodResultText;
        this.implMethodResultFiles = implMethodResultFiles;
        this.contributionBU = contributionBU;
        this.stage = stage;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.needHelp = needHelp;
        this.attachments = attachments;
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<ValueCommand> getValues() {
        return values;
    }

    public void setValues(List<ValueCommand> values) {
        this.values = values;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getValidationMethodResultText() {
        return validationMethodResultText;
    }

    public void setValidationMethodResultText(String validationMethodResultText) {
        this.validationMethodResultText = validationMethodResultText;
    }

    public List<FileCommand> getValidationMethodResultFiles() {
        return validationMethodResultFiles;
    }

    public void setValidationMethodResultFiles(List<FileCommand> validationMethodResultFiles) {
        this.validationMethodResultFiles = validationMethodResultFiles;
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

    public List<FileCommand> getAnalysisMethodResultFiles() {
        return analysisMethodResultFiles;
    }

    public void setAnalysisMethodResultFiles(List<FileCommand> analysisMethodResultFiles) {
        this.analysisMethodResultFiles = analysisMethodResultFiles;
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

    public List<ValueCommand> getDataSource() {
        return dataSource;
    }

    public void setDataSource(List<ValueCommand> dataSource) {
        this.dataSource = dataSource;
    }

    public List<ValueCommand> getDataAnalysisModel() {
        return dataAnalysisModel;
    }

    public void setDataAnalysisModel(List<ValueCommand> dataAnalysisModel) {
        this.dataAnalysisModel = dataAnalysisModel;
    }

    public String getImplMethodResultText() {
        return implMethodResultText;
    }

    public void setImplMethodResultText(String implMethodResultText) {
        this.implMethodResultText = implMethodResultText;
    }

    public List<FileCommand> getImplMethodResultFiles() {
        return implMethodResultFiles;
    }

    public void setImplMethodResultFiles(List<FileCommand> implMethodResultFiles) {
        this.implMethodResultFiles = implMethodResultFiles;
    }

    public String getNeedHelp() {
        return needHelp;
    }

    public void setNeedHelp(String needHelp) {
        this.needHelp = needHelp;
    }

    public List<AttachmentCommand> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<AttachmentCommand> attachments) {
        this.attachments = attachments;
    }
}
