package com.benz.user.domain.score;

/**
 * Created by paulliu on 2017/1/17.
 */
public class ViewCaseRule extends Rule {

    public ViewCaseRule(Long userId) {
        super(userId);
    }

    @Override
    public boolean meetCondition() {

        boolean maxTimesPerDay = this.userCommentLikeShare.getPerDayViewCaseTimes() == 2;

        if (!maxTimesPerDay) {
            return true;
        }
        return false;
    }

    @Override
    public void computeScore() {

        this.benzUser.computeScore(5);

        this.userCommentLikeShare.increaseViewTimes();
    }
}
