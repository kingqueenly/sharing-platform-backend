package com.benz.user.domain.event;

import com.benz.framework.domain.DomainEvent;

/**
 * Created by paulliu on 2017/1/17.
 */
public class LoginedEvent implements DomainEvent {

    private Long operatorId;

    @Override
    public Long getOperatorId() {
        return operatorId;
    }

    public LoginedEvent(Long operatorId) {
        this.operatorId = operatorId;
    }
}
