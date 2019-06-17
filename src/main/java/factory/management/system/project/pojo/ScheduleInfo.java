package factory.management.system.project.pojo;

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
public class ScheduleInfo {

    private Integer scheduleId;

    private String scheduleDate;

    private Integer lineId;

    private String departureName;

    private Integer carId;

    private String driverName;

    private String departureTime;

}
