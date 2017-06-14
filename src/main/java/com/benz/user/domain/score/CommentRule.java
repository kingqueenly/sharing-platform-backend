package com.benz.user.domain.score;

import java.util.Date;

/**
 * Created by paulliu on 2017/1/17.
 */
public class CommentRule extends Rule {

    public CommentRule(Long userId) {
        super(userId);
    }

    @Override
    public boolean meetCondition() {

        boolean maxTimesPerDay = this.userCommentLikeShare.getPerDayCommentTimes() == 2;

        if (!maxTimesPerDay) {
            return true;
        }
        return false;
    }

    @Override
    public void computeScore() {

        this.benzUser.computeScore(10);

        this.userCommentLikeShare.increaseCommentTimes();
    }
}
