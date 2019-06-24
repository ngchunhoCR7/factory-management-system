package factory.management.system.project.mapper;

import factory.management.system.project.entity.Line;
import factory.management.system.project.pojo.LineInfo;
import factory.management.system.project.utils.MyMapper;

import java.util.List;

public interface LineMapper extends MyMapper<Line> {

    @Override
    public List<LineInfo> selectInfo();

    @Override
    public LineInfo selectInfoById(Object lineId);
}