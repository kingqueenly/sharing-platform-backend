package com.sharingplatform.usecase.domain;

import java.util.List;

/**
 * Created by hongying.fu on 1/12/2017.
 */
public class DataAnalysisModelList {
    private List<DataAnalysisModel> dataAnalysisModels;

    public DataAnalysisModelList() {
    }

    public DataAnalysisModelList(List<DataAnalysisModel> dataAnalysisModels) {
        this.dataAnalysisModels = dataAnalysisModels;
    }

    public List<DataAnalysisModel> getDataAnalysisModels() {
        return dataAnalysisModels;
    }

    public void setDataAnalysisModels(List<DataAnalysisModel> dataAnalysisModels) {
        this.dataAnalysisModels = dataAnalysisModels;
    }

    public void resetTo(List<DataAnalysisModel> dataAnalysisModels) {
        clearDataAnalysisModels();
        setDataAnalysisModels(dataAnalysisModels);
    }

    private void clearDataAnalysisModels() {
        if (dataAnalysisModels != null && dataAnalysisModels.size() > 0) {
            for (DataAnalysisModel dataAnalysisModel : dataAnalysisModels) {
                dataAnalysisModel.delete();
            }
            //TODO: orphanRemoval=true cannot work for unidirectional!!!
            dataAnalysisModels.clear();
        }
    }}
