package com.benz.usecase.application;

import com.benz.framework.AssertionConcern;
import com.benz.usecase.domain.*;
import com.benz.usecase.query.CommentQuery;
import com.benz.usecase.query.CommentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by hongying.fu on 1/13/2017.
 */
@Service
public class CommentApplicationService {
    @Autowired
    private UserInfoService userInfoService;

    @Transactional
    public Long createComment(CommentCommand command) {
        UserInfo userInfo = existingUser(command.getOperatorId());
        UseCase useCase = existingUseCase(command.getUseCaseId());
        Comment parentComment = parentComment(command.getParentCommentId());

        Comment comment = new Comment(useCase.getId(), command.getContent(), parentComment, userInfo);
        comment.create();

        return comment.getId();
    }

    private Comment parentComment(Long id) {
        if (id != null && !"".equals(id)) {
            Comment comment = DomainRegistry.commentRepository().findOne(id);
            return comment;
        }
        return null;
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

    @Transactional
    public void deleteComment(Long id) {
        Comment comment = existingComment(id);
        System.out.println("parent:"+comment.getComment());
        UseCase useCase = existingUseCase(comment.getUseCaseId());
        CaseCommentLikeShare caseCommentLikeShare = useCase.getCaseCommentLikeShare();
        caseCommentLikeShare.subCommentNum(1);
        if(null ==comment.getComment()){
            List<Comment> children = DomainRegistry.commentRepository().getChildrenByParentId(comment.getId());
            caseCommentLikeShare.subCommentNum(children.size());
            DomainRegistry.commentRepository().delete(children);

        }
        comment.delete();

    }

    private Comment existingComment(Long id) {
        Comment comment=DomainRegistry.commentRepository().findOne(id);
        return comment;
    }
}
