package factory.management.system.project.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PageSizeInfo
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/17 19:10
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageSizeInfo {

    private Integer pageNum;

    private Integer pageSize;
}
