package com.sharingplatform.usecase.query;

/**
 * Created by hongying.fu on 12/15/2016.
 */
public class BUResult {
    private Long id;
    private String text;
    private String org;
    private String dept;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BUResult(Long id, String text, String org, String dept) {
        this.id = id;
        this.text = text;
        this.org = org;
        this.dept = dept;
    }

    public BUResult() {

    }
}
