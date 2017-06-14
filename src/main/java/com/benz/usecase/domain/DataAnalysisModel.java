package com.benz.usecase.domain;

/**
 * Created by hongying.fu on 1/12/2017.
 */
public class DataAnalysisModel {
    private Long id;
    private String text;

    public DataAnalysisModel() {
    }

    public DataAnalysisModel(String text) {
        this.id = DomainRegistry.dataAnalysisModelRepository().nextIdentity();
        this.text = text;
    }

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

    public void delete() {
        DomainRegistry.dataAnalysisModelRepository().delete(this);
    }

    public Long create() {
        DomainRegistry.dataAnalysisModelRepository().save(this);
        return this.id;
    }

    public void update(String text) {
        setText(text);
        DomainRegistry.dataAnalysisModelRepository().save(this);
    }
}
