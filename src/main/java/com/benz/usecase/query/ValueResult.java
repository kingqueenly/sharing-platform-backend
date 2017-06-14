package com.benz.usecase.query;

/**
 * Created by hongying.fu on 1/11/2017.
 */
public class ValueResult {
    private String id;
    private String text;

    public ValueResult() {
    }

    public ValueResult(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
