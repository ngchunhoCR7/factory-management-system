package factory.management.system.project.controller;

import factory.management.system.project.entity.Line;
import factory.management.system.project.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
    
    @Autowired
    private LineService lineService;

    @GetMapping("/index")
    public String getLineStatistics(Model model) {
        // 把信息添加到model中
        addModel(model);
        return "index";
    }

    @PostMapping("/query")
    public String query(Integer lineId, Model model) {
        // 获取线路信息
        Line line = lineService.getLine(lineId);
        model.addAttribute("line", line);
        // 把信息添加到model中
        addModel(model);
        return "index";
    }

    /**
     * 把信息添加到model中
     */
    private void addModel(Model model) {
        // 获取线路列表
        List<Line> lines = lineService.lineList();
        model.addAttribute("lineList", lines);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/lineStatistics");
    }
}
