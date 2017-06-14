package com.sharingplatform.usecase.domain;

import java.util.List;

/**
 * Created by hongying.fu on 1/12/2017.
 */
public class DataSourceList {
    private List<DataSource> dataSources;

    public DataSourceList() {
    }

    public DataSourceList(List<DataSource> dataSources) {
        this.dataSources = dataSources;
    }

    public List<DataSource> getDataSources() {
        return dataSources;
    }

    public void setDataSources(List<DataSource> dataSources) {
        this.dataSources = dataSources;
    }

    public void resetTo(List<DataSource> dataSource) {
        clearDataSources();
        setDataSources(dataSource);
    }

    private void clearDataSources() {
        if (dataSources != null && dataSources.size() > 0) {
            for (DataSource dataSource : dataSources) {
                dataSource.delete();
            }
            //TODO: orphanRemoval=true cannot work for unidirectional!!!
            dataSources.clear();
        }
    }
}
