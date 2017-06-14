package com.benz.usecase.application;

import com.benz.framework.AssertionConcern;
import com.benz.usecase.domain.ContribitionBURepository;
import com.benz.usecase.domain.ContributionBU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by paulliu on 2016/12/12.
 */
@Service
public class BUApplicationService {

    @Autowired
    private ContribitionBURepository contribitionBURepository;

    public Long createBU(BUCreateCommand command) {
        ContributionBU bu = new ContributionBU(command.getText(), command.getOrg(), command.getDept());
        return bu.create();
    }

    @Transactional
    public void updateBU(BUUpdateCommand command) {
        ContributionBU bu = existingBU(command.getId());

        bu.update(command.getText(), command.getOrg(), command.getDept());
    }

    public void deleteBU(Long id) {
        ContributionBU bu = existingBU(new Long(id));
        bu.delete();
    }

    private ContributionBU existingBU(Long id) {
        ContributionBU bu = contribitionBURepository.findOne(id);
        AssertionConcern.assertArgumentNotNull(bu, "Contribution bu does not exist");
        return bu;
    }
}
