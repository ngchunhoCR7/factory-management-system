package factory.management.system.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/index")
    public String getStationStatistics(Model model) {
        // 设置分页跳转链接
        model.addAttribute("url", "/server/stationStatistics");
        return "index";
    }
}
