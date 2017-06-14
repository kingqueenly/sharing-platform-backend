package com.benz.user.query;

/**
 * Created by hongying.fu on 1/20/2017.
 */
public class LevelResult {
    private String id;
    private String name;
    private Integer minScore;
    private Integer maxScore;

    public LevelResult() {
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

    @Override
    public String toString() {
        return "LevelResult{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", minScore=" + minScore +
                ", maxScore=" + maxScore +
                '}';
    }
}
