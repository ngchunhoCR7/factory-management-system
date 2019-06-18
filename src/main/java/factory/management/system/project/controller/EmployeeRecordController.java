package factory.management.system.project.controller;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.EmployeeRecord;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.service.EmployeeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * EmployeeRecordController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/18 20:31
 */
@Controller
@RequestMapping("/server/employeeRecord")
public class EmployeeRecordController {

    @Autowired
    private EmployeeRecordService EmployeeRecordService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String getEmployeeRecords(PageSizeInfo pageSizeInfo, Model model) {
        // 获取分页查询列表
        PageInfo<EmployeeRecord> pageInfo = EmployeeRecordService.getEmployeeRecords(pageSizeInfo);
        model.addAttribute("pageList", pageInfo);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/employeeRecord/select");
        return "page/employeeRecord";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertEmployeeRecord(EmployeeRecord EmployeeRecord) {
        EmployeeRecordService.insertEmployeeRecord(EmployeeRecord);
        return "redirect:/server/employeeRecord/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateEmployeeRecord(EmployeeRecord EmployeeRecord) {
        EmployeeRecordService.updateEmployeeRecord(EmployeeRecord);
        return "redirect:/server/employeeRecord/index";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteEmployeeRecord(Integer EmployeeRecordId) {
        EmployeeRecordService.deleteEmployeeRecord(EmployeeRecordId);
        return "redirect:/server/employeeRecord/index";
    }
}
