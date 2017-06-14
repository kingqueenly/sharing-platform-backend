package com.benz.framework.domain;

import com.benz.framework.mvc.SpringBootApplicationContext;

/**
 * Created by paulliu on 2017/1/18.
 */
public class DomainEventPublisher {
    public static void publishEvent(DomainEvent domainEvent) {
        SpringBootApplicationContext.publishEvent(domainEvent);
    }
}
