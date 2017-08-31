package com.sharingplatform.framework.test;

import com.sharingplatform.SharingPlatformApplication;
import com.sharingplatform.datagovernance.domain.SystemName;
import com.sharingplatform.datagovernance.query.SystemNameQuery;
import com.sharingplatform.user.application.UserApplicationService;
import com.sharingplatform.user.domain.BenzUser;
import com.sharingplatform.user.query.UserQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AMC on 2017/8/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SharingPlatformApplication.class)
@WebAppConfiguration
public class FlowEngineTest {

    @Autowired
    SystemNameQuery systemNameQuery;

    @Autowired
    UserApplicationService userApplicationService;

    @Autowired
    UserQuery userQuery;

    @Test
    public void testFindDataOwnerIds() {
        List<SystemName> systemNames = new ArrayList<SystemName>();
        SystemName sn1 = new SystemName();
        sn1.setId(4L);
        sn1.setText("DMS");
        systemNames.add(sn1);
        SystemName sn2 = new SystemName();
        sn2.setId(5L);
        sn2.setText("Call Center");
        systemNames.add(sn2);
        List<String> ownerIds = systemNameQuery.findDataOwnerIds(systemNames);
        System.out.println(ownerIds.size());
    }

    @Test
    public void testExistingUser() {
        BenzUser bu2 = userApplicationService.existingUser(82L);
        System.out.println(bu2);
    }

    @Test
    public void testFindId() {
        Long id = userQuery.findId("WELIU11");
        System.out.println(id);
    }

}
