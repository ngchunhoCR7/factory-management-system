package factory.management.system.project.controller;

import factory.management.system.project.entity.Admin;
import factory.management.system.project.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ServerController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/18 21:11
 */
@Controller
@RequestMapping("/server")
public class ServerController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/index")
    public String index() {
        return
    }

    @RequestMapping("/login")
    public String login(Admin admin) {
        return "redirect:/server/index";
    }
}
