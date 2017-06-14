package com.sharingplatform.usecase.adapter.web;

import com.sharingplatform.framework.domain.QueryParameter;
import com.sharingplatform.framework.query.PagedList;
import com.sharingplatform.usecase.application.UseCaseApplicationService;
import com.sharingplatform.usecase.application.UseCaseCreateCommand;
import com.sharingplatform.usecase.application.UseCaseUpdateCommand;
import com.sharingplatform.usecase.domain.CategoryList;
import com.sharingplatform.usecase.domain.PhaseList;
import com.sharingplatform.usecase.query.CategoryListParameter;
import com.sharingplatform.usecase.query.UseCaseParameter;
import com.sharingplatform.usecase.query.UseCaseQuery;
import com.sharingplatform.usecase.query.UseCaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by paulliu on 2016/12/12.
 */
@RestController
@RequestMapping("/usecase")
public class UseCaseController {
    @Autowired
    private UseCaseApplicationService useCaseApplicationService;
    @Autowired
    private UseCaseQuery useCaseQuery;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody UseCaseCreateCommand aCommand) {
        useCaseApplicationService.createUseCase(aCommand);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public void update(@PathVariable Long id, @RequestBody UseCaseUpdateCommand command) {
        command.setId(id);
        useCaseApplicationService.updateUseCase(command);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void delete(@PathVariable Long id) {
        useCaseApplicationService.deleteUseCase(id);
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public UseCaseResult findOne(QueryParameter queryParameter, @PathVariable Long id) {
        return useCaseQuery.findById(queryParameter, id);
    }

    @RequestMapping(value = "/clone/{id}", method = RequestMethod.GET)
    public UseCaseResult cloneOne(QueryParameter queryParameter, @PathVariable Long id) {
        return findOne(queryParameter, id);
    }

    @RequestMapping(value = "/search/{pageNum}", method = RequestMethod.POST)
    public PagedList<UseCaseResult> search(@PathVariable Integer pageNum, @RequestBody(required = false) UseCaseParameter parameter) {
        System.out.println(parameter);
        return useCaseQuery.findAll(parameter, pageNum);
    }

    @RequestMapping(value = "/userCreateCase/{pageNum}", method = RequestMethod.POST)
    public PagedList<UseCaseResult> findByCreateUserId(@PathVariable Integer pageNum, @RequestBody(required = false) UseCaseParameter parameter) {
        //get user info from request header
        if (parameter == null) {
            parameter = new UseCaseParameter();
        }
//        System.out.println("parameter1:"+parameter);
//        parameter.setCreateUserId(parameter.getOperatorId());
        return useCaseQuery.findAllByUserId(parameter, pageNum);
    }

    @RequestMapping(value = "/userLikeCase/{pageNum}", method = RequestMethod.POST)
    public PagedList<UseCaseResult> findByLikeUserId(@PathVariable Integer pageNum, @RequestBody(required = false) UseCaseParameter parameter) {
        //get user info from request header
        if (parameter == null) {
            parameter = new UseCaseParameter();
        }
//        System.out.println("parameter2:"+parameter);
//        parameter.setLikeUserId(parameter.getOperatorId());
        return useCaseQuery.findAllByLikeUserId(parameter, pageNum);
    }

    @RequestMapping(value = "/contributionBU/{pageNum}", method = RequestMethod.POST)
    public PagedList<UseCaseResult> findByContributionBU(@PathVariable Integer pageNum, @RequestBody(required = false) UseCaseParameter parameter) {
        return useCaseQuery.findByContributionBU(parameter, pageNum);
    }

    @RequestMapping(value = "/phase",method = RequestMethod.POST)
    public List<PhaseList> findByPhases(@RequestBody List<String> phases){
        return useCaseQuery.findByPhases(phases);
    }

    @RequestMapping(value = "/category",method = RequestMethod.POST)
    public List<CategoryList> findByCategory(@RequestBody(required = true) CategoryListParameter parameter){
        return useCaseQuery.findByCategory(parameter);
    }

    @RequestMapping(value = "/phaseStage/{pageNum}",method = RequestMethod.POST)
    public PagedList<UseCaseResult> findByPhaseStage(@PathVariable Integer pageNum, @RequestBody(required = false) UseCaseParameter parameter){
        return useCaseQuery.findByPhaseStage(parameter,pageNum);
    }
}
