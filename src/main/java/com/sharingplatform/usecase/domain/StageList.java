package com.sharingplatform.usecase.domain;

import com.sharingplatform.usecase.query.UseCaseResult;

import java.util.List;

/**
 * Created by hongying.fu on 4/19/2017.
 */
public class StageList {
    private String stage;
    private List<UseCaseResult> list;

    public StageList() {
    }

    public StageList(String stage, List<UseCaseResult> list) {
        this.stage = stage;
        this.list = list;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public List<UseCaseResult> getList() {
        return list;
    }

    public void setList(List<UseCaseResult> list) {
        this.list = list;
    }
}
