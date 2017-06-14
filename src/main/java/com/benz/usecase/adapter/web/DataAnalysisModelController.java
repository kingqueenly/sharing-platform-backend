package com.benz.usecase.adapter.web;

import com.benz.framework.domain.QueryParameter;
import com.benz.framework.query.PagedList;
import com.benz.usecase.application.DataAnalysisModelApplicationService;
import com.benz.usecase.application.ValueCommand;
import com.benz.usecase.application.ValueCreateCommand;
import com.benz.usecase.query.DataAnalysisModelQuery;
import com.benz.usecase.query.ValueResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hongying.fu on 2/13/2017.
 */
@RestController
@RequestMapping("/dataAnalysisModel")
public class DataAnalysisModelController {
    @Autowired
    private DataAnalysisModelApplicationService dataAnalysisModelApplicationService;
    @Autowired
    private DataAnalysisModelQuery dataAnalysisModelQuery;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Long create(@RequestBody ValueCreateCommand aCommand) {
        return  dataAnalysisModelApplicationService.createDataAnalysisModel(aCommand);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public void update(@PathVariable Long id, @RequestBody ValueCommand command) {
        command.setId(id);
        dataAnalysisModelApplicationService.updateDataAnalysisModel(command);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable Long id) {
        dataAnalysisModelApplicationService.deleteDataAnalysisModel(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public PagedList<ValueResult> search(@RequestBody(required = false) QueryParameter parameter) {
        return dataAnalysisModelQuery.findAll(parameter);
    }

    @RequestMapping(value = "/search/{pageNum}", method = RequestMethod.POST)
    public PagedList<ValueResult> search(@PathVariable Integer pageNum, @RequestBody(required = false) QueryParameter parameter) {
        return dataAnalysisModelQuery.findAll(parameter, pageNum);
    }
}
