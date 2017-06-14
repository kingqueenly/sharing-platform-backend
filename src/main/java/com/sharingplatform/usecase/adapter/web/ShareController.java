package com.benz.usecase.adapter.web;

import com.benz.usecase.application.LikeCommand;
import com.benz.usecase.application.ShareApplicationService;
import com.benz.usecase.application.ShareCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hongying.fu on 1/14/2017.
 */
@RestController
@RequestMapping("/share")
public class ShareController {
    @Autowired
    private ShareApplicationService shareApplicationService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody ShareCommand command) {
        shareApplicationService.createShare(command);
    }
}
