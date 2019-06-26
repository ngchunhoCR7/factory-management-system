package factory.management.system.project.controller;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Car;
import factory.management.system.project.entity.Line;
import factory.management.system.project.entity.Schedule;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.service.CarService;
import factory.management.system.project.service.LineService;
import factory.management.system.project.service.ScheduleService;
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
    private ScheduleService scheduleService;

    @Autowired
    private LineService lineService;
    
    @Autowired
    private CarService carService;

    @GetMapping(value = "/index")
    public String getschedules(PageSizeInfo pageSizeInfo, Model model) {
        // 获取分页查询列表
        PageInfo<Schedule> pageInfo = scheduleService.getSchedules(pageSizeInfo);
        model.addAttribute("pageList", pageInfo);
        // 把信息添加到model中
        addModel(model);
        return "index";
    }

    @GetMapping("/select")
    public String selectschedule(Integer scheduleId, Model model) {
        // 判断是否为空
        if (StringUtils.isEmpty(scheduleId)) {
            return "redirect:/server/schedule/index";
        } else {
            Schedule schedule = scheduleService.getSchedule(scheduleId);
            // 添加到链表
            List<Schedule> list = new ArrayList<Schedule>() {
                {
                    add(schedule);
                }
            };
            // 设置分页信息
            PageInfo<Schedule> schedules = new PageInfo<>();
            schedules.setList(list);
            schedules.setNavigatepageNums(new int[]{1});
            model.addAttribute("pageList", schedules);
            // 把信息添加到model中
            addModel(model);
            return "index";
        }
    }

    /**
     * 把信息添加到model中
     */
    private void addModel(Model model) {
        // 获取线路列表
        List<Line> lines = lineService.lineList();
        model.addAttribute("lineList", lines);
        // 获取线车辆列表
        List<Car> cars = carService.carList();
        model.addAttribute("carList", cars);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/schedule");
    }

    @GetMapping("/export")
    public void toExport(HttpServletResponse response) {
        scheduleService.exportExcel(response);
    }

    @PostMapping(value = "/insert")
    public String insertSchedule(Schedule schedule) {
        // 修改保存时间的字符串
//        schedule.setDepartureTime(schedule.getDepartureTime().replace('T', ' '));
        scheduleService.insertSchedule(schedule);
        return "redirect:/server/schedule/index";
    }

    @PostMapping(value = "/update")
    public String updateSchedule(Schedule schedule) {
        scheduleService.updateSchedule(schedule);
        return "redirect:/server/schedule/index";
    }

    @GetMapping(value = "/delete")
    public String deleteSchedule(Integer scheduleId) {
        scheduleService.deleteSchedule(scheduleId);
        return "redirect:/server/schedule/index";
    }
}
