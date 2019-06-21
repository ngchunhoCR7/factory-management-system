package factory.management.system.project.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_schedule")
public class Schedule {
    @Id
    @Column(name = "schedule_id")
    private Integer scheduleId;

    @Column(name = "line_id")
    private Integer lineId;

    @Column(name = "car_id")
    private Integer carId;

    /**
     * 发车时间
     */
    @Column(name = "departure_time")
    private String departureTime;

    /**
     * @return schedule_id
     */
    public Integer getScheduleId() {
        return scheduleId;
    }

    /**
     * @param scheduleId
     */
    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
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
     * @return car_id
     */
    public Integer getCarId() {
        return carId;
    }

    /**
     * @param carId
     */
    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    /**
     * 获取发车时间
     *
     * @return departure_time - 发车时间
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * 设置发车时间
     *
     * @param departureTime 发车时间
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}