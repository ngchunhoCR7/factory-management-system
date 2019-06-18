package factory.management.system.project.controller;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Department;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * DepartmentController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/18 20:31
 */
@Controller
@RequestMapping("/server/department")
public class DepartmentController {

    @Autowired
    private DepartmentService DepartmentService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String getDepartments(PageSizeInfo pageSizeInfo, Model model) {
        // 获取分页查询列表
        PageInfo<Department> pageInfo = DepartmentService.getDepartments(pageSizeInfo);
        model.addAttribute("pageList", pageInfo);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/department/select");
        return "page/department";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertDepartment(Department Department) {
        DepartmentService.insertDepartment(Department);
        return "redirect:/server/department/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateDepartment(Department Department) {
        DepartmentService.updateDepartment(Department);
        return "redirect:/server/department/index";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteDepartment(Integer DepartmentId) {
        DepartmentService.deleteDepartment(DepartmentId);
        return "redirect:/server/department/index";
    }
}
