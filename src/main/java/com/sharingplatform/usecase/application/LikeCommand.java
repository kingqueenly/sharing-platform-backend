package com.benz.usecase.application;

import com.benz.framework.domain.ServiceCommand;

/**
 * Created by hongying.fu on 1/14/2017.
 */
public class LikeCommand extends ServiceCommand{
    private Long useCaseId;
    public LikeCommand() {
    }

    public Long getUseCaseId() {
        return useCaseId;
    }

    public void setUseCaseId(Long useCaseId) {
        this.useCaseId = useCaseId;
    }

    public LikeCommand(Long useCaseId) {
        this.useCaseId = useCaseId;
    }

    @Override
    public String toString() {
        return "LikeCommand{" +
                "useCaseId='" + useCaseId + '\'' +
                '}';
    }
}
