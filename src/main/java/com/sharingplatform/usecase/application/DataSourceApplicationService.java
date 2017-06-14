package com.sharingplatform.usecase.application;

import com.sharingplatform.framework.AssertionConcern;
import com.sharingplatform.usecase.domain.DataSource;
import com.sharingplatform.usecase.domain.DataSourceRepository;
import com.sharingplatform.usecase.domain.Value;
import com.sharingplatform.usecase.domain.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hongying.fu on 2/13/2017.
 */
@Service
public class DataSourceApplicationService {
    @Autowired
    private DataSourceRepository dataSourceRepository;

    public Long createDataSource(ValueCreateCommand aCommand) {
        DataSource dataSource = new DataSource(aCommand.getText());
        return dataSource.create();
    }

    public void updateDataSource(ValueCommand command) {
        DataSource dataSource = existingDataSource(command.getId());
        dataSource.update(command.getText());
    }

    private DataSource existingDataSource(Long id) {
        DataSource dataSource = dataSourceRepository.findOne(id);
        AssertionConcern.assertArgumentNotNull(dataSource, "Business value does not exist");
        return dataSource;
    }

    public void deleteDataSource(Long id) {
        DataSource dataSource = existingDataSource(id);
        dataSource.delete();
    }
}
