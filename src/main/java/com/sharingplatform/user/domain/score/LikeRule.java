package com.sharingplatform.user.domain.score;

/**
 * Created by paulliu on 2017/1/17.
 */
public class LikeRule extends Rule {

    public LikeRule(Long userId) {
        super(userId);
    }

    @Override
    public boolean meetCondition() {

        boolean maxTimesPerDay = this.userCommentLikeShare.getPerDayLikeTimes() == 2;

        if (!maxTimesPerDay) {
            return true;
        }
        return false;
    }

    @Override
    public void computeScore() {

        this.benzUser.computeScore(10);

        this.userCommentLikeShare.increaseLikeTimes();
    }
}
