package com.sharingplatform.user.application;

import com.sharingplatform.framework.domain.ServiceCommand;

/**
 * Created by paulliu on 2016/12/12.
 */
public class RoleUpdateCommand extends ServiceCommand {

    private Long id;
    private String text;

    public RoleUpdateCommand() {
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
}
