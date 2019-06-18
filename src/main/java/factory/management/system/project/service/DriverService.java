package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Driver;
import factory.management.system.project.mapper.DriverMapper;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.MyDruid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DriverController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/18 20:25
 */
@Service
public class DriverService {
    
    @Autowired
    private DriverMapper DriverMapper;

    /**
     * 获取司机列表
     *
     * @param pageSizeInfo
     * @return
     */
    public PageInfo<Driver> getDrivers(PageSizeInfo pageSizeInfo) {
        // 分页查询
        return (PageInfo<Driver>) MyDruid.of(DriverMapper).retrieve(new PageSizeInfo());
    }

    /**
     * 获取单个司机
     *
     * @param DriverId
     * @return
     */
    public Driver getDriver(Integer DriverId) {
        return (Driver) MyDruid.of(DriverMapper).retrieve(DriverId);
    }

    /**
     * 新增司机
     *
     * @param Driver
     */
    public void insertDriver(Driver Driver) {
        MyDruid.of(DriverMapper).insert(Driver);
    }

    /**
     * 更新司机
     *
     * @param Driver
     */
    public void updateDriver(Driver Driver) {
        MyDruid.of(DriverMapper).update(Driver);
    }

    /**
     * 删除司机
     *
     * @param DriverId
     */
    public void deleteDriver(Integer DriverId) {
        MyDruid.of(DriverMapper).delete(DriverId);
    }
}