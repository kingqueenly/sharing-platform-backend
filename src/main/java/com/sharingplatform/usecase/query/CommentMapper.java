package com.benz.usecase.query;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by hongying.fu on 1/13/2017.
 */

@Mapper
public interface CommentMapper {
    List<CommentResult> searchCommentByUseCaseId(CommentParameter useCaseId);

    CommentResult findById(String id);
//    List<CommentResult> getChildrenByParentId(String pcId);
}
