package com.sharingplatform.usecase.domain;

/**
 * Created by hongying.fu on 1/12/2017.
 */
public class Value {
    private Long id;
    private String text;

    public Value() {
    }

    public Value(String text) {
        this.id = DomainRegistry.valueRepository().nextIdentity();
        this.text = text;
    }


    public void delete() {
        DomainRegistry.valueRepository().delete(this);
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

    public Long create() {
        DomainRegistry.valueRepository().save(this);
        return this.getId();
    }

    public void update(String text) {
        setText(text);
        DomainRegistry.valueRepository().save(this);
    }

}
