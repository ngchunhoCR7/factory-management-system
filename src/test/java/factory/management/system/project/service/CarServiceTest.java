package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.mapper.CarMapper;
import factory.management.system.project.pojo.CarInfo;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.MyUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * CarServiceTest
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/20 20:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTest {

    @Autowired
    private CarMapper carMapper;

    @Test
    public void getCdInfo() {
        // 初始化分页
        MyUtils.PageUtils.initPaging(new PageSizeInfo());
        // 获取分页后的数据
        List<CarInfo> list = carMapper.selectInfo();
        // 获取分页信息
        PageInfo<CarInfo> pageInfo = new PageInfo<>(list);
        // 设置末页停留防止跳转至首页
        if (pageInfo.getNextPage() == 0) {
            pageInfo.setNextPage(pageInfo.getNavigateLastPage());
        }
        for(CarInfo cdi : pageInfo.getList()) {
            System.out.println(cdi.getCarName() + " " + cdi.getCarNumber() + " " + cdi.getDriverId() + " "
            + cdi.getDriver().getDriverName() + " " + cdi.getDriver().getDriverLicense());
        }
    }
}