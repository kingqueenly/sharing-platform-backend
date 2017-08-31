package com.sharingplatform;

import com.sharingplatform.framework.jpa.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@ImportResource("classpath:mybatis-datasource-config.xml")
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
//extends SpringBootServletInitializer
public class SharingPlatformApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(SharingPlatformApplication.class, args);

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}
