package factory.management.system.project.controller;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.ScheduleRecord;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.service.ScheduleRecordService;
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
    private ScheduleRecordService scheduleRecordService;

    @GetMapping("/index")
    public String getScheduleRecords(PageSizeInfo pageSizeInfo, Model model) {
        // 获取分页查询列表
        PageInfo<ScheduleRecord> pageInfo = scheduleRecordService.getScheduleRecords(pageSizeInfo);
        model.addAttribute("pageList", pageInfo);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/scheduleRecord");
        return "index";
    }

    @GetMapping("/select")
    public String selectScheduleRecord(Integer scheduleRecordId, Model model) {
        // 判断是否为空
        if (StringUtils.isEmpty(scheduleRecordId)) {
            return "redirect:/server/scheduleRecord/index";
        } else {
            ScheduleRecord scheduleRecord = scheduleRecordService.getScheduleRecord(scheduleRecordId);
            // 添加到链表
            List<ScheduleRecord> list = new ArrayList<ScheduleRecord>() {
                {
                    add(scheduleRecord);
                }
            };
            // 设置分页信息
            PageInfo<ScheduleRecord> scheduleRecords = new PageInfo<>();
            scheduleRecords.setList(list);
            scheduleRecords.setNavigatepageNums(new int[]{1});
            model.addAttribute("pageList", scheduleRecords);
            // 设置分页跳转链接
            model.addAttribute("url", "/server/scheduleRecord");
            return "index";
        }
    }

    @GetMapping("/export")
    public void toExport(HttpServletResponse response) {
        scheduleRecordService.exportExcel(response);
    }

    @PostMapping("/insert")
    public String insertScheduleRecord(ScheduleRecord scheduleRecord) {
        scheduleRecordService.insertScheduleRecord(scheduleRecord);
        return "redirect:/server/scheduleRecord/index";
    }

    @PostMapping("/update")
    public String updateScheduleRecord(ScheduleRecord scheduleRecord) {
        scheduleRecordService.updateScheduleRecord(scheduleRecord);
        return "redirect:/server/scheduleRecord/index";
    }

    @GetMapping("/delete")
    public String deleteScheduleRecord(Integer scheduleRecordId) {
        scheduleRecordService.deleteScheduleRecord(scheduleRecordId);
        return "redirect:/server/scheduleRecord/index";
    }
}
