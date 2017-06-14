package com.sharingplatform.usecase.domain;

/**
 * Created by hongying.fu on 12/22/2016.
 */
public class AnalysisMethodResultFile {
    private Long id;
    private String fileName;
    private String url;

    public AnalysisMethodResultFile() {
    }

    public AnalysisMethodResultFile(String fileName, String url) {
        this.id = DomainRegistry.analysisMethodResultFileRepository().nextIdentity();
        this.fileName = fileName;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void delete() {
        DomainRegistry.analysisMethodResultFileRepository().delete(this);
    }
}
