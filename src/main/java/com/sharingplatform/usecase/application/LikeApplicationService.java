package com.sharingplatform.usecase.application;

import com.sharingplatform.framework.AssertionConcern;
import com.sharingplatform.usecase.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by hongying.fu on 1/14/2017.
 */
@Service
public class LikeApplicationService {
    @Autowired
    private UserInfoService userInfoService;

    @Transactional
    public void createLike(LikeCommand command) {

        UserInfo userInfo = existingUser(command.getOperatorId());
        UseCase useCase = existingUseCase(new Long(command.getUseCaseId()));

        LikeCase like = findOne(userInfo.getId(), useCase.getId());
        if (like != null) {
            like.delete(useCase.getId());
        } else {
            LikeCase newLike = new LikeCase(useCase.getId(), userInfo);
            newLike.create();
        }
    }

    public LikeCase findOne(Long operatorId, Long useCaseId) {
        return DomainRegistry.likeCaseRepository().findMyLikeCase(operatorId, new Long(useCaseId));
    }

    private UserInfo existingUser(Long id) {
        UserInfo userInfo = userInfoService.findById(id);
        AssertionConcern.assertArgumentNotNull(userInfo, "userInfo does not exist");
        return userInfo;
    }

    private UseCase existingUseCase(Long id) {
        UseCase useCase = DomainRegistry.useCaseRepository().findOne(id);
        AssertionConcern.assertArgumentNotNull(useCase, "use case does not exist");
        return useCase;
    }
}
