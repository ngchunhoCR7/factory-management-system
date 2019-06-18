package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Employee;
import factory.management.system.project.mapper.EmployeeMapper;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.MyDruid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EmployeeService
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/17 15:38
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 获取员工列表
     *
     * @param pageSizeInfo
     * @return
     */
    public PageInfo<Employee> getEmployees(PageSizeInfo pageSizeInfo) {
        // 分页查询
        return (PageInfo<Employee>) MyDruid.of(employeeMapper).retrieve(new PageSizeInfo());
    }

    /**
     * 获取单个员工
     *
     * @param employeeId
     * @return
     */
    public Employee getEmployee(Integer employeeId) {
        return (Employee) MyDruid.of(employeeMapper).retrieve(employeeId);
    }

    /**
     * 新增员工
     *
     * @param employee
     */
    public void insertEmployee(Employee employee) {
       MyDruid.of(employeeMapper).insert(employee);
    }

    /**
     * 更新员工
     *
     * @param employee
     */
    public void updateEmployee(Employee employee) {
        MyDruid.of(employeeMapper).update(employee);
    }

    /**
     * 删除员工
     *
     * @param employeeId
     */
    public void deleteEmployee(Integer employeeId) {
        MyDruid.of(employeeMapper).delete(employeeId);
    }
}
