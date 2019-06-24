package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Line;
import factory.management.system.project.entity.LineStation;
import factory.management.system.project.mapper.LineMapper;
import factory.management.system.project.mapper.LineStationMapper;
import factory.management.system.project.pojo.LineInfo;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.MyDruid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * LineController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/18 20:25
 */
@Service
public class LineService {
    
    @Autowired
    private LineMapper lineMapper;

    @Autowired
    private LineStationMapper lineStationMapper;

    /**
     * 获取线路信息列表
     *
     * @return
     */
    public List<Line> lineList() {
        return lineMapper.selectAll();
    }

    /**
     * 获取线路信息列表
     *
     * @param pageSizeInfo
     * @return
     */
    public PageInfo<LineInfo> getLsInfo(PageSizeInfo pageSizeInfo) {
        // 分页查询
        return (PageInfo<LineInfo>) MyDruid.of(lineMapper).retrieveInfo(pageSizeInfo);
    }

    /**
     * 获取单个线路信息
     *
     * @return
     */
    public LineInfo getInfoById(Integer lineId) {
        return lineMapper.selectInfoById(lineId);
    }

    /**
     * 获取线路列表
     *
     * @param pageSizeInfo
     * @return
     */
    public PageInfo<Line> getLines(PageSizeInfo pageSizeInfo) {
        // 分页查询
        return (PageInfo<Line>) MyDruid.of(lineMapper).retrieve(pageSizeInfo);
    }

    /**
     * 获取单个线路
     *
     * @param lineId
     * @return
     */
    public Line getLine(Integer lineId) {
        return (Line) MyDruid.of(lineMapper).retrieve(lineId);
    }

    /**
     * 新增线路
     *
     * @param line
     */
    public void insertLine(Line line) {
        // 设置始发站
        LineStation departure = new LineStation();
        departure.setLineId(line.getLineId());
        departure.setStationId(line.getDepartureId());
        departure.setSequence(1);
        // 设置始发站
        LineStation destination = new LineStation();
        destination.setLineId(line.getLineId());
        destination.setStationId(line.getDestinationId());
        destination.setSequence(0);
        // 插入到站线表中
        MyDruid.of(lineStationMapper).insert(departure);
        MyDruid.of(lineStationMapper).insert(destination);
        // 新增线路
        MyDruid.of(lineMapper).insert(line);
    }

    /**
     * 更新线路
     *
     * @param line
     */
    public void updateLine(Line line) {
        MyDruid.of(lineMapper).update(line);
    }

    /**
     * 删除线路
     *
     * @param lineId
     */
    public void deleteLine(Integer lineId) {
        MyDruid.of(lineMapper).delete(lineId);
    }
}
