package com.benz.usecase.adapter.web;

import com.benz.framework.domain.QueryParameter;
import com.benz.framework.query.PagedList;
import com.benz.usecase.application.ValueApplicationService;
import com.benz.usecase.application.ValueCommand;
import com.benz.usecase.application.ValueCreateCommand;
import com.benz.usecase.query.ValueQuery;
import com.benz.usecase.query.ValueResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hongying.fu on 2/10/2017.
 */
@RestController
@RequestMapping("/value")
public class ValueController {
    @Autowired
    private ValueApplicationService valueApplicationService;

    @Autowired
    private ValueQuery valueQuery;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Long create(@RequestBody ValueCreateCommand aCommand) {
      return  valueApplicationService.createValue(aCommand);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public void update(@PathVariable Long id, @RequestBody ValueCommand command) {
        command.setId(id);
        valueApplicationService.updateValue(command);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable Long id) {
        valueApplicationService.deleteValue(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public PagedList<ValueResult> search(@RequestBody(required = false) QueryParameter parameter) {
        return valueQuery.findAll(parameter);
    }

    @RequestMapping(value = "/search/{pageNum}", method = RequestMethod.POST)
    public PagedList<ValueResult> search(@PathVariable Integer pageNum, @RequestBody(required = false) QueryParameter parameter) {
        return valueQuery.findAll(parameter, pageNum);
    }
}
