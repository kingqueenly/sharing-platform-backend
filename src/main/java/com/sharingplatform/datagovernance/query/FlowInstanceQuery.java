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
public class FlowInstanceQuery extends BaseQuery {

    @Autowired
    private FlowInstanceMapper flowInstanceMapper;

    public PagedList<FlowInstanceResult> listFlowInstances(final FlowInstanceQueryParameter parameter, Integer pageNum) {
        PagedList<FlowInstanceResult> flowInstanceResultPagedList = paging(parameter, new Callable<List<FlowInstanceResult>>() {
            public List<FlowInstanceResult> call() {
                return flowInstanceMapper.findFlowInstances(parameter.getApplicant());
            }
        }, new PageParameter(pageNum));

        return flowInstanceResultPagedList;
    }

    public String findSupervisor(String applicant) {
        return flowInstanceMapper.findSupervisor(applicant);
    }

}
