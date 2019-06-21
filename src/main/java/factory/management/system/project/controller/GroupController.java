package factory.management.system.project.controller;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Group;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * GroupController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/21 21:00
 */
@Controller
@RequestMapping("/server/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("/index")
    public String getgroups(PageSizeInfo pageSizeInfo, Model model) {
        // 获取分页查询列表
        PageInfo<Group> pageInfo = groupService.getGroups(pageSizeInfo);
        model.addAttribute("pageList", pageInfo);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/group");
        return "index";
    }

    @GetMapping("/select")
    public String selectgroup(Integer groupId, Model model) {
        // 判断是否为空
        if (StringUtils.isEmpty(groupId)) {
            return "redirect:/server/group/index";
        } else {
            Group group = groupService.getGroup(groupId);
            // 添加到链表
            List<Group> list = new ArrayList<Group>() {
                {
                    add(group);
                }
            };
            // 设置分页信息
            PageInfo<Group> groups = new PageInfo<>();
            groups.setList(list);
            groups.setNavigatepageNums(new int[]{1});
            model.addAttribute("pageList", groups);
            // 设置分页跳转链接
            model.addAttribute("url", "/server/group");
            return "index";
        }
    }

    @PostMapping("/insert")
    public String insertgroup(Group group) {
        groupService.insertGroup(group);
        return "redirect:/server/group/index";
    }

    @PostMapping("/update")
    public String updategroup(Group group) {
        groupService.updateGroup(group);
        return "redirect:/server/group/index";
    }

    @GetMapping("/delete")
    public String deletegroup(Integer groupId) {
        groupService.deleteGroup(groupId);
        return "redirect:/server/group/index";
    }
}
