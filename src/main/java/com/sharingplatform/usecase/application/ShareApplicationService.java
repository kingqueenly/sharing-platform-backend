package com.benz.usecase.application;

import com.benz.framework.AssertionConcern;
import com.benz.usecase.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by hongying.fu on 1/14/2017.
 */
@Service
public class ShareApplicationService {
    @Autowired
    private UserInfoService userInfoService;

    @Transactional
    public void createShare(ShareCommand command) {

        UserInfo userInfo = existingUser(command.getOperatorId());
        UseCase useCase = existingUseCase(command.getUseCaseId());

        Share share = new Share(useCase.getId(), userInfo);
        share.create();
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
