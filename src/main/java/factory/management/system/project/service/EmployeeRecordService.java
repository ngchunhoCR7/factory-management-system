package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.EmployeeRecord;
import factory.management.system.project.mapper.EmployeeRecordMapper;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.MyDruid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * EmployeeRecordController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/18 20:25
 */
@Service
public class EmployeeRecordService {
    
    @Autowired
    private EmployeeRecordMapper EmployeeRecordMapper;

    /**
     * 获取员工记录列表
     *
     * @param pageSizeInfo
     * @return
     */
    public PageInfo<EmployeeRecord> getEmployeeRecords(PageSizeInfo pageSizeInfo) {
        // 分页查询
        return (PageInfo<EmployeeRecord>) MyDruid.of(EmployeeRecordMapper).retrieve(new PageSizeInfo());
    }

    /**
     * 获取单个员工记录
     *
     * @param EmployeeRecordId
     * @return
     */
    public EmployeeRecord getEmployeeRecord(Integer EmployeeRecordId) {
        return (EmployeeRecord) MyDruid.of(EmployeeRecordMapper).retrieve(EmployeeRecordId);
    }

    /**
     * 新增员工记录
     *
     * @param EmployeeRecord
     */
    public void insertEmployeeRecord(EmployeeRecord EmployeeRecord) {
        MyDruid.of(EmployeeRecordMapper).insert(EmployeeRecord);
    }

    /**
     * 更新员工记录
     *
     * @param EmployeeRecord
     */
    public void updateEmployeeRecord(EmployeeRecord EmployeeRecord) {
        MyDruid.of(EmployeeRecordMapper).update(EmployeeRecord);
    }

    /**
     * 删除员工记录
     *
     * @param EmployeeRecordId
     */
    public void deleteEmployeeRecord(Integer EmployeeRecordId) {
        MyDruid.of(EmployeeRecordMapper).delete(EmployeeRecordId);
    }
}
