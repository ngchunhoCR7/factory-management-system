package factory.management.system.project.controller;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Driver;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * DriverController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/21 21:10
 */
@Controller
@RequestMapping("/server/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping("/index")
    public String getDrivers(PageSizeInfo pageSizeInfo, Model model) {
        // 获取分页查询列表
        PageInfo<Driver> pageInfo = driverService.getDrivers(pageSizeInfo);
        model.addAttribute("pageList", pageInfo);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/driver");
        return "index";
    }

    @GetMapping("/select")
    public String selectDriver(Integer driverId, Model model) {
        // 判断是否为空
        if (StringUtils.isEmpty(driverId)) {
            return "redirect:/server/driver/index";
        } else {
            Driver driver = driverService.getDriver(driverId);
            // 添加到链表
            List<Driver> list = new ArrayList<Driver>() {
                {
                    add(driver);
                }
            };
            // 设置分页信息
            PageInfo<Driver> drivers = new PageInfo<>();
            drivers.setList(list);
            drivers.setNavigatepageNums(new int[]{1});
            model.addAttribute("pageList", drivers);
            // 设置分页跳转链接
            model.addAttribute("url", "/server/driver");
            return "index";
        }
    }

    @PostMapping("/insert")
    public String insertDriver(Driver driver) {
        driverService.insertDriver(driver);
        return "redirect:/server/driver/index";
    }

    @PostMapping("/update")
    public String updatedriver(Driver driver) {
        driverService.updateDriver(driver);
        return "redirect:/server/driver/index";
    }

    @GetMapping("/delete")
    public String deletedriver(Integer driverId) {
        driverService.deleteDriver(driverId);
        return "redirect:/server/driver/index";
    }
}
