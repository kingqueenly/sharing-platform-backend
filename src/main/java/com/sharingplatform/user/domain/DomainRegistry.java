package com.sharingplatform.user.domain;

import com.sharingplatform.framework.ftp.FTPParameters;
import com.sharingplatform.framework.mvc.SpringBootApplicationContext;

/**
 * Created by hongying.fu on 1/10/2017.
 */
public class DomainRegistry {
    public static UserRepository userRepository() {
        return SpringBootApplicationContext.getBean(UserRepository.class);
    }

    public static LevelRepository levelRepository() {
        return SpringBootApplicationContext.getBean(LevelRepository.class);
    }

    public static FTPParameters ftpParameters() {
        return SpringBootApplicationContext.getBean(FTPParameters.class);
    }

    public static RoleRepository roleRepository() {
        return SpringBootApplicationContext.getBean(RoleRepository.class);
    }

}
