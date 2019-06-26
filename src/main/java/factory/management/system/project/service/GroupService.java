package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Group;
import factory.management.system.project.mapper.GroupMapper;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.MyDruid;
import factory.management.system.project.utils.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * GroupController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/18 20:25
 */
@Service
public class GroupService {
    
    @Autowired
    private GroupMapper groupMapper;

    /**
     * 导出成Excel表格
     *
     * @param response
     */
    public void exportExcel(HttpServletResponse response) {
        MyUtils.exportExcel(response, "组别信息表", groupList());
    }

    public List<Group> groupList() {
        return groupMapper.selectAll();
    }

    /**
     * 获取组别列表
     *
     * @return
     */
    public PageInfo<Group> getGroups(PageSizeInfo pageSizeInfo) {
        // 分页查询
        return (PageInfo<Group>) MyDruid.of(groupMapper).retrieve(pageSizeInfo);
    }

    /**
     * 获取单个组别
     *
     * @param GroupId
     * @return
     */
    public Group getGroup(Integer GroupId) {
        return (Group) MyDruid.of(groupMapper).retrieve(GroupId);
    }

    /**
     * 新增组别
     *
     * @param Group
     */
    public void insertGroup(Group Group) {
        MyDruid.of(groupMapper).insert(Group);
    }

    /**
     * 更新组别
     *
     * @param Group
     */
    public void updateGroup(Group Group) {
        MyDruid.of(groupMapper).update(Group);
    }

    /**
     * 删除组别
     *
     * @param GroupId
     */
    public void deleteGroup(Integer GroupId) {
        MyDruid.of(groupMapper).delete(GroupId);
    }
}
