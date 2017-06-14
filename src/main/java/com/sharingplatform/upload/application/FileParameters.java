package com.sharingplatform.upload.application;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by hongying.fu on 1/19/2017.
 */
@Component
@ConfigurationProperties(prefix = "file")
public class FileParameters {
    private String widthCreateCase;
    private String heightCreateCase;
    private String widthDetailCase;
    private String heightDetailCase;
    private String url;
    private String realPath;

    public FileParameters() {
    }

    public String getWidthCreateCase() {
        return widthCreateCase;
    }

    public void setWidthCreateCase(String widthCreateCase) {
        this.widthCreateCase = widthCreateCase;
    }

    public String getHeightCreateCase() {
        return heightCreateCase;
    }

    public void setHeightCreateCase(String heightCreateCase) {
        this.heightCreateCase = heightCreateCase;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRealPath() {
        return realPath;
    }

    public void setRealPath(String realPath) {
        this.realPath = realPath;
    }

    public String getWidthDetailCase() {
        return widthDetailCase;
    }

    public void setWidthDetailCase(String widthDetailCase) {
        this.widthDetailCase = widthDetailCase;
    }

    public String getHeightDetailCase() {
        return heightDetailCase;
    }

    public void setHeightDetailCase(String heightDetailCase) {
        this.heightDetailCase = heightDetailCase;
    }
}
