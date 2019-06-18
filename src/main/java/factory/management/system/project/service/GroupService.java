package factory.management.system.project.service;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Group;
import factory.management.system.project.mapper.GroupMapper;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.utils.MyDruid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private GroupMapper GroupMapper;

    /**
     * 获取组别列表
     *
     * @param pageSizeInfo
     * @return
     */
    public PageInfo<Group> getGroups(PageSizeInfo pageSizeInfo) {
        // 分页查询
        return (PageInfo<Group>) MyDruid.of(GroupMapper).retrieve(new PageSizeInfo());
    }

    /**
     * 获取单个组别
     *
     * @param GroupId
     * @return
     */
    public Group getGroup(Integer GroupId) {
        return (Group) MyDruid.of(GroupMapper).retrieve(GroupId);
    }

    /**
     * 新增组别
     *
     * @param Group
     */
    public void insertGroup(Group Group) {
        MyDruid.of(GroupMapper).insert(Group);
    }

    /**
     * 更新组别
     *
     * @param Group
     */
    public void updateGroup(Group Group) {
        MyDruid.of(GroupMapper).update(Group);
    }

    /**
     * 删除组别
     *
     * @param GroupId
     */
    public void deleteGroup(Integer GroupId) {
        MyDruid.of(GroupMapper).delete(GroupId);
    }
}
