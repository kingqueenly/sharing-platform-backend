package com.sharingplatform.user.domain;

/**
 * Created by hongying.fu on 1/18/2017.
 */
public class Level {
    private String id;
    private String name;
    private Integer minScore;
    private Integer maxScore;

    public Level() {
    }

    public Level(String id, String name, Integer minScore, Integer maxScore) {
        this.id = id;
        this.name = name;
        this.minScore = minScore;
        this.maxScore = maxScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinScore() {
        return minScore;
    }

    public void setMinScore(Integer minScore) {
        this.minScore = minScore;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }
}
