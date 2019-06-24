package factory.management.system.project.controller;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Line;
import factory.management.system.project.entity.Station;
import factory.management.system.project.pojo.LineInfo;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.service.LineService;
import factory.management.system.project.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * LineController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/23 15:11
 */
@Controller
@RequestMapping("/server/line")
public class LineController {

    @Autowired
    private LineService lineService;

    @Autowired
    private StationService stationService;

    @GetMapping(value = "/index")
    public String getLines(PageSizeInfo pageSizeInfo, Model model) {
        // 获取分页查询列表
        PageInfo<LineInfo> pageInfo = lineService.getLsInfo(pageSizeInfo);
        model.addAttribute("pageList", pageInfo);
        // 把信息添加到model中
        addModel(model);
        return "index";
    }

    @GetMapping("/select")
    public String selectLine(Integer lineId, Model model) {
        // 判断是否为空
        if (StringUtils.isEmpty(lineId)) {
            return "redirect:/server/line/index";
        } else {
            LineInfo LineInfo = lineService.getInfoById(lineId);

            List<LineInfo> list = new ArrayList<LineInfo>() {
                {
                    add(LineInfo);
                }
            };
            // 设置分页信息
            PageInfo<LineInfo> Lines = new PageInfo<>();
            Lines.setList(list);
            Lines.setNavigatepageNums(new int[]{1});
            model.addAttribute("pageList", Lines);
            // 把信息添加到model中
            addModel(model);
            return "index";
        }
    }

    /**
     * 把信息添加到model中
     */
    private void addModel(Model model) {
        // 获取站点列表
        List<Station> stations = stationService.stationList();
        model.addAttribute("stationList", stations);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/line");
    }

    @PostMapping(value = "/insert")
    public String insertLine(Line line) {
        lineService.insertLine(line);
        return "redirect:/server/line/index";
    }

    @PostMapping(value = "/update")
    public String updateLine(Line line) {
        lineService.updateLine(line);
        return "redirect:/server/line/index";
    }

    @GetMapping(value = "/delete")
    public String deleteLine(Integer lineId) {
        lineService.deleteLine(lineId);
        return "redirect:/server/line/index";
    }
}
