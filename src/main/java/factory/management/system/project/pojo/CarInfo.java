package factory.management.system.project.pojo;

import factory.management.system.project.entity.Car;
import factory.management.system.project.entity.Driver;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CarInfo
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/20 16:51
 */
@NoArgsConstructor
@Data
public class CarInfo extends Car {

    private Driver driver;

}
