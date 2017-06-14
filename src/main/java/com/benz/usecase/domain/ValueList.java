package com.benz.usecase.domain;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by hongying.fu on 1/12/2017.
 */
public class ValueList {
    private List<Value> values;

    public ValueList() {
    }

    public ValueList(List<Value> values) {
        this.values = values;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    public void resetTo(List<Value> values) {
        clearValues();
        setValues(values);
    }

    private void clearValues() {
        if (values != null && values.size() > 0) {
            for (Value value : values) {
                value.delete();
            }
            //TODO: orphanRemoval=true cannot work for unidirectional!!!
            values.clear();
        }
    }
}
