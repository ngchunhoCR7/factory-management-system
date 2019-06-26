package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.ScheduleRecord;
import factory.management.system.project.mapper.ScheduleRecordMapper;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.MyDruid;
import factory.management.system.project.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ScheduleRecordController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/18 20:25
 */
@Service
public class ScheduleRecordService {
    
    @Autowired
    private ScheduleRecordMapper scheduleRecordMapper;

    /**
     * 导出成Excel表格
     *
     * @param response
     */
    public void exportExcel(HttpServletResponse response) {
        MyUtils.exportExcel(response, "排班记录表", scheduleRecordList());
    }

    /**
     * 获取排班记录列表
     *
     * @return
     */
    public List<ScheduleRecord> scheduleRecordList() {
        return scheduleRecordMapper.selectAll();
    }

    /**
     * 获取排班记录列表
     *
     * @param pageSizeInfo
     * @return
     */
    public PageInfo<ScheduleRecord> getScheduleRecords(PageSizeInfo pageSizeInfo) {
        // 分页查询
        return (PageInfo<ScheduleRecord>) MyDruid.of(scheduleRecordMapper).retrieve(pageSizeInfo);
    }

    /**
     * 获取单个排班记录
     *
     * @param srId
     * @return
     */
    public ScheduleRecord getScheduleRecord(Integer srId) {
        return (ScheduleRecord) MyDruid.of(scheduleRecordMapper).retrieve(srId);
    }

    /**
     * 新增排班记录
     *
     * @param scheduleRecord
     */
    public void insertScheduleRecord(ScheduleRecord scheduleRecord) {
        MyDruid.of(scheduleRecordMapper).insert(scheduleRecord);
    }

    /**
     * 更新排班记录
     *
     * @param scheduleRecord
     */
    public void updateScheduleRecord(ScheduleRecord scheduleRecord) {
        MyDruid.of(scheduleRecordMapper).update(scheduleRecord);
    }

    /**
     * 删除排班记录
     *
     * @param srId
     */
    public void deleteScheduleRecord(Integer srId) {
        MyDruid.of(scheduleRecordMapper).delete(srId);
    }
}
