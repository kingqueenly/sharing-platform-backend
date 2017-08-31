package com.sharingplatform.usecase.domain;

import com.sharingplatform.framework.AssertionConcern;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by paulliu on 2016/12/12.
 */
public class TimeFrame {
    private Date afromValue;
    private Date atoValue;

    public TimeFrame() {
    }

    public TimeFrame(Date afromValue, Date atoValue) {
        this.afromValue = afromValue;
        this.atoValue = atoValue;
    }

    public TimeFrame(String afromValue, String atoValue) {
        AssertionConcern.assertArgumentNotEmpty(afromValue, "Start date cannot be empty");
        AssertionConcern.assertArgumentNotEmpty(atoValue, "End date cannot be empty");
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            this.afromValue = format.parse(afromValue);
            this.atoValue = format.parse(atoValue);
        } catch (Exception e) {
            //TODO: should throw exception
            e.printStackTrace();
        }
    }

    public Date getAfromValue() {
        return afromValue;
    }

    public void setAfromValue(Date afromValue) {
        this.afromValue = afromValue;
    }

    public Date getAtoValue() {
        return atoValue;
    }

    public void setAtoValue(Date atoValue) {
        this.atoValue = atoValue;
    }
}
