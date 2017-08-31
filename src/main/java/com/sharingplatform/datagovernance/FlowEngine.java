package com.sharingplatform.datagovernance;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.sharingplatform.datagovernance.application.DataUsageApplicationService;
import com.sharingplatform.datagovernance.domain.*;
import com.sharingplatform.datagovernance.query.SystemNameQuery;
import com.sharingplatform.datagovernance.query.TaskQuery;
import com.sharingplatform.datagovernance.query.TaskQueryParameter;
import com.sharingplatform.datagovernance.query.TaskResult;
import com.sharingplatform.framework.MailService;
import com.sharingplatform.user.application.UserApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by AMC on 2017/8/16.
 */
@Component
public class FlowEngine {

    @Autowired
    SystemNameQuery systemNameQuery;

    @Autowired
    TaskQuery taskQuery;

    @Autowired
    MailService mailService;

    @Autowired
    UserApplicationService userApplicationService;

    @Autowired
    DataUsageApplicationService dataUsageApplicationService;


    static FlowConfiguration flowConfiguration = new FlowConfiguration();

    public void processFlow(FlowCommand flowCommand) {

        if(flowCommand.getTaskId() != null) {
            pushFlow(flowCommand);
        } else {
            startFlow(flowCommand);
        }
    }

    private void pushFlow(FlowCommand flowCommand) {

        String nextStep = flowConfiguration.getNextStep(flowCommand.getStepKey(), flowCommand.getButtonName());

        Long newApplicationFormId = null;
        Long preApplicationFormId = null;
        if("form-filling".equals(flowCommand.getStepKey()) && !"".equals(nextStep)) {
            DataUsageApplication application = new DataUsageApplication(flowCommand.getApplication());
            newApplicationFormId = application.create();
        }

        Long taskId = flowCommand.getTaskId();
        TaskQueryParameter parameter = new TaskQueryParameter();
        parameter.setTaskId(taskId);
        TaskResult tr = taskQuery.findOne(parameter);

        completeTask(taskId, flowCommand.getComments(), flowCommand.getButtonName());

        FlowInstance flowInstance = FlowInstance.findById(tr.getFlowInstanceId());
        flowCommand.setSupervisor(flowInstance.getSupervisor());
        flowInstance.setUpdateTime(new Date());
        flowInstance.setCurrentStep(nextStep);
        flowInstance.setCurrentTask(nextStep);
        if(newApplicationFormId != null) {
            preApplicationFormId = flowInstance.getApplicationFormId();
            flowInstance.setApplicationFormId(newApplicationFormId);
        }
        //flowInstance.setCurrentTask(tr.getTaskKey());
        if("".equals(nextStep) && "Close".equals(flowCommand.getButtonName())) {
            flowInstance.setStatus("closed");
        } else if ("".equals(nextStep)) {
            flowInstance.setStatus("completed");
        } else {
            flowInstance.setStatus("in process");
        }

        Integer inprocessCount = taskQuery.getInprocessCount(flowInstance.getId(), flowCommand.getStepKey());
        if(inprocessCount == 0) {
            flowInstance.update();
        }
        if("form-filling".equals(nextStep) && inprocessCount != 0) {
            cancel(flowCommand.getStepKey());
            flowInstance.update();
            inprocessCount = taskQuery.getInprocessCount(flowInstance.getId(), flowCommand.getStepKey());
        }
        if("".equals(nextStep) || inprocessCount != 0){
            return;
        }

        List<Candidate> candidates = getCandidates(nextStep, flowCommand);
        if(candidates.size() > 0) {
            for (Candidate candidate : candidates) {
                createTask(candidate.getUserId(), nextStep, candidate.getTaskKey(), flowInstance.getId(), flowInstance.getApplicationName(), flowInstance.getApplicationFormId(), preApplicationFormId);
            }
        }
    }

    private void startFlow(FlowCommand flowCommand) {
        DataUsageApplication application = new DataUsageApplication(flowCommand.getApplication());
        Long applicationFormId = application.create();

        String nextStep = flowConfiguration.getNextStep(flowCommand.getStepKey(), flowCommand.getButtonName());
        String applicationName = generateApplicationName(flowCommand);
        FlowInstance flowInstance = new FlowInstance();
        flowInstance.setApplicationFormId(applicationFormId);
        flowInstance.setApplicationName(applicationName);
        flowInstance.setCurrentStep(nextStep);
        flowInstance.setCurrentTask(nextStep);
        flowInstance.setStatus("in process");
        flowInstance.setCreateTime(new Date());
        flowInstance.setApplicant(flowCommand.getUserId());
        flowInstance.setSupervisor(flowCommand.getSupervisor());
        Long flowInstanceId = flowInstance.create();

        Long initedTaskId = createTask(flowCommand.getUserId(), flowCommand.getStepKey(), "Fill Data", flowInstanceId, applicationName, applicationFormId, null);
        completeTask(initedTaskId, flowCommand.getComments(), flowCommand.getButtonName());

        List<Candidate> candidates = getCandidates(nextStep, flowCommand);
        if(candidates.size() > 0) {
            for (Candidate candidate : candidates) {
                createTask(candidate.userId, nextStep, candidate.getTaskKey(), flowInstanceId, applicationName, applicationFormId, null);
            }
        }
    }

    private List<Candidate> getCandidates(String nextStep, FlowCommand flowCommand) {
        List<Candidate> candidates = new ArrayList<Candidate>();
        String stepKey = flowCommand.getStepKey();
        //List<String> candidates = new ArrayList<String>();
        if ("form-filling".equals(nextStep)) {
            TaskQueryParameter parameter = new TaskQueryParameter();
            parameter.setTaskId(flowCommand.getTaskId());
            TaskResult t = taskQuery.findOne(parameter);
            Candidate candidate = new Candidate();
            candidate.setTaskKey("Fill Data");
            candidate.setUserId(t.getApplicant());
            candidates.add(candidate);
        } else if ("pre-check".equals(nextStep)) {
            Candidate candidate = new Candidate();
            candidate.setTaskKey("Pre-check");
            //candidate.setUserId("WANJCHE");
            candidate.setUserId("WELIU11");
            candidates.add(candidate);
        } else if ("supervisor-approval".equals(nextStep)) {
            Candidate candidate = new Candidate();
            candidate.setTaskKey("Applicant's Supervisor");
            candidate.setUserId(flowCommand.getSupervisor());
            candidates.add(candidate);
        } else if ("manager-approval".equals(nextStep)) {
            List<String> dataOwnerIds = systemNameQuery.findDataOwnerIds(flowCommand.getApplication().getSystemNames());
            for (String ownerId : dataOwnerIds) {
                Candidate candidate = new Candidate();
                candidate.setTaskKey("Data Owner");
                candidate.setUserId(ownerId);
                candidates.add(candidate);
            }
//            Robert Bruce, ROBRUCE
//            Legal: Dawn Beck, T7588DB
//            Internal Control: ?
//            Information Security: Cora (Liao Chunhong), CHULIAO
//            Compliance: Stefan Schmitt, MAHUTA
            Candidate c1 = new Candidate();
            c1.setTaskKey("Data Lake Gatekeeper");
            //c1.setUserId("ROBRUCE");
            c1.setUserId("WELIU11");
            candidates.add(c1);
            Candidate c2 = new Candidate();
            c2.setTaskKey("Legal");
            //c2.setUserId("T7588DB");
            c2.setUserId("WELIU11");
            candidates.add(c2);
            Candidate c3 = new Candidate();
            c3.setTaskKey("Information Security");
            //c3.setUserId("NAUENVE");
            c3.setUserId("WELIU11");
            candidates.add(c3);
        } else if ("data-lake-architect".equals(nextStep)) {
            Candidate candidate = new Candidate();
            candidate.setTaskKey("Data Lake Architect");
            //candidate.setUserId("SHENLUO");
            candidate.setUserId("WELIU11");
            candidates.add(candidate);
        }
        return candidates;
    }

    private class Candidate {
        private String taskKey;
        private String userId;

        public String getTaskKey() {
            return taskKey;
        }

        public void setTaskKey(String taskKey) {
            this.taskKey = taskKey;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

    }

    public void completeTask(Long taskId, String comment, String buttonName){
        Task task = Task.findById(taskId);
        task.setUpdateTime(new Date());
        task.setStatus("completed");
        task.setComments(comment);
        task.setButtonName(buttonName);
        task.update();
    }

    private Long createTask(String userId, String stepKey,String taskKey, Long flowInstanceId, String applicationName, Long applicationFormId, Long preApplicationFormId) {
        Task task = new Task();
        task.setFlowInstanceId(flowInstanceId);
        task.setStepKey(stepKey);
        task.setTaskKey(taskKey);
        task.setApplicationName(applicationName);
        task.setUserId(userId);
        task.setApplicationFormId(applicationFormId);
        task.setStatus("in process");
        task.setCreateTime(new Date());
        task.setPrevFormId(preApplicationFormId);
        Long id = task.create();
        return id;
    }

    private String generateApplicationName(FlowCommand flowCommand) {
        List<SystemName> systemNames = flowCommand.getApplication().getSystemNames();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < systemNames.size(); i++) {
            SystemName systemName = systemNames.get(i);
            sb.append(systemName.getText() + ", ");
        }

        String applicationName = "Data usage application for " + sb.substring(0, sb.length() - 2);

        return applicationName;
    }

    public List<FlowButtonResult> getFlowButtons(String stepKey) {
        List<FlowButtonResult> fbrs = new ArrayList<FlowButtonResult>();
        ArrayNode arrayNode = flowConfiguration.getFlowButtons(stepKey);
        for(int i = 0; i < arrayNode.size(); i++) {
            JsonNode node = arrayNode.get(i);
            FlowButtonResult fbr = new FlowButtonResult();
            fbr.setButtonName(node.get("buttonName").asText());
            fbr.setNextStep(node.get("nextStep").asText());
            fbrs.add(fbr);
        }
        return fbrs;
    }

    public void cancel(String stepKey) {
//        Customer customer = new Customer();
//        customer.setName("刘");
//        customer.setAddress("河南省郑州市");
//
//        //创建匹配器，即如何使用查询条件
//        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
//                .withMatcher("name", GenericPropertyMatchers.startsWith()) //姓名采用“开始匹配”的方式查询
//                .withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
//
//        //创建实例
//        Example<Customer> ex = Example.of(customer, matcher);

        Task task = new Task();
        task.setStatus("in process");
        task.setStepKey(stepKey);
        Example<Task> ex = Example.of(task);

        List<Task> inprocessTasks = DomainRegistry.taskRepository().findAll(ex);
        for(Task t : inprocessTasks) {
            t.setUpdateTime(new Date());
            t.setStatus("Canceled");
            t.update();
        }
    }
}
