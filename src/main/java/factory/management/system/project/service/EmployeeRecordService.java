package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.EmployeeRecord;
import factory.management.system.project.mapper.EmployeeRecordMapper;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.MyDruid;
import factory.management.system.project.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    private EmployeeRecordMapper employeeRecordMapper;

    /**
     * 导出成Excel表格
     *
     * @param response
     */
    public void exportExcel(HttpServletResponse response) {
        MyUtils.exportExcel(response, "员工记录表", employeeRecordList());
    }

    /**
     * 获取员工记录列表
     *
     * @return
     */
    public List<EmployeeRecord> employeeRecordList() {
        return employeeRecordMapper.selectAll();
    }

    /**
     * 获取员工记录列表
     *
     * @param pageSizeInfo
     * @return
     */
    public PageInfo<EmployeeRecord> getEmployeeRecords(PageSizeInfo pageSizeInfo) {
        // 分页查询
        return (PageInfo<EmployeeRecord>) MyDruid.of(employeeRecordMapper).retrieve(pageSizeInfo);
    }

    /**
     * 获取单个员工记录
     *
     * @param erId
     * @return
     */
    public EmployeeRecord getEmployeeRecord(Integer erId) {
        return (EmployeeRecord) MyDruid.of(employeeRecordMapper).retrieve(erId);
    }

    /**
     * 新增员工记录
     *
     * @param employeeRecord
     */
    public void insertEmployeeRecord(EmployeeRecord employeeRecord) {
        MyDruid.of(employeeRecordMapper).insert(employeeRecord);
    }

    /**
     * 更新员工记录
     *
     * @param employeeRecord
     */
    public void updateEmployeeRecord(EmployeeRecord employeeRecord) {
        MyDruid.of(employeeRecordMapper).update(employeeRecord);
    }

    /**
     * 删除员工记录
     *
     * @param erId
     */
    public void deleteEmployeeRecord(Integer erId) {
        MyDruid.of(employeeRecordMapper).delete(erId);
    }
}
