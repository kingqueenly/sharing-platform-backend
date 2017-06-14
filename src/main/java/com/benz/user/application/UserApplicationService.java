package com.benz.user.application;

import com.benz.framework.AssertionConcern;
import com.benz.framework.mvc.SpringBootApplicationContext;
import com.benz.upload.application.FileParameters;
import com.benz.user.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by paulliu on 2016/12/7.
 */
@Service
public class UserApplicationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public Long createUser(UserCreateCommand command) {
//        String imgHttpUrl = SpringBootApplicationContext.getBean(FileParameters.class).getUrl();

//        command.setImageUrl(" http://localhost:8081/2017/02/07/20170207165045643696.png");
//        command.setImageUrl("/2017/04/14/20170414154305456918.jpg");
        command.setLevel("Iron");
        command.setScore(5);
        UserCommentLikeShare userCommentLikeShare = new UserCommentLikeShare(false, 0, 0, 0,
                0, 0);
//        Role role=parseRole(command.getRole());
        BenzUser benzUser = new BenzUser(
                command.getUserId(),
                command.getAppellation(),
                command.getUsername(),
                command.getImgUrl(),
                command.getOrganization(),
                command.getDepartment(),
                command.getWorkArea(),
                command.getProfessional(),
                command.getEmail(),
                command.getPhone(),
                command.getMobile(),
                command.getScore(),
                command.getLevel(),
                new Authority(command.getAuthority()),
                command.getRole(),
                command.getIsDCRemember(),
                userCommentLikeShare);
        benzUser.create();

        return benzUser.getId();
    }

    @Transactional
    public void updateUser(UserUpdateCommand command,HttpServletRequest request) {
        BenzUser user = existingUser(command.getId());
//        Role role=parseRole(command.getRole());
        user.update(command.getAppellation(),
                    command.getUsername(),
                    command.getImgUrl(),
                    command.getOrganization(),
                    command.getDepartment(),
                    command.getWorkArea(),
                    command.getProfessional(),
                    command.getEmail(),
                    command.getPhone(),
                    command.getMobile(),
                    new Authority(command.getAuthority()),
                    command.getRole(),
                    command.getIsDCRemember(),
                    command.getDeleted()
        );
        BenzUser u=(BenzUser) request.getSession().getAttribute("user");
        if(u.getId()==command.getId()){
         request.getSession().setAttribute("user",u);
        }
    }

    public void deleteUser(Long id) {
        BenzUser user = existingUser(id);
        user.delete();
    }

    private BenzUser existingUser(Long id) {
        BenzUser user = userRepository.findOne(id);
        AssertionConcern.assertArgumentNotNull(user, "User does not exist");
        return user;
    }


}
