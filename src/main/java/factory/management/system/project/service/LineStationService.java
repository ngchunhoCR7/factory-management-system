package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.LineStation;
import factory.management.system.project.mapper.LineStationMapper;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.MyDruid;
import factory.management.system.project.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * LineStationController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/18 20:25
 */
@Service
public class LineStationService {
    
    @Autowired
    private LineStationMapper lineStationMapper;

    /**
     * 导出成Excel表格
     *
     * @param response
     */
    public void exportExcel(HttpServletResponse response) {
        MyUtils.exportExcel(response, "站线信息表", lineStationList());
    }

    /**
     * 获取站线列表
     *
     * @return
     */
    public List<LineStation> lineStationList() {
        return lineStationMapper.selectAll();
    }

    /**
     * 获取站线列表
     *
     * @param pageSizeInfo
     * @return
     */
    public PageInfo<LineStation> getLineStations(PageSizeInfo pageSizeInfo) {
        // 分页查询
        return (PageInfo<LineStation>) MyDruid.of(lineStationMapper).retrieve(pageSizeInfo);
    }

    /**
     * 获取单个站线
     *
     * @param lsId
     * @return
     */
    public LineStation getLineStation(Integer lsId) {
        return (LineStation) MyDruid.of(lineStationMapper).retrieve(lsId);
    }

    /**
     * 新增站线
     *
     * @param lineStation
     */
    public void insertLineStation(LineStation lineStation) {
        MyDruid.of(lineStationMapper).insert(lineStation);
    }

    /**
     * 更新站线
     *
     * @param lineStation
     */
    public void updateLineStation(LineStation lineStation) {
        MyDruid.of(lineStationMapper).update(lineStation);
    }

    /**
     * 删除站线
     *
     * @param lsId
     */
    public void deleteLineStation(Integer lsId) {
        MyDruid.of(lineStationMapper).delete(lsId);
    }
}
