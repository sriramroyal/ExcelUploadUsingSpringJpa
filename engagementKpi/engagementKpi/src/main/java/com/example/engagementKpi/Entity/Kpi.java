package com.example.engagementKpi.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Kpi {
    private String id;
    private String weekEnd;
    @Id
    @Column(length = 999999999)
    private long projectId;
    private int resignation;
    private int resignationWithdraw;
    private int amberScore;
    private int amberScoeAvg;

    public Kpi() {
    }

    public Kpi(String id, String weekEnd, long projectId, int resignation, int resignationWithdraw, int amberScore, int amberScoeAvg) {
        this.id = id;
        this.weekEnd = weekEnd;
        this.projectId = projectId;
        this.resignation = resignation;
        this.resignationWithdraw = resignationWithdraw;
        this.amberScore = amberScore;
        this.amberScoeAvg = amberScoeAvg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWeekEnd() {
        return weekEnd;
    }

    public void setWeekEnd(String weekEnd) {
        this.weekEnd = weekEnd;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public int getResignation() {
        return resignation;
    }

    public void setResignation(int resignation) {
        this.resignation = resignation;
    }

    public int getResignationWithdraw() {
        return resignationWithdraw;
    }

    public void setResignationWithdraw(int resignationWithdraw) {
        this.resignationWithdraw = resignationWithdraw;
    }

    public int getAmberScore() {
        return amberScore;
    }

    public void setAmberScore(int amberScore) {
        this.amberScore = amberScore;
    }

    public int getAmberScoeAvg() {
        return amberScoeAvg;
    }

    public void setAmberScoeAvg(int amberScoeAvg) {
        this.amberScoeAvg = amberScoeAvg;
    }

    @Override
    public String toString() {
        return "Kpi{" +
                "id='" + id + '\'' +
                ", weekEnd='" + weekEnd + '\'' +
                ", projectId=" + projectId +
                ", resignation=" + resignation +
                ", resignationWithdraw=" + resignationWithdraw +
                ", amberScore=" + amberScore +
                ", amberScoeAvg=" + amberScoeAvg +
                '}';
    }
}

