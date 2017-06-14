package com.sharingplatform.usecase.adapter.web;

import com.sharingplatform.framework.query.PagedList;
import com.sharingplatform.usecase.application.CommentApplicationService;
import com.sharingplatform.usecase.application.CommentCommand;
import com.sharingplatform.usecase.query.CommentParameter;
import com.sharingplatform.usecase.query.CommentQuery;
import com.sharingplatform.usecase.query.CommentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hongying.fu on 1/13/2017.
 */

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentApplicationService commentApplicationService;

    @Autowired
    private CommentQuery commentQuery;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Long create(@RequestBody CommentCommand command) {
       return commentApplicationService.createComment(command);
    }

    @RequestMapping(value = "/search/{pageNum}", method = RequestMethod.POST)
    public PagedList<CommentResult> searchComment(@PathVariable Integer pageNum, @RequestBody(required = false) CommentParameter parameter) {
        return commentQuery.searchComment(parameter, pageNum);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable Long id) {
        commentApplicationService.deleteComment(id);
    }
}
