package com.benz.usecase.application;

import com.benz.framework.domain.ServiceCommand;

/**
 * Created by hongying.fu on 1/14/2017.
 */
public class ShareCommand extends ServiceCommand{
    private Long useCaseId;

    public ShareCommand() {
    }

    public Long getUseCaseId() {
        return useCaseId;
    }

    public void setUseCaseId(Long useCaseId) {
        this.useCaseId = useCaseId;
    }

    public ShareCommand(Long useCaseId) {
        this.useCaseId = useCaseId;
    }
}
