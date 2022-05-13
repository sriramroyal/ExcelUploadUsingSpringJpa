package com.example.engagementKpi.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InnovationKpi {
    private String id;
    private String WeekEnding;
    @Id
    private long ProjectId;
    private int Improvements;
    private int Refactoring;

    public InnovationKpi() {
    }

    public InnovationKpi(String id, String weekEnding, long projectId, int improvements, int refactoring) {
        this.id = id;
        WeekEnding = weekEnding;
        ProjectId = projectId;
        Improvements = improvements;
        Refactoring = refactoring;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWeekEnding() {
        return WeekEnding;
    }

    public void setWeekEnding(String weekEnding) {
        WeekEnding = weekEnding;
    }

    public long getProjectId() {
        return ProjectId;
    }

    public void setProjectId(long projectId) {
        ProjectId = projectId;
    }

    public int getImprovements() {
        return Improvements;
    }

    public void setImprovements(int improvements) {
        Improvements = improvements;
    }

    public int getRefactoring() {
        return Refactoring;
    }

    public void setRefactoring(int refactoring) {
        Refactoring = refactoring;
    }
}
