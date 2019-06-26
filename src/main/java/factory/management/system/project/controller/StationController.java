package factory.management.system.project.controller;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Station;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * StationController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/22 14:30
 */
@Controller
@RequestMapping("/server/station")
public class StationController {

    @Autowired
    private StationService stationService;

    @GetMapping("/index")
    public String getstations(PageSizeInfo pageSizeInfo, Model model, Station station) {
        // 设置选中地址
        if (station == null) {
            model.addAttribute("station", new Station());
        } else {
            model.addAttribute("station", station);
        }
        // 获取分页查询列表
        PageInfo<Station> pageInfo = stationService.getStations(pageSizeInfo);
        model.addAttribute("pageList", pageInfo);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/station");
        return "index";
    }

    @GetMapping("/select")
    public String selectstation(Integer stationId, Model model) {
        // 判断是否为空
        if (StringUtils.isEmpty(stationId)) {
            return "redirect:/server/station/index";
        } else {
            Station station = stationService.getStation(stationId);
            // 添加到链表
            List<Station> list = new ArrayList<Station>() {
                {
                    add(station);
                }
            };
            // 设置分页信息
            PageInfo<Station> stations = new PageInfo<>();
            stations.setList(list);
            stations.setNavigatepageNums(new int[]{1});
            model.addAttribute("pageList", stations);
            // 设置分页跳转链接
            model.addAttribute("url", "/server/station");
            // 设置选中地址
            model.addAttribute("station", new Station());
            return "index";
        }
    }

    @GetMapping("/map")
    public String toMap(String stationName, Model model) {
        System.out.println(stationName);
        model.addAttribute("stationName", stationName);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/station");
        return "map";
    }

    @PostMapping("/location")
    public String getLocation(Station station, RedirectAttributesModelMap modelMap) {
        // 设置选中地址
        modelMap.addAttribute("stationName", station.getStationName());
        modelMap.addAttribute("stationLocation", station.getStationLocation());
        return "redirect:/server/station/index";
    }

    @GetMapping("/export")
    public void toExport(HttpServletResponse response) {
        stationService.exportExcel(response);
    }

    @PostMapping("/insert")
    public String insertStation(Station station) {
        stationService.insertStation(station);
        return "redirect:/server/station/index";
    }

    @PostMapping("/update")
    public String updateStation(Station station) {
        stationService.updateStation(station);
        return "redirect:/server/station/index";
    }

    @GetMapping("/delete")
    public String deleteStation(Integer stationId) {
        stationService.deleteStation(stationId);
        return "redirect:/server/station/index";
    }
}
