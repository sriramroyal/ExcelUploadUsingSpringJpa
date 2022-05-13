package com.example.engagementKpi.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ResourceFulfillmentKpi {
    private String id;
    private String weekEnding;
    @Id
    private long projectId;
    private int positionAgingDays;
    private int averageAging4Weeks;
    private float netAdds;
    private float netAdds4WeeekAvg;

    public ResourceFulfillmentKpi() {
    }

    public ResourceFulfillmentKpi(String id, String weekEnding, long projectId, int positionAgingDays, int averageAging4Weeks, float netAdds, float netAdds4WeeekAvg) {
        this.id = id;
        this.weekEnding = weekEnding;
        this.projectId = projectId;
        this.positionAgingDays = positionAgingDays;
        this.averageAging4Weeks = averageAging4Weeks;
        this.netAdds = netAdds;
        this.netAdds4WeeekAvg = netAdds4WeeekAvg;
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

    public int getPositionAgingDays() {
        return positionAgingDays;
    }

    public void setPositionAgingDays(int positionAgingDays) {
        this.positionAgingDays = positionAgingDays;
    }

    public int getAverageAging4Weeks() {
        return averageAging4Weeks;
    }

    public void setAverageAging4Weeks(int averageAging4Weeks) {
        this.averageAging4Weeks = averageAging4Weeks;
    }

    public float getNetAdds() {
        return netAdds;
    }

    public void setNetAdds(float netAdds) {
        this.netAdds = netAdds;
    }

    public float getNetAdds4WeeekAvg() {
        return netAdds4WeeekAvg;
    }

    public void setNetAdds4WeeekAvg(float netAdds4WeeekAvg) {
        this.netAdds4WeeekAvg = netAdds4WeeekAvg;
    }
}
