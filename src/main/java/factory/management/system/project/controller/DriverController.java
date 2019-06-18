package factory.management.system.project.controller;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Driver;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * DriverController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/18 20:31
 */
@Controller
@RequestMapping("/server/driver")
public class DriverController {

    @Autowired
    private DriverService DriverService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String getDrivers(PageSizeInfo pageSizeInfo, Model model) {
        // 获取分页查询列表
        PageInfo<Driver> pageInfo = DriverService.getDrivers(pageSizeInfo);
        model.addAttribute("pageList", pageInfo);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/driver/select");
        return "page/driver";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertDriver(Driver Driver) {
        DriverService.insertDriver(Driver);
        return "redirect:/server/driver/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateDriver(Driver Driver) {
        DriverService.updateDriver(Driver);
        return "redirect:/server/driver/index";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteDriver(Integer DriverId) {
        DriverService.deleteDriver(DriverId);
        return "redirect:/server/driver/index";
    }
}
