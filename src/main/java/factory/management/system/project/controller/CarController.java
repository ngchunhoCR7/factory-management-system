package factory.management.system.project.controller;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Car;
import factory.management.system.project.entity.Driver;
import factory.management.system.project.pojo.CarInfo;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.service.CarService;
import factory.management.system.project.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * CarController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/21 20:31
 */
@Controller
@RequestMapping("/server/car")
public class CarController {

    @Autowired
    private CarService carService;
    
    @Autowired
    private DriverService driverService;

    @GetMapping(value = "/index")
    public String getCars(PageSizeInfo pageSizeInfo, Model model) {
        // 获取分页查询列表
        PageInfo<CarInfo> pageInfo = carService.getCdInfo(pageSizeInfo);
        model.addAttribute("pageList", pageInfo);
        // 把信息添加到model中
        addModel(model);
        return "index";
    }

    @GetMapping("/select")
    public String selectCar(Integer carId, Model model) {
        // 判断是否为空
        if (StringUtils.isEmpty(carId)) {
            return "redirect:/server/car/index";
        } else {
            CarInfo carInfo = carService.getInfoById(carId);
            // 添加到链表
            List<CarInfo> list = new ArrayList<CarInfo>() {
                {
                    add(carInfo);
                }
            };
            // 设置分页信息
            PageInfo<CarInfo> cars = new PageInfo<>();
            cars.setList(list);
            cars.setNavigatepageNums(new int[]{1});
            model.addAttribute("pageList", cars);
            // 把信息添加到model中
            addModel(model);
            return "index";
        }
    }

    /**
     * 把信息添加到model中
     */
    private void addModel(Model model) {
        // 获取司机列表
        List<Driver> drivers = driverService.driverList();
        model.addAttribute("driverList", drivers);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/car");
    }

    @GetMapping("/export")
    public void toExport(HttpServletResponse response) {
        carService.exportExcel(response);
    }

    @PostMapping(value = "/insert")
    public String insertCar(Car car) {
        carService.insertCar(car);
        return "redirect:/server/car/index";
    }

    @PostMapping(value = "/update")
    public String updateCar(Car car) {
        carService.updateCar(car);
        return "redirect:/server/car/index";
    }

    @GetMapping(value = "/delete")
    public String deleteCar(Integer carId) {
        carService.deleteCar(carId);
        return "redirect:/server/car/index";
    }
}
