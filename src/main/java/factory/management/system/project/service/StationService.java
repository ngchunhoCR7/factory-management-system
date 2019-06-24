package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Station;
import factory.management.system.project.mapper.StationMapper;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.MyDruid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * StationController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/18 20:25
 */
@Service
public class StationService {
    
    @Autowired
    private StationMapper stationMapper;

    /**
     * 获取站点列表
     *
     * @return
     */
    public List<Station> stationList() {
        return stationMapper.selectAll();
    }

    /**
     * 获取站点列表
     *
     * @param pageSizeInfo
     * @return
     */
    public PageInfo<Station> getStations(PageSizeInfo pageSizeInfo) {
        // 分页查询
        return (PageInfo<Station>) MyDruid.of(stationMapper).retrieve(pageSizeInfo);
    }

    /**
     * 获取单个站点
     *
     * @param StationId
     * @return
     */
    public Station getStation(Integer StationId) {
        return (Station) MyDruid.of(stationMapper).retrieve(StationId);
    }

    /**
     * 新增站点
     *
     * @param Station
     */
    public void insertStation(Station Station) {
        MyDruid.of(stationMapper).insert(Station);
    }

    /**
     * 更新站点
     *
     * @param Station
     */
    public void updateStation(Station Station) {
        MyDruid.of(stationMapper).update(Station);
    }

    /**
     * 删除站点
     *
     * @param StationId
     */
    public void deleteStation(Integer StationId) {
        MyDruid.of(stationMapper).delete(StationId);
    }
}
