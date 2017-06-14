package com.sharingplatform.framework.domain;

/**
 * Created by paulliu on 2017/1/17.
 */
public interface DomainEventListener<T> {
    void handle(T domainEvent);
}
