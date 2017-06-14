package com.sharingplatform.usecase.domain;

/**
 * Created by hongying.fu on 1/9/2017.
 */
public class ImplMethodResultFile {
    private Long id;
    private String fileName;
    private String url;

    public ImplMethodResultFile() {
    }

    public ImplMethodResultFile(String fileName, String url) {
        this.id = DomainRegistry.implMethodResultRepository().nextIdentity();
        this.fileName = fileName;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void delete() {
        DomainRegistry.implMethodResultRepository().delete(this);
    }
}
