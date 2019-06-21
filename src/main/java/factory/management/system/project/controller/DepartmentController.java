package factory.management.system.project.controller;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Department;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * DepartmentController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/21 20:50
 */
@Controller
@RequestMapping("/server/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/index")
    public String getDepartments(PageSizeInfo pageSizeInfo, Model model) {
        // 获取分页查询列表
        PageInfo<Department> pageInfo = departmentService.getDepartments(pageSizeInfo);
        model.addAttribute("pageList", pageInfo);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/department");
        return "index";
    }

    @GetMapping("/select")
    public String selectDepartment(Integer departmentId, Model model) {
        // 判断是否为空
        if (StringUtils.isEmpty(departmentId)) {
            return "redirect:/server/department/index";
        } else {
            Department department = departmentService.getDepartment(departmentId);
            // 添加到链表
            List<Department> list = new ArrayList<Department>() {
                {
                    add(department);
                }
            };
            // 设置分页信息
            PageInfo<Department> departments = new PageInfo<>();
            departments.setList(list);
            departments.setNavigatepageNums(new int[]{1});
            model.addAttribute("pageList", departments);
            // 设置分页跳转链接
            model.addAttribute("url", "/server/department");
            return "index";
        }
    }

    @PostMapping("/insert")
    public String insertDepartment(Department department) {
        departmentService.insertDepartment(department);
        return "redirect:/server/department/index";
    }

    @PostMapping("/update")
    public String updateDepartment(Department department) {
        departmentService.updateDepartment(department);
        return "redirect:/server/department/index";
    }

    @GetMapping("/delete")
    public String deleteDepartment(Integer departmentId) {
        departmentService.deleteDepartment(departmentId);
        return "redirect:/server/department/index";
    }
}
