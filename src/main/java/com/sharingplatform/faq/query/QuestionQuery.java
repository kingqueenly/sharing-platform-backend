package com.sharingplatform.faq.query;

import com.sharingplatform.framework.query.BaseQuery;
import com.sharingplatform.framework.query.PageParameter;
import com.sharingplatform.framework.query.PagedList;
import com.sharingplatform.usecase.query.UseCaseParameter;
import com.sharingplatform.usecase.query.UseCaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;


/**
 * Created by AMC on 2017/6/28.
 */
@Service
public class QuestionQuery extends BaseQuery {

    @Autowired
    private QuestionMapper questionMapper;

    public PagedList<QuestionResult> listQustions(final FAQQueryParameter parameter, Integer pageNum) {
        PagedList<QuestionResult> questionResultPagedList = paging(parameter, new Callable<List<QuestionResult>>() {
            public List<QuestionResult> call() {
                return questionMapper.listQuestions(parameter);
            }
        }, new PageParameter(pageNum));

        return questionResultPagedList;
    }

    public QuestionResult getQuestion(Long questionId) {
        QuestionResult questionResult = questionMapper.getQuestion(questionId);
        return questionResult;
    }
}
