package com.sharingplatform.usecase.application;

import com.sharingplatform.framework.AssertionConcern;
import com.sharingplatform.usecase.domain.DataAnalysisModel;
import com.sharingplatform.usecase.domain.DataAnalysisModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hongying.fu on 2/13/2017.
 */
@Service
public class DataAnalysisModelApplicationService {

    @Autowired
    private DataAnalysisModelRepository dataAnalysisModelRepository ;
    public Long createDataAnalysisModel(ValueCreateCommand aCommand) {
        DataAnalysisModel dataAnalysisModel = new DataAnalysisModel(aCommand.getText());
        return dataAnalysisModel.create();
    }

    public void updateDataAnalysisModel(ValueCommand command) {
        DataAnalysisModel dataAnalysisModel = existingDataAnalysisModel(command.getId());
        dataAnalysisModel.update(command.getText());
    }

    private DataAnalysisModel existingDataAnalysisModel(Long id) {
        DataAnalysisModel dataAnalysisModel = dataAnalysisModelRepository.findOne(id);
        AssertionConcern.assertArgumentNotNull(dataAnalysisModel, "Business value does not exist");
        return dataAnalysisModel;
    }

    public void deleteDataAnalysisModel(Long id) {
        DataAnalysisModel dataAnalysisModel = existingDataAnalysisModel(id);
        dataAnalysisModel.delete();
    }
}
