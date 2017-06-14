package com.sharingplatform.framework.domain;

import com.sharingplatform.framework.mvc.SpringBootApplicationContext;

/**
 * Created by paulliu on 2017/1/18.
 */
public class DomainEventPublisher {
    public static void publishEvent(DomainEvent domainEvent) {
        SpringBootApplicationContext.publishEvent(domainEvent);
    }
}
