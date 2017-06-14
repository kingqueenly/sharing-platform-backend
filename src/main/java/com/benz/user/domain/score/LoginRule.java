package com.benz.user.domain.score;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

/**
 * Created by paulliu on 2017/1/17.
 */
public class LoginRule extends Rule {

    public LoginRule(Long userId) {
        super(userId);
    }

    @Override
    public boolean meetCondition() {

        Boolean isLoginToDay = this.userCommentLikeShare.getLoginPerDay();

        if (isToday()) {
            return false;
        }
        return true;
    }

    @Override
    public void computeScore() {

        this.benzUser.computeScore(5);

        if (!isToday()) {
            this.userCommentLikeShare.initToday();
        }
    }

    private boolean isToday() {
        Date today = new Date(System.currentTimeMillis());
        Date lastDay = this.userCommentLikeShare.getPerDay();
        System.out.println("today:"+today);
        System.out.println("lastDay:"+lastDay);
        return DateUtils.isSameDay(lastDay, today);
    }
}
