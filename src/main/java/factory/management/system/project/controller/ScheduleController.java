package factory.management.system.project.controller;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Schedule;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ScheduleController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/18 20:31
 */
@Controller
@RequestMapping("/server/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService ScheduleService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String getSchedules(PageSizeInfo pageSizeInfo, Model model) {
        // 获取分页查询列表
        PageInfo<Schedule> pageInfo = ScheduleService.getSchedules(pageSizeInfo);
        model.addAttribute("pageList", pageInfo);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/schedule/select");
        return "page/schedule";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertSchedule(Schedule Schedule) {
        ScheduleService.insertSchedule(Schedule);
        return "redirect:/server/schedule/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateSchedule(Schedule Schedule) {
        ScheduleService.updateSchedule(Schedule);
        return "redirect:/server/schedule/index";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteSchedule(Integer ScheduleId) {
        ScheduleService.deleteSchedule(ScheduleId);
        return "redirect:/server/schedule/index";
    }
}
