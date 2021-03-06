package factory.management.system.project.utils;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Employee;
import factory.management.system.project.mapper.EmployeeMapper;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.exportUtils.FieldEntity;
import factory.management.system.project.utils.exportUtils.FieldsCollector;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

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
    @Ignore
    public void retrieve() {
        /*// 获取分页后的数据
        List<Entity> list = myCrud.getMapper().selectAll();
        // 获取分页信息
        PageInfo<Entity> pageInfo = new PageInfo<>(list);*/
        PageInfo<?> pageInfo = MyDruid.of(employeeMapper).retrieve(new PageSizeInfo());
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
        MyDruid.of(employeeMapper).insert(employee);
    }

    @Test
    @Ignore
    public void update() {
        Employee employee = new Employee();
        employee.setEmployeeId(1600502102);
        employee.setEmployeeName("吉普森");
        MyDruid.of(employeeMapper).update(employee);
    }

    @Test
    public void fieldController() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Employee employee = new Employee();
        employee.setEmployeeId(1600502102);
        employee.setEmployeeName("吉普车");
        employee.setDepartmentId(1);
        employee.setGroupId(1);

        Map<String, FieldEntity> map = FieldsCollector.getFileds(employee);
        for (String string : map.keySet()) {
            System.out.println(string + " " + map.get(string).getFieldname() + map.get(string).getValue());
        }
    }
}