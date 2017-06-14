package com.benz.user.domain.score;

/**
 * Created by paulliu on 2017/1/17.
 */
public class UnLikeRule extends Rule {

    public UnLikeRule(Long userId) {
        super(userId);
    }

    @Override
    public boolean meetCondition() {

        return true;
    }

    @Override
    public void computeScore() {

        this.benzUser.computeScore(-10);
    }
}
