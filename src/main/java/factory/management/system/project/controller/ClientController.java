package factory.management.system.project.controller;

import factory.management.system.project.entity.Employee;
import factory.management.system.project.entity.EmployeeRecord;
import factory.management.system.project.service.ClientService;
import factory.management.system.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * ClientController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/16 21:56
 */
@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private EmployeeService employeeService;

    /**
     * 车辆客户机页面
     *
     * @return
     */
    @RequestMapping("/car")
    public String carIndex(Model model) {
        // 获取排班列表
//        PageInfo<ScheduleInfo> schedules = clientService.getSchedules(request);
//        model.addAttribute("pageList", schedules);
        // 设置分页跳转链接
        model.addAttribute("url", "/client/car");
        return "client/car";
    }

    /**
     * 员工上车打卡
     *
     * @param employeeRecord
     * @return
     */
    @RequestMapping(value = "/aboard", method = RequestMethod.POST)
    public String aboard(EmployeeRecord employeeRecord) {
        // 新增员工上车记录
        clientService.insertEmpRecord(employeeRecord);
        return "redirect:/client/car";
    }

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public Employee test(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        System.out.println(request);
        String id = request.getParameter("employeeId");
        System.out.println(id);
        Employee employee = employeeService.getEmployee(Integer.valueOf(id));
        return employee;
    }
}
