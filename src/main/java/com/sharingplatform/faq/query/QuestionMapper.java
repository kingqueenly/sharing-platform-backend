package com.sharingplatform.faq.query;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {

    List<QuestionResult> listQuestions(FAQQueryParameter parameter);

    QuestionResult getQuestion(Long questionId);

}
