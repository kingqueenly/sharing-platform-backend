package com.sharingplatform.datagovernance.query;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by AMC on 2017/8/18.
 */@Mapper
public interface FlowInstanceMapper {

    List<FlowInstanceResult> findFlowInstances(String applicant);

    String findSupervisor(String applicant);

}
