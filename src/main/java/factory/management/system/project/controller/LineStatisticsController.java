package factory.management.system.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * LineStatistics
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/25 21:50
 */
@Controller
@RequestMapping("/server/lineStatistics")
public class LineStatisticsController {

    @GetMapping("/index")
    public String getLineStatistics(Model model) {
        // 设置分页跳转链接
        model.addAttribute("url", "/server/lineStatistics");
        return "index";
    }
}
