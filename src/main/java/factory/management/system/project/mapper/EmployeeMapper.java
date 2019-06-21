package factory.management.system.project.mapper;

import factory.management.system.project.entity.Employee;
import factory.management.system.project.pojo.EmployeeInfo;
import factory.management.system.project.utils.MyMapper;

import java.util.List;

public interface EmployeeMapper extends MyMapper<Employee> {

    @Override
    public List<EmployeeInfo> selectInfo();

    @Override
    public EmployeeInfo selectInfoById(Object employeeId);
}