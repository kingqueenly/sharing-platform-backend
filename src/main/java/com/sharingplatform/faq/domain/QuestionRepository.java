package com.sharingplatform.faq.domain;

import com.sharingplatform.framework.jpa.BaseRepository;
import com.sharingplatform.framework.mvc.SpringBootApplicationContext;
import com.sharingplatform.usecase.domain.AnalysisMethodResultFile;
import com.sharingplatform.usecase.domain.UseCaseRepository;

/**
 * Created by AMC on 2017/6/27.
 */
public interface QuestionRepository extends BaseRepository<Question, Long> {
}
