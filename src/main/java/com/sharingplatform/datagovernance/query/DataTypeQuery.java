package com.sharingplatform.datagovernance.query;

import com.sharingplatform.usecase.query.ValueResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by AMC on 2017/7/31.
 */
@Service
public class DataTypeQuery {

    @Autowired
    DataTypeMapper dataTypeMapper;

    public List<ValueResult> findAll() {
        List<ValueResult> dataTypes = dataTypeMapper.findAll();
        return dataTypes;
    }

}
