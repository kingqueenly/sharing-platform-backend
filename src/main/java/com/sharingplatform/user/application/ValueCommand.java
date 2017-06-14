package com.sharingplatform.user.application;

/**
 * Created by Administrator on 5/2/2017.
 */
public class ValueCommand {
    private Long id;
    private String text;

    public ValueCommand() {
    }

    public ValueCommand(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
