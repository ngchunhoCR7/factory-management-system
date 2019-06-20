package factory.management.system.project.service;

import factory.management.system.project.entity.Admin;
import factory.management.system.project.mapper.AdminMapper;
import factory.management.system.project.utils.PasswordEncrypt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

import static org.junit.Assert.*;

/**
 * AdminServiceTest
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/19 15:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {

    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void login() {
        Admin admin = new Admin();
        admin.setAdminName("system");
        admin.setAdminPassword("123456");

        // 新建example
        Example example = new Example(Admin.class);
        Example.Criteria criteria = example.createCriteria();
        // 设置查询条件
        criteria.andEqualTo("adminName", admin.getAdminName());
        criteria.andEqualTo("adminPassword", PasswordEncrypt.encodeByMd5(admin.getAdminPassword()));
        // 查找判断
        List<Admin> admins = adminMapper.selectByExample(example);

        for (Admin a : admins) {
            System.out.println(a.getAdminId() + " " + a.getAdminName());
        }
    }
}