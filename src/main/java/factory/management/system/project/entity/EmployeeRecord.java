package factory.management.system.project.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_employee_record")
public class EmployeeRecord {
    @Id
    @Column(name = "er_id")
    private Integer erId;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "schedule_id")
    private Integer scheduleId;

    @Column(name = "station_id")
    private Integer stationId;

    /**
     * 上车时间
     */
    @Column(name = "boarding_time")
    private String boardingTime;

    /**
     * 乘车状态
     */
    private String status;

    /**
     * @return er_id
     */
    public Integer getErId() {
        return erId;
    }

    /**
     * @param erId
     */
    public void setErId(Integer erId) {
        this.erId = erId;
    }

    /**
     * @return employee_id
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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
     * 获取上车时间
     *
     * @return boarding_time - 上车时间
     */
    public String getBoardingTime() {
        return boardingTime;
    }

    /**
     * 设置上车时间
     *
     * @param boardingTime 上车时间
     */
    public void setBoardingTime(String boardingTime) {
        this.boardingTime = boardingTime;
    }

    /**
     * 获取乘车状态
     *
     * @return status - 乘车状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置乘车状态
     *
     * @param status 乘车状态
     */
    public void setStatus(String status) {
        this.status = status;
    }
}