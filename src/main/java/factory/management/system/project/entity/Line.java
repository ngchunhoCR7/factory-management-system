package factory.management.system.project.entity;

import javax.persistence.*;

@Table(name = "t_line")
public class Line {
    @Id
    @Column(name = "line_id")
    private Integer lineId;

    @Column(name = "line_name")
    private String lineName;

    /**
     * 始发站编号
     */
    @Column(name = "departure_id")
    private Integer departureId;

    /**
     * 终点站编号
     */
    @Column(name = "destination_id")
    private Integer destinationId;

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
     * @return line_name
     */
    public String getLineName() {
        return lineName;
    }

    /**
     * @param lineName
     */
    public void setLineName(String lineName) {
        this.lineName = lineName == null ? null : lineName.trim();
    }

    /**
     * 获取始发站编号
     *
     * @return departure_id - 始发站编号
     */
    public Integer getDepartureId() {
        return departureId;
    }

    /**
     * 设置始发站编号
     *
     * @param departureId 始发站编号
     */
    public void setDepartureId(Integer departureId) {
        this.departureId = departureId;
    }

    /**
     * 获取终点站编号
     *
     * @return destination_id - 终点站编号
     */
    public Integer getDestinationId() {
        return destinationId;
    }

    /**
     * 设置终点站编号
     *
     * @param destinationId 终点站编号
     */
    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }
}