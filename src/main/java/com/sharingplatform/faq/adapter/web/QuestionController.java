package com.sharingplatform.faq.adapter.web;

import com.sharingplatform.faq.application.QuestionApplicationService;
import com.sharingplatform.faq.application.QuestionCreateCommand;
import com.sharingplatform.faq.application.QuestionUpdateCommand;
import com.sharingplatform.faq.query.FAQQueryParameter;
import com.sharingplatform.faq.query.QuestionQuery;
import com.sharingplatform.faq.query.QuestionResult;
import com.sharingplatform.framework.query.PagedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by AMC on 2017/6/28.
 */
@RestController
@RequestMapping("/faq/question")
public class QuestionController {

    @Autowired
    private  QuestionApplicationService questionApplicationService;

    @Autowired
    private QuestionQuery questionQuery;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Long create(@RequestBody QuestionCreateCommand command) {
        return questionApplicationService.createQuestion(command);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public QuestionResult getQuestion(@PathVariable Long id) {
        return questionQuery.getQuestion(id);
    }

    @RequestMapping(value = "/{id}/reply", method = RequestMethod.POST)
    public void replyQuestion(@PathVariable Long id, @RequestBody QuestionUpdateCommand command) {
        command.setId(id);
        questionApplicationService.replyQuestion(command);
    }

    @RequestMapping(value = "/{id}/useful", method = RequestMethod.POST)
    public void makeQuestionSolved(@PathVariable Long id) {
        QuestionUpdateCommand command = new QuestionUpdateCommand();
        command.setId(id);
        command.setUseful(true);
        questionApplicationService.updateQuestion(command);
    }

    @RequestMapping(value = "/{id}/unuseful", method = RequestMethod.POST)
    public void makeQuestionUnsolved(@PathVariable Long id) {
        QuestionUpdateCommand command = new QuestionUpdateCommand();
        command.setId(id);
        command.setUseful(false);
        questionApplicationService.updateQuestion(command);
    }

    @RequestMapping(value = "/search/{pageNum}", method = RequestMethod.POST)
    public PagedList<QuestionResult> search(@PathVariable Integer pageNum, @RequestBody(required = false) FAQQueryParameter parameter) {
        return questionQuery.listQustions(parameter, pageNum);
    }

}
