package com.benz.usecase.application;

/**
 * Created by hongying.fu on 1/12/2017.
 */
public class AttachmentCommand {
    private String id;
    private String fileName;
    private String url;

    public AttachmentCommand() {
    }

    public AttachmentCommand(String id, String fileName, String url) {
        this.id = id;
        this.fileName = fileName;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
