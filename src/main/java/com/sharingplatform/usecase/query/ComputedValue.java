package com.benz.usecase.query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulliu on 2017/1/20.
 */
public class ComputedValue {
    private List<String> xAxis;

    private List<ComputedValueData> datas;

    public ComputedValue(List<String> xAxis) {
        this.xAxis = xAxis;
        this.datas = new ArrayList<>();
    }

    public List<String> getxAxis() {
        return xAxis;
    }

    public void setxAxis(List<String> xAxis) {
        this.xAxis = xAxis;
    }

    public List<ComputedValueData> getDatas() {
        return datas;
    }

    public void setDatas(List<ComputedValueData> datas) {
        this.datas = datas;
    }

    public void addData(ComputedValueData data) {
        this.datas.add(data);
    }

    @Override
    public String toString() {
        return "ComputedValue{" +
                "xAxis=" + xAxis +
                ", datas=" + datas +
                '}';
    }
}

