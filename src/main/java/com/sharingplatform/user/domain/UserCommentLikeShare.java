package com.benz.user.domain;

import java.util.Date;

/**
 * Created by hongying.fu on 1/9/2017.
 */
public class UserCommentLikeShare {
    private Long id;
    private Boolean isLoginPerDay;
    private Integer perDayViewCaseTimes;  //2
    private Integer perDayDownAttachTimes;  //2
    private Integer perDayCommentTimes;  //2
    private Integer perDayLikeTimes;  //2
    private Integer perDayShareTimes;  //5
    private Date perDay;

    public UserCommentLikeShare() {
    }

    public UserCommentLikeShare(Boolean isLoginPerDay, Integer perDayViewCaseTimes, Integer perDayDownAttachTimes, Integer perDayCommentTimes, Integer perDayLikeTimes, Integer perDayShareTimes) {
        this.id = DomainRegistry.userRepository().nextIdentity();
        this.isLoginPerDay = isLoginPerDay;
        this.perDayViewCaseTimes = perDayViewCaseTimes;
        this.perDayDownAttachTimes = perDayDownAttachTimes;
        this.perDayCommentTimes = perDayCommentTimes;
        this.perDayLikeTimes = perDayLikeTimes;
        this.perDayShareTimes = perDayShareTimes;
        this.perDay = new Date(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getLoginPerDay() {
        return isLoginPerDay;
    }

    public void setLoginPerDay(Boolean loginPerDay) {
        isLoginPerDay = loginPerDay;
    }

    public Integer getPerDayViewCaseTimes() {
        return perDayViewCaseTimes;
    }

    public void setPerDayViewCaseTimes(Integer perDayViewCaseTimes) {
        this.perDayViewCaseTimes = perDayViewCaseTimes;
    }

    public Integer getPerDayDownAttachTimes() {
        return perDayDownAttachTimes;
    }

    public void setPerDayDownAttachTimes(Integer perDayDownAttachTimes) {
        this.perDayDownAttachTimes = perDayDownAttachTimes;
    }

    public Integer getPerDayCommentTimes() {
        return perDayCommentTimes;
    }

    public void setPerDayCommentTimes(Integer perDayCommentTimes) {
        this.perDayCommentTimes = perDayCommentTimes;
    }

    public Integer getPerDayLikeTimes() {
        return perDayLikeTimes;
    }

    public void setPerDayLikeTimes(Integer perDayLikeTimes) {
        this.perDayLikeTimes = perDayLikeTimes;
    }

    public Integer getPerDayShareTimes() {
        return perDayShareTimes;
    }

    public void setPerDayShareTimes(Integer perDayShareTimes) {
        this.perDayShareTimes = perDayShareTimes;
    }

    public Date getPerDay() {
        return perDay;
    }

    public void setPerDay(Date perDay) {
        this.perDay = perDay;
    }

    public void initToday(){
        this.setPerDay(new Date(System.currentTimeMillis()));
        this.setLoginPerDay(true);
        this.setPerDayShareTimes(0);
        this.setPerDayViewCaseTimes(0);
        this.setPerDayLikeTimes(0);
        this.setPerDayDownAttachTimes(0);
        this.setPerDayCommentTimes(0);
    }

    public void increaseViewTimes() {
        setPerDayViewCaseTimes(getPerDayViewCaseTimes() + 1);
    }

    public void resetViewTimes() {
        setPerDayViewCaseTimes(1);
    }

    public void increaseDownloadTimes() {
        setPerDayDownAttachTimes(getPerDayDownAttachTimes() + 1);
    }

    public void resetDownloadTimes() {
        setPerDayDownAttachTimes(1);
    }

    public void increaseCommentTimes() {
        setPerDayCommentTimes(getPerDayCommentTimes() + 1);
    }

    public void resetCommentTimes() {
        setPerDayCommentTimes(1);
    }

    public void increaseLikeTimes() {
        setPerDayLikeTimes(getPerDayLikeTimes() + 1);
    }

    public void resetLikeTimes() {
        setPerDayLikeTimes(1);
    }

    public void increaseShareTimes() {
        setPerDayShareTimes(getPerDayShareTimes() + 1);
    }

    public void resetShareTimes() {
        setPerDayShareTimes(1);
    }

    @Override
    public String toString() {
        return "UserCommentLikeShare{" +
                "id=" + id +
                ", isLoginPerDay=" + isLoginPerDay +
                ", perDayViewCaseTimes=" + perDayViewCaseTimes +
                ", perDayDownAttachTimes=" + perDayDownAttachTimes +
                ", perDayCommentTimes=" + perDayCommentTimes +
                ", perDayLikeTimes=" + perDayLikeTimes +
                ", perDayShareTimes=" + perDayShareTimes +
                ", perDay=" + perDay +
                '}';
    }
}
