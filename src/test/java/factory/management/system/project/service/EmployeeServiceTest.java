package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.mapper.EmployeeMapper;
import factory.management.system.project.pojo.EmployeeInfo;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.MyUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * EmployeeServiceTest
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/20 21:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void getEmployeeInfo() {
        // 初始化分页
        MyUtils.PageUtils.initPaging(new PageSizeInfo(2, 10));
        // 获取分页后的数据
        List<EmployeeInfo> list = employeeMapper.selectInfo();
        // 获取分页信息
        PageInfo<EmployeeInfo> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo.getNextPage());
        for(EmployeeInfo ei : pageInfo.getList()) {
            System.out.println(ei.getEmployeeName() + " " + ei.getDepartment().getDepartmentName()
            + " " + ei.getGroup().getGroupName());
        }
    }
}