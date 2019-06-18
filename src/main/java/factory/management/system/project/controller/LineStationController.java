package factory.management.system.project.controller;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.LineStation;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.service.LineStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * LineStationController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/18 20:31
 */
@Controller
@RequestMapping("/server/lineStation")
public class LineStationController {

    @Autowired
    private LineStationService LineStationService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String getLineStations(PageSizeInfo pageSizeInfo, Model model) {
        // 获取分页查询列表
        PageInfo<LineStation> pageInfo = LineStationService.getLineStations(pageSizeInfo);
        model.addAttribute("pageList", pageInfo);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/lineStation/select");
        return "page/lineStation";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertLineStation(LineStation LineStation) {
        LineStationService.insertLineStation(LineStation);
        return "redirect:/server/lineStation/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateLineStation(LineStation LineStation) {
        LineStationService.updateLineStation(LineStation);
        return "redirect:/server/lineStation/index";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteLineStation(Integer LineStationId) {
        LineStationService.deleteLineStation(LineStationId);
        return "redirect:/server/lineStation/index";
    }
}
