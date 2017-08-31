package com.sharingplatform.framework.test;

import com.sharingplatform.SharingPlatformApplication;
import com.sharingplatform.framework.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SharingPlatformApplication.class)
@WebAppConfiguration
public class MailServiceTest {

    @Autowired
    MailService mailService;

    @Test
    public void testSendmail(){
        mailService.sendSimpleMail("19977735@qq.com", "SP-test", "test");
    }

}
