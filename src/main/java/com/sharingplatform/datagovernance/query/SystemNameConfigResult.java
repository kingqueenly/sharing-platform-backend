package com.sharingplatform.datagovernance.query;

/**
 * Created by AMC on 2017/8/9.
 */
public class SystemNameConfigResult {

    private Long id;
    private String text;
    private String entityName;
    private String functionName;
    private String dataOwner;
    private String dataOwnerId;
    private String itOwner;
    private String itOwnerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getDataOwner() {
        return dataOwner;
    }

    public void setDataOwner(String dataOwner) {
        this.dataOwner = dataOwner;
    }

    public String getItOwner() {
        return itOwner;
    }

    public void setItOwner(String itOwner) {
        this.itOwner = itOwner;
    }

    public String getDataOwnerId() {
        return dataOwnerId;
    }

    public void setDataOwnerId(String dataOwnerId) {
        this.dataOwnerId = dataOwnerId;
    }

    public String getItOwnerId() {
        return itOwnerId;
    }

    public void setItOwnerId(String itOwnerId) {
        this.itOwnerId = itOwnerId;
    }

}
