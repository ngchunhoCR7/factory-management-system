package factory.management.system.project.controller;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Station;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * StationController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/18 20:32
 */
@Controller
@RequestMapping("/server/station")
public class StationController {

    @Autowired
    private StationService StationService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String getStations(PageSizeInfo pageSizeInfo, Model model) {
        // 获取分页查询列表
        PageInfo<Station> pageInfo = StationService.getStations(pageSizeInfo);
        model.addAttribute("pageList", pageInfo);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/station/select");
        return "server/station";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertStation(Station Station) {
        StationService.insertStation(Station);
        return "redirect:/server/station/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateStation(Station Station) {
        StationService.updateStation(Station);
        return "redirect:/server/station/index";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteStation(Integer StationId) {
        StationService.deleteStation(StationId);
        return "redirect:/server/station/index";
    }
}
