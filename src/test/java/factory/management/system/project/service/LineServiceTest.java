package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.mapper.LineMapper;
import factory.management.system.project.pojo.LineInfo;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.MyDruid;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * LineServiceTest
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/23 19:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LineServiceTest {

    @Autowired
    private LineMapper lineMapper;

    @Test
    public void getLsInfo() {
        // 分页查询
        PageInfo<LineInfo> pageInfo = (PageInfo<LineInfo>) MyDruid.of(lineMapper).retrieveInfo(new PageSizeInfo());
        List<LineInfo> list = pageInfo.getList();
        for (LineInfo lineInfo : list) {
            System.out.println(lineInfo.getDeparture().getStationId() + " " +
                    lineInfo.getDeparture().getStationName() + " " +
                    lineInfo.getDeparture().getStationLocation());
            System.out.println(lineInfo.getDestination().getStationId() + " " +
                    lineInfo.getDestination().getStationName() + " " +
                    lineInfo.getDestination().getStationLocation());
        }
    }
}