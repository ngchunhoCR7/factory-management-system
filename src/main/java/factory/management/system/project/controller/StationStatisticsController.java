package factory.management.system.project.controller;

import factory.management.system.project.entity.Station;
import factory.management.system.project.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * StationStatisticsController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/26 10:36
 */
@Controller
@RequestMapping("/server/stationStatistics")
public class StationStatisticsController {

    @Autowired
    private StationService stationService;

    @GetMapping("/index")
    public String getStationStatistics(Model model) {
        // 把信息添加到model中
        addModel(model);
        return "index";
    }

    @PostMapping("/query")
    public String query(Integer stationId, Model model) {
        // 获取站点信息
        Station station = stationService.getStation(stationId);
        model.addAttribute("station", station);
        // 把信息添加到model中
        addModel(model);
        return "index";
    }

    /**
     * 把信息添加到model中
     */
    private void addModel(Model model) {
        // 获取站点列表
        List<Station> stations = stationService.stationList();
        model.addAttribute("stationList", stations);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/stationStatistics");
    }
}
