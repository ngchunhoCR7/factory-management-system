package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Admin;
import factory.management.system.project.mapper.AdminMapper;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.MyDruid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AdminService
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/18 21:19
 */
@Service
public class AdminService {
    
    @Autowired
    private AdminMapper adminMapper;

    /**
     * 获取管理员列表
     *
     * @param pageSizeInfo
     * @return
     */
    public PageInfo<Admin> getAdmins(PageSizeInfo pageSizeInfo) {
        // 分页查询
        return (PageInfo<Admin>) MyDruid.of(adminMapper).retrieve(new PageSizeInfo());
    }

    /**
     * 获取单个管理员
     *
     * @param AdminId
     * @return
     */
    public Admin getAdmin(Integer AdminId) {
        return (Admin) MyDruid.of(adminMapper).retrieve(AdminId);
    }

    /**
     * 新增管理员
     *
     * @param Admin
     */
    public void insertAdmin(Admin Admin) {
        MyDruid.of(adminMapper).insert(Admin);
    }

    /**
     * 更新管理员
     *
     * @param Admin
     */
    public void updateAdmin(Admin Admin) {
        MyDruid.of(adminMapper).update(Admin);
    }

    /**
     * 删除管理员
     *
     * @param AdminId
     */
    public void deleteAdmin(Integer AdminId) {
        MyDruid.of(adminMapper).delete(AdminId);
    }
}
