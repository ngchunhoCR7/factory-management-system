package factory.management.system.project.entity;

import javax.persistence.*;

@Table(name = "t_schedule_record")
public class ScheduleRecord {
    @Id
    @Column(name = "sr_id")
    private Integer srId;

    @Column(name = "schedule_id")
    private Integer scheduleId;

    /**
     * 乘坐人数
     */
    @Column(name = "passenger_number")
    private Integer passengerNumber;

    /**
     * 乘载比率
     */
    @Column(name = "ride_ratio")
    private Double rideRatio;

    /**
     * @return sr_id
     */
    public Integer getSrId() {
        return srId;
    }

    /**
     * @param srId
     */
    public void setSrId(Integer srId) {
        this.srId = srId;
    }

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
     * 获取乘坐人数
     *
     * @return passenger_number - 乘坐人数
     */
    public Integer getPassengerNumber() {
        return passengerNumber;
    }

    /**
     * 设置乘坐人数
     *
     * @param passengerNumber 乘坐人数
     */
    public void setPassengerNumber(Integer passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    /**
     * 获取乘载比率
     *
     * @return ride_ratio - 乘载比率
     */
    public Double getRideRatio() {
        return rideRatio;
    }

    /**
     * 设置乘载比率
     *
     * @param rideRatio 乘载比率
     */
    public void setRideRatio(Double rideRatio) {
        this.rideRatio = rideRatio;
    }
}