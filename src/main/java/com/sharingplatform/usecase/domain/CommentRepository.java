package com.benz.usecase.domain;

import com.benz.framework.jpa.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by hongying.fu on 1/13/2017.
 */
public interface CommentRepository extends BaseRepository<Comment, Long> {

    @Query(value = "SELECT * From comments WHERE parent_comment_id=?1", nativeQuery = true)
    List<Comment> getChildrenByParentId(Long parentId);
}
