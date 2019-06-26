package factory.management.system.project.controller;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Employee;
import factory.management.system.project.entity.EmployeeRecord;
import factory.management.system.project.entity.Station;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.service.EmployeeRecordService;
import factory.management.system.project.service.EmployeeService;
import factory.management.system.project.service.StationService;
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
 * EmployeeRecordController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/24 21:30
 */
@Controller
@RequestMapping("/server/employeeRecord")
public class EmployeeRecordController {

    @Autowired
    private EmployeeRecordService employeeRecordService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private StationService stationService;

    @GetMapping(value = "/index")
    public String getemployeeRecords(PageSizeInfo pageSizeInfo, Model model) {
        // 获取分页查询列表
        PageInfo<EmployeeRecord> pageInfo = employeeRecordService.getEmployeeRecords(pageSizeInfo);
        model.addAttribute("pageList", pageInfo);
        // 把信息添加到model中
        addModel(model);
        return "index";
    }

    @GetMapping("/select")
    public String selectemployeeRecord(Integer erId, Model model) {
        // 判断是否为空
        if (StringUtils.isEmpty(erId)) {
            return "redirect:/server/employeeRecord/index";
        } else {
            EmployeeRecord employeeRecord = employeeRecordService.getEmployeeRecord(erId);
            // 添加到链表
            List<EmployeeRecord> list = new ArrayList<EmployeeRecord>() {
                {
                    add(employeeRecord);
                }
            };
            // 设置分页信息
            PageInfo<EmployeeRecord> employeeRecords = new PageInfo<>();
            employeeRecords.setList(list);
            employeeRecords.setNavigatepageNums(new int[]{1});
            model.addAttribute("pageList", employeeRecords);
            // 把信息添加到model中
            addModel(model);
            return "index";
        }
    }

    /**
     * 把信息添加到model中
     */
    private void addModel(Model model) {
        // 获取员工列表
        List<Employee> employees = employeeService.employeeList();
        model.addAttribute("employeeList", employees);
        // 获取站点列表
        List<Station> stations = stationService.stationList();
        model.addAttribute("stationList", stations);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/employeeRecord");
    }

    @GetMapping("/export")
    public void toExport(HttpServletResponse response) {
        employeeRecordService.exportExcel(response);
    }

    @PostMapping(value = "/insert")
    public String insertEmployeeRecord(EmployeeRecord employeeRecord) {
        employeeRecordService.insertEmployeeRecord(employeeRecord);
        return "redirect:/server/employeeRecord/index";
    }

    @PostMapping(value = "/update")
    public String updateEmployeeRecord(EmployeeRecord employeeRecord) {
        employeeRecordService.updateEmployeeRecord(employeeRecord);
        return "redirect:/server/employeeRecord/index";
    }

    @GetMapping(value = "/delete")
    public String deleteEmployeeRecord(Integer employeeRecordId) {
        employeeRecordService.deleteEmployeeRecord(employeeRecordId);
        return "redirect:/server/employeeRecord/index";
    }
}
