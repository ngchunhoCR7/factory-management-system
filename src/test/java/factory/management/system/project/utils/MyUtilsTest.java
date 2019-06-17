package factory.management.system.project.utils;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Employee;
import factory.management.system.project.mapper.EmployeeMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * MyUtilsTest
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/17 16:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyUtilsTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void retrieve() {
        /*// 获取分页后的数据
        List<Entity> list = myCrud.getMapper().selectAll();
        // 获取分页信息
        PageInfo<Entity> pageInfo = new PageInfo<>(list);*/
        PageInfo<?> pageInfo = MyCrud.of(employeeMapper).retrieve();
        for (Object e : pageInfo.getList()) {
            Employee employee = (Employee) e;
            System.out.println(employee.getEmployeeId() + " " + employee.getEmployeeName());
        }
    }

    @Ignore
    @Test
    public void create() {
        Employee employee = new Employee();
        employee.setEmployeeId(1600502102);
        employee.setEmployeeName("吉普车");
        employee.setDepartmentId(1);
        employee.setGroupId(1);
        MyCrud.of(employeeMapper).create(employee);
    }

    @Test
    public void update() {
        Employee employee = new Employee();
        employee.setEmployeeId(1600502102);
        employee.setEmployeeName("吉普森");
        MyCrud.of(employeeMapper).update(employee);
    }
}