package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Schedule;
import factory.management.system.project.mapper.ScheduleMapper;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.MyDruid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private ScheduleMapper ScheduleMapper;

    /**
     * 获取排班列表
     *
     * @param pageSizeInfo
     * @return
     */
    public PageInfo<Schedule> getSchedules(PageSizeInfo pageSizeInfo) {
        // 分页查询
        return (PageInfo<Schedule>) MyDruid.of(ScheduleMapper).retrieve(pageSizeInfo);
    }

    /**
     * 获取单个排班
     *
     * @param ScheduleId
     * @return
     */
    public Schedule getSchedule(Integer ScheduleId) {
        return (Schedule) MyDruid.of(ScheduleMapper).retrieve(ScheduleId);
    }

    /**
     * 新增排班
     *
     * @param Schedule
     */
    public void insertSchedule(Schedule Schedule) {
        MyDruid.of(ScheduleMapper).insert(Schedule);
    }

    /**
     * 更新排班
     *
     * @param Schedule
     */
    public void updateSchedule(Schedule Schedule) {
        MyDruid.of(ScheduleMapper).update(Schedule);
    }

    /**
     * 删除排班
     *
     * @param ScheduleId
     */
    public void deleteSchedule(Integer ScheduleId) {
        MyDruid.of(ScheduleMapper).delete(ScheduleId);
    }
}
