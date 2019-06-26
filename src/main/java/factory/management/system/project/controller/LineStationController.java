package factory.management.system.project.controller;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Line;
import factory.management.system.project.entity.LineStation;
import factory.management.system.project.entity.Station;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.service.LineService;
import factory.management.system.project.service.LineStationService;
import factory.management.system.project.service.StationService;
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
 * LineStationController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/24 16:18
 */
@Controller
@RequestMapping("/server/lineStation")
public class LineStationController {

    @Autowired
    private LineStationService lineStationService;
    
    @Autowired
    private LineService lineService;
    
    @Autowired
    private StationService stationService;

    @GetMapping("/index")
    public String getLineStations(PageSizeInfo pageSizeInfo, Model model) {
        // 获取分页查询列表
        PageInfo<LineStation> pageInfo = lineStationService.getLineStations(pageSizeInfo);
        model.addAttribute("pageList", pageInfo);
        // 把信息添加到model中
        addModel(model);
        return "index";
    }

    @GetMapping("/select")
    public String selectLineStation(Integer lineStationId, Model model) {
        // 判断是否为空
        if (StringUtils.isEmpty(lineStationId)) {
            return "redirect:/server/lineStation/index";
        } else {
            LineStation lineStation = lineStationService.getLineStation(lineStationId);
            // 添加到链表
            List<LineStation> list = new ArrayList<LineStation>() {
                {
                    add(lineStation);
                }
            };
            // 设置分页信息
            PageInfo<LineStation> lineStations = new PageInfo<>();
            lineStations.setList(list);
            lineStations.setNavigatepageNums(new int[]{1});
            model.addAttribute("pageList", lineStations);
            // 把信息添加到model中
            addModel(model);
            return "index";
        }
    }

    /**
     * 把信息添加到model中
     */
    private void addModel(Model model) {
        // 获取线路列表
        List<Line> lines = lineService.lineList();
        model.addAttribute("lineList", lines);
        // 获取线路站点列表
        List<Station> stations = stationService.stationList();
        model.addAttribute("stationList", stations);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/lineStation");
    }

    @GetMapping("/export")
    public void toExport(HttpServletResponse response) {
        lineStationService.exportExcel(response);
    }

    @PostMapping("/insert")
    public String insertLineStation(LineStation lineStation) {
        lineStationService.insertLineStation(lineStation);
        return "redirect:/server/lineStation/index";
    }

    @PostMapping("/update")
    public String updatelineStation(LineStation lineStation) {
        lineStationService.updateLineStation(lineStation);
        return "redirect:/server/lineStation/index";
    }

    @GetMapping("/delete")
    public String deletelineStation(Integer lineStationId) {
        lineStationService.deleteLineStation(lineStationId);
        return "redirect:/server/lineStation/index";
    }
}
