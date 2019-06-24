package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.LineStation;
import factory.management.system.project.mapper.LineStationMapper;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.MyDruid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private LineStationMapper LineStationMapper;

    /**
     * 获取站线列表
     *
     * @param pageSizeInfo
     * @return
     */
    public PageInfo<LineStation> getLineStations(PageSizeInfo pageSizeInfo) {
        // 分页查询
        return (PageInfo<LineStation>) MyDruid.of(LineStationMapper).retrieve(pageSizeInfo);
    }

    /**
     * 获取单个站线
     *
     * @param LineStationId
     * @return
     */
    public LineStation getLineStation(Integer LineStationId) {
        return (LineStation) MyDruid.of(LineStationMapper).retrieve(LineStationId);
    }

    /**
     * 新增站线
     *
     * @param LineStation
     */
    public void insertLineStation(LineStation LineStation) {
        MyDruid.of(LineStationMapper).insert(LineStation);
    }

    /**
     * 更新站线
     *
     * @param LineStation
     */
    public void updateLineStation(LineStation LineStation) {
        MyDruid.of(LineStationMapper).update(LineStation);
    }

    /**
     * 删除站线
     *
     * @param LineStationId
     */
    public void deleteLineStation(Integer LineStationId) {
        MyDruid.of(LineStationMapper).delete(LineStationId);
    }
}
