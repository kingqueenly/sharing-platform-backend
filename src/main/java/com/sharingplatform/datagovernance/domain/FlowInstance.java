package com.sharingplatform.datagovernance.domain;

import org.apache.axis2.description.Flow;

import java.util.Date;

/**
 * Created by AMC on 2017/8/16.
 */
public class FlowInstance {
    private Long id;
    private Date createTime;
    private Date updateTime;
    private String status;
    private Long applicationFormId;
    private String applicationName;
    private String currentStep;
    private String currentTask;
    private String applicant;
    private String supervisor;
    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getApplicationFormId() {
        return applicationFormId;
    }

    public void setApplicationFormId(Long applicationFormId) {
        this.applicationFormId = applicationFormId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(String currentStep) {
        this.currentStep = currentStep;
    }

    public String getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(String currentTask) {
        this.currentTask = currentTask;
    }

    public static FlowInstance findById(Long id) {
        return DomainRegistry.flowInstanceRepository().findOne(id);
    }

    public Long create() {
        id = DomainRegistry.flowInstanceRepository().nextIdentity();
        DomainRegistry.flowInstanceRepository().save(this);
        return id;
    }

    public void update() {
        DomainRegistry.flowInstanceRepository().save(this);
    }

}
