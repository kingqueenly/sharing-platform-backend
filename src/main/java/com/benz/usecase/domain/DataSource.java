package com.benz.usecase.domain;

/**
 * Created by hongying.fu on 1/12/2017.
 */
public class DataSource {
    private Long id;
    private String text;

    public DataSource() {
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

    public DataSource(String text) {
        this.id = DomainRegistry.dataSourceRepository().nextIdentity();
        this.text = text;
    }

    public void delete() {
        DomainRegistry.dataSourceRepository().delete(this);
    }

    public Long create() {
        DomainRegistry.dataSourceRepository().save(this);
        return this.id;
    }

    public void update(String text) {
        setText(text);
        DomainRegistry.dataSourceRepository().save(this);
    }
}
