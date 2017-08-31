package com.sharingplatform.usecase.application;

import com.sharingplatform.framework.AssertionConcern;
import com.sharingplatform.usecase.domain.*;
import com.sharingplatform.usecase.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulliu on 2016/12/12.
 */
@Service
public class UseCaseApplicationService {

    @Autowired
    private UseCaseRepository useCaseRepository;

    @Autowired
    private UserInfoService userInfoService;

    public void createUseCase(UseCaseCreateCommand command) {
        UserInfo userInfo = existingUser(command.getOperatorId());
        List<AnalysisMethodResultFile> analysisMethodResultFileList = parseAnalysisMethodResultFiles(command.getAnalysisMethodResultFiles());
        AnalysisMethodResult analysisMethodResult = new AnalysisMethodResult(command.getAnalysisMethodResultText(), analysisMethodResultFileList);

        List<ValidationMethodResultFile> validationMethodResultFileList = parseValidationMethodResultFiles(command.getValidationMethodResultFiles());
        ValidationMethodResult validationMethodResult = new ValidationMethodResult(command.getValidationMethodResultText(), validationMethodResultFileList);

        List<ImplMethodResultFile> implMethodResultFileList = parseImplMethodResultFiles(command.getImplMethodResultFiles());
        ImplMethodResult implMethodResult = new ImplMethodResult(command.getImplMethodResultText(), implMethodResultFileList);

        List<Value> values = parseValues(command.getValues());
//        ValueList valueList = new ValueList(values);

        List<DataSource> dataSources = parseDataSources(command.getDataSource());

//        DataSourceList dataSourceList = new DataSourceList(dataSources);

        List<DataAnalysisModel> dataAnalysisModels = parseDataAnalysisModel(command.getDataAnalysisModel());
//        DataAnalysisModelList dataAnalysisModelList = new DataAnalysisModelList(dataAnalysisModels);

        List<Attachment> attachments = parseAttachments(command.getAttachments());
        AttachmentList attachmentList = new AttachmentList(attachments);

        CaseCommentLikeShare caseCommentLikeShare = new CaseCommentLikeShare(0, 0, 0,0);

        UseCase useCase =
                new UseCase(
                        new CaseSubject(command.getSubject()),
                        values,
                        command.getScenario(),
                        dataSources,
                        command.getDataSourceOther(),
                        command.getDataTypeDescription(),
                        dataAnalysisModels,
                        command.getDataAnalysisModelOther(),
                        analysisMethodResult,
                        validationMethodResult,
                        implMethodResult,
                        command.getContributionBU(),
                        command.getStage(),
                        new TimeFrame(command.getFromDate(), command.getToDate()),
                        command.getNeedHelp(),
                        attachmentList,
                        caseCommentLikeShare,
                        userInfo,
                        command.getReferenceCase(),
                        command.getPhase()
                );
        useCase.create();
    }

    @Transactional
    public void updateUseCase(UseCaseUpdateCommand command) {
        UseCase useCase = existingCase(command.getId());
        List<AnalysisMethodResultFile> analysisMethodResultFileList = parseAnalysisMethodResultFiles(command.getAnalysisMethodResultFiles());
        AnalysisMethodResult analysisMethodResult = new AnalysisMethodResult(command.getAnalysisMethodResultText(), analysisMethodResultFileList);

        List<ValidationMethodResultFile> validationMethodResultFileList = parseValidationMethodResultFiles(command.getValidationMethodResultFiles());
        ValidationMethodResult validationMethodResult = new ValidationMethodResult(command.getValidationMethodResultText(), validationMethodResultFileList);

        List<ImplMethodResultFile> implMethodResultFileList = parseImplMethodResultFiles(command.getImplMethodResultFiles());
        ImplMethodResult implMethodResult = new ImplMethodResult(command.getImplMethodResultText(), implMethodResultFileList);

        List<Value> values = parseValues(command.getValues());
        List<DataSource> dataSources = parseDataSources(command.getDataSource());
        List<DataAnalysisModel> dataAnalysisModels = parseDataAnalysisModel(command.getDataAnalysisModel());
        List<Attachment> attachments = parseAttachments(command.getAttachments());
        useCase.update(
                new CaseSubject(command.getSubject()),
                values,
                command.getScenario(),
                dataSources,
                command.getDataSourceOther(),
                command.getDataTypeDescription(),
                dataAnalysisModels,
                command.getDataAnalysisModelOther(),
                analysisMethodResult,
                validationMethodResult,
                implMethodResult,
                command.getContributionBU(),
                command.getStage(),
                new TimeFrame(command.getFromDate(), command.getToDate()),
                command.getNeedHelp(),
                attachments,
                command.getPhase());
    }

    public void deleteUseCase(Long id) {
        UseCase useCase = existingCase(id);
        useCase.delete();
    }

    private UserInfo existingUser(Long id) {
        UserInfo userInfo = userInfoService.findById(id);
        AssertionConcern.assertArgumentNotNull(userInfo, "userInfo does not exist");
        return userInfo;
    }

    private UseCase existingCase(Long id) {
        UseCase useCase = useCaseRepository.findOne(id);
        AssertionConcern.assertArgumentNotNull(useCase, "use case does not exist");
        return useCase;
    }

    private List<AnalysisMethodResultFile> parseAnalysisMethodResultFiles(List<FileCommand> fileCommands) {
        List<AnalysisMethodResultFile> analysisMethodResultFileList = new ArrayList<>();
        if (fileCommands != null && fileCommands.size() > 0) {
            for (FileCommand analysisModelFileCommand : fileCommands) {
                AnalysisMethodResultFile analysisMethodResultFile = new AnalysisMethodResultFile(analysisModelFileCommand.getFileName(), analysisModelFileCommand.getUrl());
                analysisMethodResultFileList.add(analysisMethodResultFile);
            }
        }
        return analysisMethodResultFileList;
    }

    private List<ValidationMethodResultFile> parseValidationMethodResultFiles(List<FileCommand> fileCommands) {
        List<ValidationMethodResultFile> validationMethodResultFiles = new ArrayList<>();
        if (fileCommands != null && fileCommands.size() > 0) {
            for (FileCommand fileCommand : fileCommands) {
                ValidationMethodResultFile validationMethodResultFile = new ValidationMethodResultFile(fileCommand.getFileName(), fileCommand.getUrl());
                validationMethodResultFiles.add(validationMethodResultFile);
            }
        }
        return validationMethodResultFiles;
    }

    private List<ImplMethodResultFile> parseImplMethodResultFiles(List<FileCommand> fileCommands) {
        List<ImplMethodResultFile> implMethodResultFiles = new ArrayList<>();
        if (fileCommands != null && fileCommands.size() > 0) {
            for (FileCommand fileCommand : fileCommands) {
                ImplMethodResultFile validationMethodResultFile = new ImplMethodResultFile(fileCommand.getFileName(), fileCommand.getUrl());
                implMethodResultFiles.add(validationMethodResultFile);
            }
        }
        return implMethodResultFiles;
    }

    private List<Value> parseValues(List<ValueCommand> valueCommandList) {
        List<Value> values = new ArrayList<Value>();
        if (valueCommandList != null && valueCommandList.size() > 0) {
            for (ValueCommand valueCommand : valueCommandList) {
//                Value value = new Value(valueCommand.getText());
                Value value=existingValue(valueCommand.getId());
                values.add(value);
            }
        }
        return values;
    }

    private Value existingValue(Long id) {
        Value value=DomainRegistry.valueRepository().findOne(id);
        AssertionConcern.assertArgumentNotNull(value, "value does not exist");
        return value;
    }

    private List<DataSource> parseDataSources(List<ValueCommand> dataSourceList) {
        List<DataSource> values = new ArrayList<>();
        if (dataSourceList != null && dataSourceList.size() > 0) {
            for (ValueCommand valueCommand : dataSourceList) {
                DataSource value = existingDataSource(valueCommand.getId());
                values.add(value);
            }
        }
        return values;
    }

    private DataSource existingDataSource(Long id) {
        DataSource  value=DomainRegistry.dataSourceRepository().findOne(id);
        AssertionConcern.assertArgumentNotNull(value, "DataSource does not exist");
        return value;
    }
    private List<DataAnalysisModel> parseDataAnalysisModel(List<ValueCommand> dataAnalysisModelList) {
        List<DataAnalysisModel> values = new ArrayList<>();
        if (dataAnalysisModelList != null && dataAnalysisModelList.size() > 0) {
            for (ValueCommand valueCommand : dataAnalysisModelList) {
                DataAnalysisModel dataAnalysisModel = existingDataAnalysisModel(valueCommand.getId());
                values.add(dataAnalysisModel);
            }
        }
        return values;
    }

    private DataAnalysisModel existingDataAnalysisModel(Long id) {
        DataAnalysisModel dataAnalysisModel = DomainRegistry.dataAnalysisModelRepository().findOne(id);
        AssertionConcern.assertArgumentNotNull(dataAnalysisModel, "dataAnalysisModel does not exist");
        return dataAnalysisModel;
    }

    private List<Attachment> parseAttachments(List<AttachmentCommand> attachmentCommandList){
        List<Attachment> attachments = new ArrayList<>();
        if(attachmentCommandList!=null && attachmentCommandList.size()>0){
            for(AttachmentCommand attachmentCommand:attachmentCommandList){
                Attachment attachment = new Attachment(attachmentCommand.getFileName(),attachmentCommand.getUrl());
                attachments.add(attachment);
            }
        }
        return attachments;
    }


}
