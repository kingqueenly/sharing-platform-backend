package com.sharingplatform.datagovernance.query;

import com.sharingplatform.framework.query.BaseQuery;
import com.sharingplatform.framework.query.PageParameter;
import com.sharingplatform.framework.query.PagedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;


/**
 * Created by AMC on 2017/6/28.
 */
@Service
public class TaskQuery extends BaseQuery {

    @Autowired
    private TaskMapper taskMapper;

    public PagedList<TaskResult> listTasks(final TaskQueryParameter parameter, Integer pageNum) {
        PagedList<TaskResult> taskResultPagedList = paging(parameter, new Callable<List<TaskResult>>() {
            public List<TaskResult> call() {
                return taskMapper.findTasks(parameter.getUserId(), parameter.getStatus());
            }
        }, new PageParameter(pageNum));

        return taskResultPagedList;
    }

    public TaskResult findOne(TaskQueryParameter parameter) {
        return taskMapper.findOne(parameter);
    }

    public Integer getInprocessCount(Long flowInstanceId, String stepKey) {
        return taskMapper.getInprocessCount(flowInstanceId, stepKey);
    }

    public List<TaskResult> listFlowTracking(Long flowInstanceId){
        return taskMapper.listFlowTracking(flowInstanceId);
    }

}
