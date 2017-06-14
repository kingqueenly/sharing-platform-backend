package com.sharingplatform.usecase.query;

import java.util.ArrayList;
import java.util.List;

public class ComputedValueData {
    private List<Integer> data;
    private String label;

    public ComputedValueData(String label) {
        this.label = label;
        this.data = new ArrayList<>();
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void addData(Integer data) {
        this.data.add(data);
    }

}
