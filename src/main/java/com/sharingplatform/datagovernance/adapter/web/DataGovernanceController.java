package com.sharingplatform.datagovernance.adapter.web;

import com.sharingplatform.datagovernance.FlowButtonResult;
import com.sharingplatform.datagovernance.FlowCommand;
import com.sharingplatform.datagovernance.FlowEngine;
import com.sharingplatform.datagovernance.application.DataUsageApplicationCommand;
import com.sharingplatform.datagovernance.application.DataUsageApplicationService;
import com.sharingplatform.datagovernance.query.*;
import com.sharingplatform.framework.query.PagedList;
import com.sharingplatform.usecase.query.ValueResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by AMC on 2017/7/31.
 */
@RestController
@RequestMapping("/datagovernance")
public class DataGovernanceController {

    @Autowired
    SystemNameQuery systemNameQuery;

    @Autowired
    DataTypeQuery dataTypeQuery;

    @Autowired
    SystemLocationQuery systemLocationQuery;

    @Autowired
    ApplicationQuery applicationQuery;

    @Autowired
    DataUsageApplicationService dataUsageApplicationService;

    @Autowired
    FlowEngine flowEngine;

    @Autowired
    TaskQuery taskQuery;

    @Autowired
    FlowInstanceQuery flowInstanceQuery;

    @RequestMapping(value = "/systemnames", method = RequestMethod.GET)
    public List<SystemNameResult> findAllSystemName() {
        return systemNameQuery.findAllSystemName();
    }

    @RequestMapping(value = "/systemnameconfig", method = RequestMethod.GET)
    public List<SystemNameConfigResult> findAllSystemNameConfig() {
        return systemNameQuery.findAllSystemNameConfig();
    }

    @RequestMapping(value = "/datatypes", method = RequestMethod.GET)
    public List<ValueResult> findAllDataTypes() {
        return dataTypeQuery.findAll();
    }

    @RequestMapping(value = "/systemlocations", method = RequestMethod.GET)
    public List<ValueResult> findAllSystemLocations() {
        return systemLocationQuery.findAll();
    }

    @RequestMapping(value = "/datausageapplication/create", method = RequestMethod.POST)
    public Long createApplication(@RequestBody DataUsageApplicationCommand command) {
        return dataUsageApplicationService.createApplication(command);
    }

    @RequestMapping(value = "/datausageapplication/{id}", method = RequestMethod.GET)
    public ApplicationResult getApplicationById(@PathVariable Long id) {
        return applicationQuery.findById(id);
    }

    @RequestMapping(value = "/flowengine", method = RequestMethod.POST)
    public void processFlow(@RequestBody FlowCommand flowCommand) {
        flowEngine.processFlow(flowCommand);
    }

    @RequestMapping(value = "/flowengine/flowbuttons/{stepKey}", method = RequestMethod.GET)
    public List<FlowButtonResult> getFlowButtons(@PathVariable String stepKey) {
        return flowEngine.getFlowButtons(stepKey);
    }

    @RequestMapping(value = "/flowengine/tasks/{pageNum}", method = RequestMethod.POST)
    public PagedList<TaskResult> getTasks(@PathVariable Integer pageNum, @RequestBody TaskQueryParameter queryParameter) {
        return taskQuery.listTasks(queryParameter, pageNum);
    }

    @RequestMapping(value = "/flowengine/task", method = RequestMethod.POST)
    public TaskResult getTaskById(@RequestBody TaskQueryParameter parameter) {
        return taskQuery.findOne(parameter);
    }

    @RequestMapping(value = "/flowengine/instances/{pageNum}", method = RequestMethod.POST)
    public PagedList<FlowInstanceResult> listFlowInstances(@PathVariable Integer pageNum, @RequestBody FlowInstanceQueryParameter parameter) {
        return flowInstanceQuery.listFlowInstances(parameter, pageNum);
    }

    @RequestMapping(value = "/flowengine/supervisor/{applicant}", method = RequestMethod.GET)
    public String findSupervisor(@PathVariable String applicant) {
        return flowInstanceQuery.findSupervisor(applicant);
    }

    @RequestMapping(value = "/flowengine/instance/{flowInstanceId}/tracking", method = RequestMethod.GET)
    public List<TaskResult> listFlowTracking(@PathVariable Long flowInstanceId) {
        return taskQuery.listFlowTracking(flowInstanceId);
    }
}