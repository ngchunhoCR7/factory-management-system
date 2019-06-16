package factory.management.system.project.entity;

import javax.persistence.*;

@Table(name = "t_driver")
public class Driver {
    @Id
    @Column(name = "driver_id")
    private Integer driverId;

    @Column(name = "driver_name")
    private String driverName;

    @Column(name = "driver_license")
    private String driverLicense;

    /**
     * @return driver_id
     */
    public Integer getDriverId() {
        return driverId;
    }

    /**
     * @param driverId
     */
    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    /**
     * @return driver_name
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * @param driverName
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName == null ? null : driverName.trim();
    }

    /**
     * @return driver_license
     */
    public String getDriverLicense() {
        return driverLicense;
    }

    /**
     * @param driverLicense
     */
    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense == null ? null : driverLicense.trim();
    }
}