package factory.management.system.project.pojo;

import factory.management.system.project.entity.Line;
import factory.management.system.project.entity.Station;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * LineInfo
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/23 14:45
 */
@NoArgsConstructor
@Data
public class LineInfo extends Line {

    private Station departure;

    private Station destination;
}
