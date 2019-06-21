package factory.management.system.project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.thymeleaf.util.DateUtils;

import java.util.Date;
import java.util.Locale;
import javax.persistence.*;

@Table(name = "t_car")
public class Car {
    @Id
    @Column(name = "car_id")
    private Integer carId;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "car_brand")
    private String carBrand;

    @Column(name = "car_size")
    private Integer carSize;

    @Column(name = "car_register_date")
    private String carRegisterDate;

    @Column(name = "car_insurance_date")
    private String carInsuranceDate;

    @Column(name = "car_registration")
    private String carRegistration;

    @Column(name = "driver_id")
    private Integer driverId;

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
     * @return car_name
     */
    public String getCarName() {
        return carName;
    }

    /**
     * @param carName
     */
    public void setCarName(String carName) {
        this.carName = carName == null ? null : carName.trim();
    }

    /**
     * @return car_number
     */
    public String getCarNumber() {
        return carNumber;
    }

    /**
     * @param carNumber
     */
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber == null ? null : carNumber.trim();
    }

    /**
     * @return car_brand
     */
    public String getCarBrand() {
        return carBrand;
    }

    /**
     * @param carBrand
     */
    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand == null ? null : carBrand.trim();
    }

    /**
     * @return car_size
     */
    public Integer getCarSize() {
        return carSize;
    }

    /**
     * @param carSize
     */
    public void setCarSize(Integer carSize) {
        this.carSize = carSize;
    }

    /**
     * @return car_register_date
     */
    public String getCarRegisterDate() {
        return carRegisterDate;
    }

    /**
     * @param carRegisterDate
     */
    public void setCarRegisterDate(String carRegisterDate) {
        this.carRegisterDate = carRegisterDate;
    }

    /**
     * @return car_insurance_date
     */
    public String getCarInsuranceDate() {
        return carInsuranceDate;
    }

    /**
     * @param carInsuranceDate
     */
    public void setCarInsuranceDate(String carInsuranceDate) {
        this.carInsuranceDate = carInsuranceDate;
    }

    /**
     * @return car_registration
     */
    public String getCarRegistration() {
        return carRegistration;
    }

    /**
     * @param carRegistration
     */
    public void setCarRegistration(String carRegistration) {
        this.carRegistration = carRegistration == null ? null : carRegistration.trim();
    }

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
}