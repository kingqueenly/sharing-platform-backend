package com.sharingplatform.user.domain.score;

/**
 * Created by paulliu on 2017/1/17.
 */
public class CreateCaseRule extends Rule {

    public CreateCaseRule(Long userId) {
        super(userId);
    }

    @Override
    public boolean meetCondition() {

        return true;
    }

    @Override
    public void computeScore() {

        this.benzUser.computeScore(100);
    }
}
