package com.benz.user.domain.score;

import java.util.Date;

/**
 * Created by paulliu on 2017/1/17.
 */
public class ShareRule extends Rule {

    public ShareRule(Long userId) {
        super(userId);
    }

    @Override
    public boolean meetCondition() {

        boolean maxTimesPerDay = this.userCommentLikeShare.getPerDayShareTimes() == 5;

        if (!maxTimesPerDay) {
            return true;
        }
        return false;
    }

    @Override
    public void computeScore() {

        this.benzUser.computeScore(20);

        this.userCommentLikeShare.increaseShareTimes();
    }
}
