package factory.management.system.project.controller;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Line;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * LineController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/18 20:31
 */
@Controller
@RequestMapping("/server/line")
public class LineController {

    @Autowired
    private LineService LineService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String getLines(PageSizeInfo pageSizeInfo, Model model) {
        // 获取分页查询列表
        PageInfo<Line> pageInfo = LineService.getLines(pageSizeInfo);
        model.addAttribute("pageList", pageInfo);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/line/select");
        return "server/line";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertLine(Line Line) {
        LineService.insertLine(Line);
        return "redirect:/server/line/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateLine(Line Line) {
        LineService.updateLine(Line);
        return "redirect:/server/line/index";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteLine(Integer LineId) {
        LineService.deleteLine(LineId);
        return "redirect:/server/line/index";
    }
}
