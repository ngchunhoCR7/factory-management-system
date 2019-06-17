package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Employee;
import factory.management.system.project.mapper.EmployeeMapper;
import factory.management.system.project.utils.MyCrud;
import factory.management.system.project.utils.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static factory.management.system.project.utils.MyUtils.initPaging;

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

    public PageInfo<Employee> getEmployees(HttpServletRequest request) {
        // 初始化分页
        initPaging(request);
        // 获取分页后的数据
        List<Employee> employees = employeeMapper.selectAll();
        // 获取分页信息
        PageInfo<Employee> pageInfo = new PageInfo<>(employees);
        // 设置末页停留防止跳转至首页
        if (pageInfo.getNextPage() == 0) {
            pageInfo.setNextPage(pageInfo.getNavigateLastPage());
        }
        return pageInfo;
    }

    public void insertEmployee(Employee employee) {
//        MyCrud myCrud = new MyCrud(employee.getClass(), employee);
//        myCrud.create();
    }
}
