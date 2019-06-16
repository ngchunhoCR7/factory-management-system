package factory.management.system.project.entity;

import javax.persistence.*;

@Table(name = "t_station")
public class Station {
    @Id
    @Column(name = "station_id")
    private Integer stationId;

    @Column(name = "station_name")
    private String stationName;

    @Column(name = "station_location")
    private String stationLocation;

    /**
     * @return station_id
     */
    public Integer getStationId() {
        return stationId;
    }

    /**
     * @param stationId
     */
    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    /**
     * @return station_name
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * @param stationName
     */
    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    /**
     * @return station_location
     */
    public String getStationLocation() {
        return stationLocation;
    }

    /**
     * @param stationLocation
     */
    public void setStationLocation(String stationLocation) {
        this.stationLocation = stationLocation == null ? null : stationLocation.trim();
    }
}