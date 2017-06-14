package com.sharingplatform.user.application;

import com.sharingplatform.framework.AssertionConcern;
import com.sharingplatform.usecase.application.BUCreateCommand;
import com.sharingplatform.usecase.application.BUUpdateCommand;
import com.sharingplatform.usecase.domain.ContribitionBURepository;
import com.sharingplatform.usecase.domain.ContributionBU;
import com.sharingplatform.user.domain.Role;
import com.sharingplatform.user.domain.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 5/2/2017.
 */
@Service
public class RoleApplicationService {
    @Autowired
    private RoleRepository roleRepository;

    public Long createRole(RoleCreateCommand command) {
        Role role = new Role(command.getText());
        return role.create();
    }

    @Transactional
    public void updateRole(RoleUpdateCommand command) {
        Role role = existingRole(command.getId());

        role.update(command.getText());
    }

    public void deleteRole(Long id) {
        Role role = existingRole(new Long(id));
        role.delete();
    }

    private Role existingRole(Long id) {
        Role role = roleRepository.findOne(id);
        AssertionConcern.assertArgumentNotNull(role, "Role does not exist");
        return role;
    }
}
