package com.sharingplatform.usecase.domain;

import com.sharingplatform.framework.jpa.BaseRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * Created by hongying.fu on 1/13/2017.
 */


public interface LikeCaseRepository extends BaseRepository<LikeCase, Long> {

//    @Query(value = "SELECT * FROM like_case WHERE user_id = ?1 and use_case_id=?2", nativeQuery = true)

    @Query(value = "SELECT * From like_case WHERE user_id =?1 and use_case_id=?2", nativeQuery = true)
    LikeCase findMyLikeCase(Long userId, Long useCaseId);

}
