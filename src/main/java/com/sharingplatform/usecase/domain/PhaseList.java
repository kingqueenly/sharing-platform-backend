package com.benz.usecase.domain;

import java.util.List;

/**
 * Created by hongying.fu on 4/19/2017.
 */
public class PhaseList {
    private String phase;
    private List<StageList> list;

    public PhaseList() {
    }

    public PhaseList(String phase, List<StageList> list) {
        this.phase = phase;
        this.list = list;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public List<StageList> getList() {
        return list;
    }

    public void setList(List<StageList> list) {
        this.list = list;
    }
}
