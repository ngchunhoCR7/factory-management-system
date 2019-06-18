package factory.management.system.project.controller;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Car;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * CarController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/18 20:31
 */
@Controller
@RequestMapping("/server/car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String getCars(PageSizeInfo pageSizeInfo, Model model) {
        // 获取分页查询列表
        PageInfo<Car> pageInfo = carService.getCars(pageSizeInfo);
        model.addAttribute("pageList", pageInfo);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/Car/select");
        return "page/Car";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertCar(Car Car) {
        carService.insertCar(Car);
        return "redirect:/server/Car/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateCar(Car Car) {
        carService.updateCar(Car);
        return "redirect:/server/Car/index";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteCar(Integer CarId) {
        carService.deleteCar(CarId);
        return "redirect:/server/Car/index";
    }
}
