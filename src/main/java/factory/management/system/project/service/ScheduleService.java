package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Schedule;
import factory.management.system.project.mapper.ScheduleMapper;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.MyDruid;
import factory.management.system.project.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ScheduleController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/18 20:25
 */
@Service
public class ScheduleService {
    
    @Autowired
    private ScheduleMapper scheduleMapper;

    /**
     * 导出成Excel表格
     *
     * @param response
     */
    public void exportExcel(HttpServletResponse response) {
        MyUtils.exportExcel(response, "排班信息表", scheduleList());
    }

    public List<Schedule> scheduleList() {
        return scheduleMapper.selectAll();
    }

    /**
     * 获取排班列表
     *
     * @param pageSizeInfo
     * @return
     */
    public PageInfo<Schedule> getSchedules(PageSizeInfo pageSizeInfo) {
        // 分页查询
        return (PageInfo<Schedule>) MyDruid.of(scheduleMapper).retrieve(pageSizeInfo);
    }

    /**
     * 获取单个排班
     *
     * @param ScheduleId
     * @return
     */
    public Schedule getSchedule(Integer ScheduleId) {
        return (Schedule) MyDruid.of(scheduleMapper).retrieve(ScheduleId);
    }

    /**
     * 新增排班
     *
     * @param Schedule
     */
    public void insertSchedule(Schedule Schedule) {
        MyDruid.of(scheduleMapper).insert(Schedule);
    }

    /**
     * 更新排班
     *
     * @param Schedule
     */
    public void updateSchedule(Schedule Schedule) {
        MyDruid.of(scheduleMapper).update(Schedule);
    }

    /**
     * 删除排班
     *
     * @param ScheduleId
     */
    public void deleteSchedule(Integer ScheduleId) {
        MyDruid.of(scheduleMapper).delete(ScheduleId);
    }
}
