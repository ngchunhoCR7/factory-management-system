package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Employee;
import factory.management.system.project.mapper.EmployeeMapper;
import factory.management.system.project.pojo.EmployeeInfo;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.MyDruid;
import factory.management.system.project.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
     * 导出成Excel表格
     *
     * @param response
     */
    public void exportExcel(HttpServletResponse response) {
        MyUtils.exportExcel(response, "员工信息表", employeeList());
    }

    /**
     * 获取员工列表
     *
     * @return
     */
    public List<Employee> employeeList() {
        return employeeMapper.selectAll();
    }

    /**
     * 获取员工信息列表
     *
     * @param pageSizeInfo
     * @return
     */
    public PageInfo<EmployeeInfo> getInfo(PageSizeInfo pageSizeInfo) {
        // 分页查询
        return (PageInfo<EmployeeInfo>) MyDruid.of(employeeMapper).retrieveInfo(pageSizeInfo);
    }

    /**
     * 获取单个员工信息
     *
     * @return
     */
    public EmployeeInfo getInfoById(Integer employeeId) {
        return employeeMapper.selectInfoById(employeeId);
    }

    /**
     * 获取员工列表
     *
     * @return
     */
    @Deprecated
    public PageInfo<Employee> getEmployees(PageSizeInfo pageSizeInfo) {
        // 分页查询
        return (PageInfo<Employee>) MyDruid.of(employeeMapper).retrieve(pageSizeInfo);
    }

    /**
     * 获取单个员工
     *
     * @param employeeId
     * @return
     */
    @Deprecated
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
