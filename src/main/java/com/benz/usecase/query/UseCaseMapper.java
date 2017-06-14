package com.benz.usecase.query;

import com.benz.usecase.domain.CaseCommentLikeShare;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by paulliu on 2016/12/24.
 */
@Mapper
public interface UseCaseMapper {

    List<UseCaseResult> findAll(UseCaseParameter parameter);

    UseCaseResult findById(Long id);

    List<UseCaseResult> findByUserId(UseCaseParameter parameter);

    List<UseCaseResult> findByLikeUserId(UseCaseParameter parameter);

    CaseCommentLikeShare findCaseCommentLikeShareByUseCaseId(Long useCaseId);

    List<UseCaseResult> findByContributionBU(UseCaseParameter parameter);

    List<UseCaseResult> findByPhaseStage(UseCaseParameter parameter);
}
