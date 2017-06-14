package com.benz.usecase.domain;

import com.benz.framework.mvc.SpringBootApplicationContext;
import com.benz.user.domain.UserRepository;
import org.springframework.context.ApplicationEventPublisher;

/**
 * Created by paulliu on 2016/12/12.
 */
public class DomainRegistry {

    public static UseCaseRepository useCaseRepository() {
        return SpringBootApplicationContext.getBean(UseCaseRepository.class);
    }

    public static AnalysisMethodResultFileRepository analysisMethodResultFileRepository() {
        return SpringBootApplicationContext.getBean(AnalysisMethodResultFileRepository.class);
    }

    public static ValidationMethodResultRepository validationMethodResultRepository() {
        return SpringBootApplicationContext.getBean(ValidationMethodResultRepository.class);
    }

    public static ImplMethodResultRepository implMethodResultRepository() {
        return SpringBootApplicationContext.getBean(ImplMethodResultRepository.class);
    }

    public static AttachmentRepository attachmentRepository() {
        return SpringBootApplicationContext.getBean(AttachmentRepository.class);
    }

    public static ValueRepository valueRepository() {
        return SpringBootApplicationContext.getBean(ValueRepository.class);
    }

    public static DataSourceRepository dataSourceRepository() {
        return SpringBootApplicationContext.getBean(DataSourceRepository.class);
    }

    public static DataAnalysisModelRepository dataAnalysisModelRepository() {

        return SpringBootApplicationContext.getBean(DataAnalysisModelRepository.class);
    }

    public static CommentRepository commentRepository() {
        return SpringBootApplicationContext.getBean(CommentRepository.class);
    }

    public static CaseCommentLikeShareRepository caseCommentLikeShareRepository() {
        return SpringBootApplicationContext.getBean(CaseCommentLikeShareRepository.class);
    }

    public static LikeCaseRepository likeCaseRepository() {
        return SpringBootApplicationContext.getBean(LikeCaseRepository.class);
    }

    public static ShareRepository shareRepository() {
        return SpringBootApplicationContext.getBean(ShareRepository.class);
    }

    public static ContribitionBURepository contribitionBURepository() {
        return SpringBootApplicationContext.getBean(ContribitionBURepository.class);
    }
}
