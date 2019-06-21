package factory.management.system.project.controller;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.ScheduleRecord;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.service.ScheduleRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ScheduleRecordController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/18 20:31
 */
@Controller
@RequestMapping("/server/scheduleRecord")
public class ScheduleRecordController {

    @Autowired
    private ScheduleRecordService ScheduleRecordService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String getScheduleRecords(PageSizeInfo pageSizeInfo, Model model) {
        // 获取分页查询列表
        PageInfo<ScheduleRecord> pageInfo = ScheduleRecordService.getScheduleRecords(pageSizeInfo);
        model.addAttribute("pageList", pageInfo);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/scheduleRecord/select");
        return "server/scheduleRecord";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertScheduleRecord(ScheduleRecord ScheduleRecord) {
        ScheduleRecordService.insertScheduleRecord(ScheduleRecord);
        return "redirect:/server/scheduleRecord/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateScheduleRecord(ScheduleRecord ScheduleRecord) {
        ScheduleRecordService.updateScheduleRecord(ScheduleRecord);
        return "redirect:/server/scheduleRecord/index";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteScheduleRecord(Integer ScheduleRecordId) {
        ScheduleRecordService.deleteScheduleRecord(ScheduleRecordId);
        return "redirect:/server/scheduleRecord/index";
    }
}
