package com.benz.usecase.query;

/**
 * Created by hongying.fu on 12/15/2016.
 */
public class TotalByValueResult {
    private String value;
    private String createDay;
    private Integer amount;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCreateDay() {
        return createDay;
    }

    public void setCreateDay(String createDay) {
        this.createDay = createDay;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
