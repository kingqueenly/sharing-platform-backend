package com.benz.usecase.adapter.web;

import com.benz.usecase.application.LikeApplicationService;
import com.benz.usecase.application.LikeCommand;
import com.benz.usecase.domain.LikeCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hongying.fu on 1/14/2017.
 */
@RestController
@RequestMapping("/like")
public class LikeController {
    @Autowired
    private LikeApplicationService likeApplicationService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody LikeCommand command) {
        likeApplicationService.createLike(command);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public LikeCase findOne(@RequestBody LikeCommand command) {
        return likeApplicationService.findOne(command.getOperatorId(), command.getUseCaseId());
    }

}
