package com.sharingplatform.datagovernance.query;

import com.sharingplatform.datagovernance.domain.SystemName;
import com.sharingplatform.usecase.query.ValueResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AMC on 2017/7/31.
 */
@Service
public class SystemNameQuery {

    @Autowired
    SystemNameMapper systemNameMapper;

    public List<SystemNameResult> findAllSystemName() {
        List<SystemNameResult> systemNames = systemNameMapper.findAllSystemName();
        return systemNames;
    }

    public List<SystemNameConfigResult> findAllSystemNameConfig() {
        List<SystemNameConfigResult> systemNames = systemNameMapper.findAllSystemNameConfig();
        return systemNames;
    }

    public List<String> findDataOwnerIds(List<SystemName> systemNames) {
        List<String> names = extractNames(systemNames);
        return systemNameMapper.findDataOwnerIds(names);
    }

    public List<String> findItOwnerIds(List<SystemName> systemNames) {
        List<String> names = extractNames(systemNames);
        return systemNameMapper.findItOwnerIds(names);
    }

    private List<String> extractNames(List<SystemName> systemNames) {
        List<String> names = new ArrayList<String>();
        for (SystemName sn : systemNames) {
            names.add(sn.getText());
        }
        return names;
    }
}
