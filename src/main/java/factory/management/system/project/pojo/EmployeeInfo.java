package factory.management.system.project.pojo;

import factory.management.system.project.entity.Department;
import factory.management.system.project.entity.Employee;
import factory.management.system.project.entity.Group;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * EmployeeInfo
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/20 16:51
 */
@NoArgsConstructor
@Data
public class EmployeeInfo extends Employee {

    private Department department;

    private Group group;
}
