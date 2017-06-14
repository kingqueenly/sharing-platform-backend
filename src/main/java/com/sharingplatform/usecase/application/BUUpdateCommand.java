package com.sharingplatform.usecase.application;

import com.sharingplatform.framework.domain.ServiceCommand;

/**
 * Created by paulliu on 2016/12/12.
 */
public class BUUpdateCommand extends ServiceCommand {

    private Long id;
    private String text;
    private String org;
    private String dept;

    public BUUpdateCommand() {
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

}
