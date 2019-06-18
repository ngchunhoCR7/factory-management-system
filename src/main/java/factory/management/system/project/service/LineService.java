package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Line;
import factory.management.system.project.mapper.LineMapper;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.MyDruid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private LineMapper LineMapper;

    /**
     * 获取线路列表
     *
     * @param pageSizeInfo
     * @return
     */
    public PageInfo<Line> getLines(PageSizeInfo pageSizeInfo) {
        // 分页查询
        return (PageInfo<Line>) MyDruid.of(LineMapper).retrieve(new PageSizeInfo());
    }

    /**
     * 获取单个线路
     *
     * @param LineId
     * @return
     */
    public Line getLine(Integer LineId) {
        return (Line) MyDruid.of(LineMapper).retrieve(LineId);
    }

    /**
     * 新增线路
     *
     * @param Line
     */
    public void insertLine(Line Line) {
        MyDruid.of(LineMapper).insert(Line);
    }

    /**
     * 更新线路
     *
     * @param Line
     */
    public void updateLine(Line Line) {
        MyDruid.of(LineMapper).update(Line);
    }

    /**
     * 删除线路
     *
     * @param LineId
     */
    public void deleteLine(Integer LineId) {
        MyDruid.of(LineMapper).delete(LineId);
    }
}
