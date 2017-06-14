package com.sharingplatform.user.adapter.web;

import com.sharingplatform.framework.domain.QueryParameter;
import com.sharingplatform.framework.query.PagedList;
import com.sharingplatform.usecase.application.BUApplicationService;
import com.sharingplatform.usecase.application.BUCreateCommand;
import com.sharingplatform.usecase.application.BUUpdateCommand;
import com.sharingplatform.usecase.query.BUQuery;
import com.sharingplatform.usecase.query.BUResult;
import com.sharingplatform.user.application.RoleApplicationService;
import com.sharingplatform.user.application.RoleCreateCommand;
import com.sharingplatform.user.application.RoleUpdateCommand;
import com.sharingplatform.user.query.RoleQuery;
import com.sharingplatform.user.query.RoleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 5/2/2017.
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleApplicationService roleApplicationService;

    @Autowired
    private RoleQuery roleQuery;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Long create(@RequestBody RoleCreateCommand aCommand) {
        return roleApplicationService.createRole(aCommand);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public void update(@PathVariable Long id, @RequestBody RoleUpdateCommand command) {
        command.setId(id);
        roleApplicationService.updateRole(command);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable Long id) {
        roleApplicationService.deleteRole(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public PagedList<RoleResult> search(@RequestBody(required = false) QueryParameter parameter) {
        return roleQuery.findAll(parameter, 1);
    }

    @RequestMapping(value = "/search/{pageNum}", method = RequestMethod.POST)
    public PagedList<RoleResult> search(@PathVariable Integer pageNum, @RequestBody(required = false) QueryParameter parameter) {
        return roleQuery.findAll(parameter, pageNum);
    }
}
