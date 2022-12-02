package chapter7;

import java.util.Objects;

public class TradeHub {

    private String hubDistrictCode;
    private String hubDistrictCodeName;
    private String hubCode;
    private String hubCodeName;
    private String hubType;
    private int totalCount;
    private int x;
    private int y;

    public TradeHub(String hubDistrictCode, String hubDistrictCodeName, String hubCode, String hubCodeName, String hubType, int totalCount) {
        this.hubDistrictCode = hubDistrictCode;
        this.hubDistrictCodeName = hubDistrictCodeName;
        this.hubCode = hubCode;
        this.hubCodeName = hubCodeName;
        this.hubType = hubType;
        this.totalCount = totalCount;
        this.x = 0;
        this.y = 0;
    }

    public String getHubDistrictCode() {
        return hubDistrictCode;
    }

    public void setHubDistrictCode(String hubDistrictCode) {
        this.hubDistrictCode = hubDistrictCode;
    }

    public String getHubDistrictCodeName() {
        return hubDistrictCodeName;
    }

    public void setHubDistrictCodeName(String hubDistrictCodeName) {
        this.hubDistrictCodeName = hubDistrictCodeName;
    }

    public String getHubCode() {
        return hubCode;
    }

    public void setHubCode(String hubCode) {
        this.hubCode = hubCode;
    }

    public String getHubCodeName() {
        return hubCodeName;
    }

    public void setHubCodeName(String hubCodeName) {
        this.hubCodeName = hubCodeName;
    }

    public String getHubType() {
        return hubType;
    }

    public void setHubType(String hubType) {
        this.hubType = hubType;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "TradeHub{" +
                "hubDistrictCode='" + hubDistrictCode + '\'' +
                ", hubDistrictCodeName='" + hubDistrictCodeName + '\'' +
                ", hubCode='" + hubCode + '\'' +
                ", hubCodeName='" + hubCodeName + '\'' +
                ", hubType='" + hubType + '\'' +
                ", totalCount=" + totalCount +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        TradeHub tradeHub = (TradeHub) o;
        return this.hubCode.equals(tradeHub.hubCode) && this.hubCodeName.equals(tradeHub.hubCodeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hubCode,hubCodeName);
    }
}
