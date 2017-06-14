package com.benz.user.application;

import com.benz.framework.AssertionConcern;
import com.benz.usecase.application.BUCreateCommand;
import com.benz.usecase.application.BUUpdateCommand;
import com.benz.usecase.domain.ContribitionBURepository;
import com.benz.usecase.domain.ContributionBU;
import com.benz.user.domain.Role;
import com.benz.user.domain.RoleRepository;
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
