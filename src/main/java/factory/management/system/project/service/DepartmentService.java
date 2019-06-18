package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Department;
import factory.management.system.project.mapper.DepartmentMapper;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.MyDruid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DepartmentController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/18 20:25
 */
@Service
public class DepartmentService {
    
    @Autowired
    private DepartmentMapper DepartmentMapper;

    /**
     * 获取部门列表
     *
     * @param pageSizeInfo
     * @return
     */
    public PageInfo<Department> getDepartments(PageSizeInfo pageSizeInfo) {
        // 分页查询
        return (PageInfo<Department>) MyDruid.of(DepartmentMapper).retrieve(new PageSizeInfo());
    }

    /**
     * 获取单个部门
     *
     * @param departmentId
     * @return
     */
    public Department getDepartment(Integer departmentId) {
        return (Department) MyDruid.of(DepartmentMapper).retrieve(departmentId);
    }

    /**
     * 新增部门
     *
     * @param department
     */
    public void insertDepartment(Department department) {
        MyDruid.of(DepartmentMapper).insert(department);
    }

    /**
     * 更新部门
     *
     * @param department
     */
    public void updateDepartment(Department department) {
        MyDruid.of(DepartmentMapper).update(department);
    }

    /**
     * 删除部门
     *
     * @param departmentId
     */
    public void deleteDepartment(Integer departmentId) {
        MyDruid.of(DepartmentMapper).delete(departmentId);
    }
}
