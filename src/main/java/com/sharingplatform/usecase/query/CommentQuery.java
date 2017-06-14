package com.sharingplatform.usecase.query;

import com.sharingplatform.framework.query.BaseQuery;
import com.sharingplatform.framework.query.PageParameter;
import com.sharingplatform.framework.query.PagedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by hongying.fu on 1/13/2017.
 */
@Service
public class CommentQuery extends BaseQuery{
    @Autowired
    private CommentMapper commentMapper;

    public PagedList<CommentResult> searchComment(final CommentParameter parameter, Integer pageNum) {
        PagedList<CommentResult> commentResultPagedList = paging(parameter, new Callable<List<CommentResult>>() {
            public List<CommentResult> call() {
                System.out.println("parameter:"+parameter.getUseCaseId());
                return commentMapper.searchCommentByUseCaseId(parameter);
            }
        }, new PageParameter(pageNum));

        return commentResultPagedList;
    }

//    public List<CommentResult> getChildrenByParentId(String pcId){
//        return commentMapper.getChildrenByParentId(pcId);
//    }
}
