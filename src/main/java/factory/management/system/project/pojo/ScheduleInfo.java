package factory.management.system.project.pojo;

import factory.management.system.project.entity.Car;
import factory.management.system.project.entity.Line;
import factory.management.system.project.entity.Schedule;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ScheduleInfo
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/17 15:24
 */
@NoArgsConstructor
@Data
public class ScheduleInfo extends Schedule {

    private Line line;

    private Car car;

}
