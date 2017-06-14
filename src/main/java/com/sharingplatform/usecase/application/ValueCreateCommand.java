package com.benz.usecase.application;

/**
 * Created by hongying.fu on 2/10/2017.
 */
public class ValueCreateCommand {
    private String text;

    public ValueCreateCommand() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
