package com.sharingplatform.faq.domain;

import com.sharingplatform.framework.mvc.SpringBootApplicationContext;

/**
 * Created by AMC on 2017/6/27.
 */
public class DomainRegistry {

    public static QuestionRepository questionRepository() {
        return SpringBootApplicationContext.getBean(QuestionRepository.class);
    }

}
