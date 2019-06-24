package factory.management.system.project.entity;

import javax.persistence.*;

@Table(name = "t_line_station")
public class LineStation {
    @Id
    @Column(name = "ls_id")
    private Integer lsId;

    @Column(name = "line_id")
    private Integer lineId;

    @Column(name = "station_id")
    private Integer stationId;

    /**
     * 站线顺序
     */
    private Integer sequence;

    /**
     * @return ls_id
     */
    public Integer getLsId() {
        return lsId;
    }

    /**
     * @param lsId
     */
    public void setLsId(Integer lsId) {
        this.lsId = lsId;
    }

    /**
     * @return line_id
     */
    public Integer getLineId() {
        return lineId;
    }

    /**
     * @param lineId
     */
    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

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
     * @return sequence
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     * @param sequence
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}