package factory.management.system.project.controller;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Department;
import factory.management.system.project.entity.Employee;
import factory.management.system.project.entity.Group;
import factory.management.system.project.pojo.EmployeeInfo;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.service.DepartmentService;
import factory.management.system.project.service.EmployeeService;
import factory.management.system.project.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private GroupService groupService;

    @GetMapping("/index")
    public String getEmployees(PageSizeInfo pageSizeInfo, Model model) {
        // 获取分页查询列表
        PageInfo<EmployeeInfo> pageInfo = employeeService.getInfo(pageSizeInfo);
        model.addAttribute("pageList", pageInfo);
        // 把信息添加到model中
        addModel(model);
        return "index";
    }

    @GetMapping("/select")
    public String selectEmployee(Integer employeeId, Model model) {
        // 判断是否为空
        if (StringUtils.isEmpty(employeeId)) {
            return "redirect:/server/employee/index";
        } else {
            EmployeeInfo employeeInfo = employeeService.getInfoById(employeeId);
            // 添加到链表
            List<EmployeeInfo> list = new ArrayList<EmployeeInfo>() {
                {
                    add(employeeInfo);
                }
            };
            // 设置分页信息
            PageInfo<EmployeeInfo> employees = new PageInfo<>();
            employees.setList(list);
            employees.setNavigatepageNums(new int[]{1});
            model.addAttribute("pageList", employees);
            // 把信息添加到model中
            addModel(model);
            return "index";
        }
    }

    /**
     * 把信息添加到model中
     */
    private void addModel(Model model) {
        // 获取部门列表
        List<Department> departments = departmentService.departmentList();
        model.addAttribute("departmentList", departments);
        // 获取组别列表
        List<Group> groups = groupService.groupList();
        model.addAttribute("groupList", groups);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/employee");
    }

    @GetMapping("/export")
    public void toExport(HttpServletResponse response) {
        employeeService.exportExcel(response);
    }

    @PostMapping("/insert")
    public String insertEmployee(Employee employee) {
        employeeService.insertEmployee(employee);
        return "redirect:/server/employee/index";
    }

    @PostMapping("/update")
    public String updateEmployee(Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/server/employee/index";
    }

    @GetMapping("/delete")
    public String deleteEmployee(Integer employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/server/employee/index";
    }

}
