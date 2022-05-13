package com.example.engagementKpi.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExecutionExcellance {
    private String id;
    private String weekEnding;
    @Id
    private long projectId;
    private int committedStories;
    private int actualStories;
    private int velocity;
    private int velocityAvg;
    private float sayDoRatio;
    private float sayDoRatioAvg;
    private float defectsUAT;
    private float defectsUATAvg;

    public ExecutionExcellance() {
    }

    public ExecutionExcellance(String id, String weekEnding, long projectId, int committedStories, int actualStories, int velocity, int velocityAvg, float sayDoRatio, float sayDoRatioAvg, float defectsUAT, float defectsUATAvg) {
        this.id = id;
        this.weekEnding = weekEnding;
        this.projectId = projectId;
        this.committedStories = committedStories;
        this.actualStories = actualStories;
        this.velocity = velocity;
        this.velocityAvg = velocityAvg;
        this.sayDoRatio = sayDoRatio;
        this.sayDoRatioAvg = sayDoRatioAvg;
        this.defectsUAT = defectsUAT;
        this.defectsUATAvg = defectsUATAvg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWeekEnding() {
        return weekEnding;
    }

    public void setWeekEnding(String weekEnding) {
        this.weekEnding = weekEnding;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public int getCommittedStories() {
        return committedStories;
    }

    public void setCommittedStories(int committedStories) {
        this.committedStories = committedStories;
    }

    public int getActualStories() {
        return actualStories;
    }

    public void setActualStories(int actualStories) {
        this.actualStories = actualStories;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getVelocityAvg() {
        return velocityAvg;
    }

    public void setVelocityAvg(int velocityAvg) {
        this.velocityAvg = velocityAvg;
    }

    public float getSayDoRatio() {
        return sayDoRatio;
    }

    public void setSayDoRatio(float sayDoRatio) {
        this.sayDoRatio = sayDoRatio;
    }

    public float getSayDoRatioAvg() {
        return sayDoRatioAvg;
    }

    public void setSayDoRatioAvg(float sayDoRatioAvg) {
        this.sayDoRatioAvg = sayDoRatioAvg;
    }

    public float getDefectsUAT() {
        return defectsUAT;
    }

    public void setDefectsUAT(float defectsUAT) {
        this.defectsUAT = defectsUAT;
    }

    public float getDefectsUATAvg() {
        return defectsUATAvg;
    }

    public void setDefectsUATAvg(float defectsUATAvg) {
        this.defectsUATAvg = defectsUATAvg;
    }
}
