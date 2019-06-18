package factory.management.system.project.controller;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Employee;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ServerController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/17 15:37
 */
@Controller
@RequestMapping("/server/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String getEmployees(PageSizeInfo pageSizeInfo, Model model) {
        // 获取分页查询列表
        PageInfo<Employee> pageInfo = employeeService.getEmployees(pageSizeInfo);
        model.addAttribute("pageList", pageInfo);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/employee/select");
        return "page/employee";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertEmployee(Employee employee) {
        employeeService.insertEmployee(employee);
        return "redirect:/server/employee/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateEmployee(Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/server/employee/index";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteEmployee(Integer employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/server/employee/index";
    }

}
