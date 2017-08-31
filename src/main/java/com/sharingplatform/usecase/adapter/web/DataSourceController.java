package com.sharingplatform.usecase.adapter.web;

import com.sharingplatform.framework.domain.QueryParameter;
import com.sharingplatform.framework.query.PagedList;
import com.sharingplatform.usecase.application.DataSourceApplicationService;
import com.sharingplatform.usecase.application.ValueCommand;
import com.sharingplatform.usecase.application.ValueCreateCommand;
import com.sharingplatform.usecase.query.DataSourceQuery;
import com.sharingplatform.usecase.query.ValueResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hongying.fu on 2/13/2017.
 */
@RestController
@RequestMapping("/dataSource")
public class DataSourceController {
    @Autowired
    private DataSourceApplicationService dataSourceApplicationService;

    @Autowired
    private DataSourceQuery dataSourceQuery;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Long create(@RequestBody ValueCreateCommand aCommand) {
        return  dataSourceApplicationService.createDataSource(aCommand);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public void update(@PathVariable Long id, @RequestBody ValueCommand command) {
        command.setId(id);
        dataSourceApplicationService.updateDataSource(command);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable Long id) {
        dataSourceApplicationService.deleteDataSource(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public PagedList<ValueResult> search(@RequestBody(required = false) QueryParameter parameter) {
        return dataSourceQuery.findAll(parameter);
    }

    @RequestMapping(value = "/search/{pageNum}", method = RequestMethod.POST)
    public PagedList<ValueResult> search(@PathVariable Integer pageNum, @RequestBody(required = false) QueryParameter parameter) {
        return dataSourceQuery.findAll(parameter, pageNum);
    }
}
