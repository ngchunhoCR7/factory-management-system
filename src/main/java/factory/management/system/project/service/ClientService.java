package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Employee;
import factory.management.system.project.entity.EmployeeRecord;
import factory.management.system.project.mapper.EmployeeRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static factory.management.system.project.utils.MyUtils.getDateTime;

/**
 * ClientService
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/16 22:00
 */
@Service
public class ClientService {

    @Autowired
    EmployeeRecordMapper employeeRecordMapper;

    /*public PageInfo<ScheduleInfo> getSchedules(HttpServletRequest request) {

    }*/

    /**
     * 新增员工乘车记录
     *
     * @param employeeRecord
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertEmpRecord(EmployeeRecord employeeRecord) {
        try {
            // 设置上车时间
            employeeRecord.setBoardingTime(getDateTime());
            employeeRecordMapper.insertSelective(employeeRecord);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
