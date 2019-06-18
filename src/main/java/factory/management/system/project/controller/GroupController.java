package factory.management.system.project.controller;

import com.github.pagehelper.PageInfo;
import factory.management.system.project.entity.Group;
import factory.management.system.project.pojo.PageSizeInfo;
import factory.management.system.project.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * GroupController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/18 20:31
 */
@Controller
@RequestMapping("/server/group")
public class GroupController {

    @Autowired
    private GroupService GroupService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String getGroups(PageSizeInfo pageSizeInfo, Model model) {
        // 获取分页查询列表
        PageInfo<Group> pageInfo = GroupService.getGroups(pageSizeInfo);
        model.addAttribute("pageList", pageInfo);
        // 设置分页跳转链接
        model.addAttribute("url", "/server/group/select");
        return "page/group";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertGroup(Group Group) {
        GroupService.insertGroup(Group);
        return "redirect:/server/group/index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateGroup(Group Group) {
        GroupService.updateGroup(Group);
        return "redirect:/server/group/index";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteGroup(Integer GroupId) {
        GroupService.deleteGroup(GroupId);
        return "redirect:/server/group/index";
    }
}
