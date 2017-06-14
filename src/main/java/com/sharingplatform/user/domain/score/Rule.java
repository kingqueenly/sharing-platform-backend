package com.benz.user.domain.score;

import com.benz.user.domain.BenzUser;
import com.benz.user.domain.DomainRegistry;
import com.benz.user.domain.Level;
import com.benz.user.domain.UserCommentLikeShare;

import java.util.List;

/**
 * Created by paulliu on 2017/1/17.
 */
public abstract class Rule {

    protected BenzUser benzUser;
    protected UserCommentLikeShare userCommentLikeShare;

    public Rule(Long userId) {
        this.benzUser = DomainRegistry.userRepository().getOne(userId);
        this.userCommentLikeShare = this.benzUser.getUserCommentLikeShare();
        System.out.println("benzUser:"+this.benzUser);
//        System.out.println("userCommentLikeShare:"+this.userCommentLikeShare);

    }

    public void execute() {
        if (meetCondition()) {
            computeScore();
            computeLevel();

            DomainRegistry.userRepository().save(this.benzUser);
        }
    }

    protected abstract boolean meetCondition();

    protected abstract void computeScore();

    private void computeLevel() {
        List<Level> levelList = DomainRegistry.levelRepository().findAll();
        Integer score = this.benzUser.getScore();

        for (Level level : levelList) {
            if (score >= level.getMinScore()) {
                if (level.getMaxScore() == null) {
                    this.benzUser.setLevel(level.getName());
                    break;
                } else {
                    if (score < level.getMaxScore()) {
                        this.benzUser.setLevel(level.getName());
                        break;
                    }
                }
            }
        }
    }
}
