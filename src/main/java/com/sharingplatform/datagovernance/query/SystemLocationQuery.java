package com.sharingplatform.datagovernance.query;

import com.sharingplatform.usecase.query.ValueResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by AMC on 2017/7/31.
 */
@Service
public class SystemLocationQuery {

    @Autowired
    SystemLocationMapper systemLocationMapper;

    public List<ValueResult> findAll() {
        List<ValueResult> systemLocations = systemLocationMapper.findAll();
        return systemLocations;
    }

}
