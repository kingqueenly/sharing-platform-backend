package com.sharingplatform.user.application;

import com.sharingplatform.framework.domain.ServiceCommand;

/**
 * Created by paulliu on 2016/12/12.
 */
public class RoleCreateCommand extends ServiceCommand {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public RoleCreateCommand() {
    }
}
