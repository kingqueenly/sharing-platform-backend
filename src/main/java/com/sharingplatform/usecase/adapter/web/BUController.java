package com.sharingplatform.usecase.adapter.web;

import com.sharingplatform.framework.domain.QueryParameter;
import com.sharingplatform.framework.query.PagedList;
import com.sharingplatform.usecase.application.BUApplicationService;
import com.sharingplatform.usecase.application.BUCreateCommand;
import com.sharingplatform.usecase.application.BUUpdateCommand;
import com.sharingplatform.usecase.query.BUQuery;
import com.sharingplatform.usecase.query.BUResult;
import com.sharingplatform.usecase.query.ValueResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by paulliu on 2016/12/12.
 */
@RestController
@RequestMapping("/bu")
public class BUController {
    @Autowired
    private BUApplicationService buApplicationService;

    @Autowired
    private BUQuery buQuery;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Long create(@RequestBody BUCreateCommand aCommand) {
       return buApplicationService.createBU(aCommand);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public void update(@PathVariable Long id, @RequestBody BUUpdateCommand command) {
        command.setId(id);
        buApplicationService.updateBU(command);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable Long id) {
        buApplicationService.deleteBU(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public PagedList<BUResult> search(@RequestBody(required = false) QueryParameter parameter) {
        return buQuery.findAll(parameter, 1,200);
    }

    @RequestMapping(value = "/search/company", method = RequestMethod.GET)
    public PagedList<ValueResult> searchAllCompanies(){
        return buQuery.findAllCompanies();
    }

    @RequestMapping(value = "/search/dept/{company}", method = RequestMethod.GET)
    public PagedList<ValueResult> findDeptByCompany(@PathVariable String company){
        return buQuery.findDeptByCompany(company);
    }

    @RequestMapping(value = "/search/{pageNum}", method = RequestMethod.POST)
    public PagedList<BUResult> search(@PathVariable Integer pageNum, @RequestBody(required = false) QueryParameter parameter) {
        return buQuery.findAll(parameter, pageNum, null);
    }
}
