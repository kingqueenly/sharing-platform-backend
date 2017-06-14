package com.benz.usecase.domain;

/**
 * Created by hongying.fu on 1/9/2017.
 */
public class Attachment {
    private Long id;
    private String fileName;
    private String url;

    public Attachment() {
    }

    public void delete() {
        DomainRegistry.attachmentRepository().delete(this);
    }

    public Attachment(String fileName, String url) {
        this.id = DomainRegistry.attachmentRepository().nextIdentity();
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
}
