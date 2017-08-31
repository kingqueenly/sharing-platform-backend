package com.sharingplatform.datagovernance.domain;

import com.sharingplatform.framework.mvc.SpringBootApplicationContext;

/**
 * Created by AMC on 2017/6/27.
 */
public class DomainRegistry {

    public static DataUsageApplicationRepository dataUsageApplicationRepository() {
        return SpringBootApplicationContext.getBean(DataUsageApplicationRepository.class);
    }

    public static TaskRepository taskRepository() {
        return SpringBootApplicationContext.getBean(TaskRepository.class);
    }

    public static FlowInstanceRepository flowInstanceRepository() {
        return SpringBootApplicationContext.getBean(FlowInstanceRepository.class);
    }

}
