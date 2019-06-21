package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.ScheduleRecord;
import factory.management.system.project.mapper.ScheduleRecordMapper;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.MyDruid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private ScheduleRecordMapper ScheduleRecordMapper;

    /**
     * 获取排班记录列表
     *
     * @param pageSizeInfo
     * @return
     */
    public PageInfo<ScheduleRecord> getScheduleRecords(PageSizeInfo pageSizeInfo) {
        // 分页查询
        return (PageInfo<ScheduleRecord>) MyDruid.of(ScheduleRecordMapper).retrieve(pageSizeInfo);
    }

    /**
     * 获取单个排班记录
     *
     * @param ScheduleRecordId
     * @return
     */
    public ScheduleRecord getScheduleRecord(Integer ScheduleRecordId) {
        return (ScheduleRecord) MyDruid.of(ScheduleRecordMapper).retrieve(ScheduleRecordId);
    }

    /**
     * 新增排班记录
     *
     * @param ScheduleRecord
     */
    public void insertScheduleRecord(ScheduleRecord ScheduleRecord) {
        MyDruid.of(ScheduleRecordMapper).insert(ScheduleRecord);
    }

    /**
     * 更新排班记录
     *
     * @param ScheduleRecord
     */
    public void updateScheduleRecord(ScheduleRecord ScheduleRecord) {
        MyDruid.of(ScheduleRecordMapper).update(ScheduleRecord);
    }

    /**
     * 删除排班记录
     *
     * @param ScheduleRecordId
     */
    public void deleteScheduleRecord(Integer ScheduleRecordId) {
        MyDruid.of(ScheduleRecordMapper).delete(ScheduleRecordId);
    }
}
