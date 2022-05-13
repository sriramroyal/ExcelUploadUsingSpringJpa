package com.example.engagementKpi.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GovernanceKpi {
    private String id;
    private String weekEnding;
    @Id
    private long projectId;
    private int teamMeeting;
    private float teamMeetingAvg;
    private int stakeHolderMeeting;
    private float stakeHolderMeetingAvg;
    private int execConnect;
    private float execConnectAvg;

    public GovernanceKpi() {
    }

    public GovernanceKpi(String id, String weekEnding, long projectId, int teamMeeting, float teamMeetingAvg, int stakeHolderMeeting, float stakeHolderMeetingAvg, int execConnect, float execConnectAvg) {
        this.id = id;
        this.weekEnding = weekEnding;
        this.projectId = projectId;
        this.teamMeeting = teamMeeting;
        this.teamMeetingAvg = teamMeetingAvg;
        this.stakeHolderMeeting = stakeHolderMeeting;
        this.stakeHolderMeetingAvg = stakeHolderMeetingAvg;
        this.execConnect = execConnect;
        this.execConnectAvg = execConnectAvg;
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

    public int getTeamMeeting() {
        return teamMeeting;
    }

    public void setTeamMeeting(int teamMeeting) {
        this.teamMeeting = teamMeeting;
    }

    public float getTeamMeetingAvg() {
        return teamMeetingAvg;
    }

    public void setTeamMeetingAvg(float teamMeetingAvg) {
        this.teamMeetingAvg = teamMeetingAvg;
    }

    public int getStakeHolderMeeting() {
        return stakeHolderMeeting;
    }

    public void setStakeHolderMeeting(int stakeHolderMeeting) {
        this.stakeHolderMeeting = stakeHolderMeeting;
    }

    public float getStakeHolderMeetingAvg() {
        return stakeHolderMeetingAvg;
    }

    public void setStakeHolderMeetingAvg(float stakeHolderMeetingAvg) {
        this.stakeHolderMeetingAvg = stakeHolderMeetingAvg;
    }

    public int getExecConnect() {
        return execConnect;
    }

    public void setExecConnect(int execConnect) {
        this.execConnect = execConnect;
    }

    public float getExecConnectAvg() {
        return execConnectAvg;
    }

    public void setExecConnectAvg(float execConnectAvg) {
        this.execConnectAvg = execConnectAvg;
    }
}
