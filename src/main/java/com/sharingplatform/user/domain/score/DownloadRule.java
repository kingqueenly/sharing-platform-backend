package com.sharingplatform.user.domain.score;

/**
 * Created by paulliu on 2017/1/17.
 */
public class DownloadRule extends Rule {

    public DownloadRule(Long userId) {
        super(userId);
    }

    @Override
    public boolean meetCondition() {

        boolean maxTimesPerDay = this.userCommentLikeShare.getPerDayDownAttachTimes() == 2;

        if (!maxTimesPerDay) {
            return true;
        }
        return false;
    }

    @Override
    public void computeScore() {

        this.benzUser.computeScore(5);

        this.userCommentLikeShare.increaseDownloadTimes();
    }
}
