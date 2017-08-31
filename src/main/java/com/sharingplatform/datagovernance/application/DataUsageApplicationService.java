package com.sharingplatform.datagovernance.application;

import com.sharingplatform.datagovernance.domain.DataUsageApplication;
import com.sharingplatform.datagovernance.domain.DomainRegistry;
import org.springframework.stereotype.Service;

/**
 * Created by AMC on 2017/8/11.
 */
@Service
public class DataUsageApplicationService {

    public Long createApplication(DataUsageApplicationCommand command) {
        DataUsageApplication application = new DataUsageApplication(command);
        Long id = application.create();
        return id;
    }

    public DataUsageApplication findById(Long id) {
        return DomainRegistry.dataUsageApplicationRepository().findOne(id);
    }

}
