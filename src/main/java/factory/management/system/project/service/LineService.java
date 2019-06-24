package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Line;
import factory.management.system.project.mapper.LineMapper;
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
    public LineInfo getInfoById(Integer LineId) {
        return lineMapper.selectInfoById(LineId);
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
     * @param LineId
     * @return
     */
    public Line getLine(Integer LineId) {
        return (Line) MyDruid.of(lineMapper).retrieve(LineId);
    }

    /**
     * 新增线路
     *
     * @param Line
     */
    public void insertLine(Line Line) {
        MyDruid.of(lineMapper).insert(Line);
    }

    /**
     * 更新线路
     *
     * @param Line
     */
    public void updateLine(Line Line) {
        MyDruid.of(lineMapper).update(Line);
    }

    /**
     * 删除线路
     *
     * @param LineId
     */
    public void deleteLine(Integer LineId) {
        MyDruid.of(lineMapper).delete(LineId);
    }
}
