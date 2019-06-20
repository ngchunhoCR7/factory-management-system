package factory.management.system.project.controller;

import factory.management.system.project.entity.EmployeeRecord;
import factory.management.system.project.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @PostMapping(value = "/aboard")
    public String aboard(EmployeeRecord employeeRecord) {
        // 新增员工上车记录
        clientService.insertEmpRecord(employeeRecord);
        return "redirect:/client/car";
    }
}
