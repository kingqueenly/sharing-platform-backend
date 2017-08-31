package com.sharingplatform.datagovernance.query;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by AMC on 2017/8/18.
 */
@Mapper
public interface TaskMapper {

    List<TaskResult> findTasks(@Param("userId") String userId, @Param("status") String status);

    TaskResult findOne(TaskQueryParameter parameter);

    Integer getInprocessCount(@Param("flowInstanceId") Long flowInstanceId, @Param("stepKey") String stepKey);

    List<TaskResult> listFlowTracking(Long flowInstanceId);

}
