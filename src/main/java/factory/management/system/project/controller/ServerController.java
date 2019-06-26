package factory.management.system.project.controller;

import factory.management.system.project.entity.Admin;
import factory.management.system.project.entity.Employee;
import factory.management.system.project.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        // 重定向到员工管理首页
        return "redirect:/server/employee/index";
    }

    @RequestMapping("/login")
    public String login(/*HttpServletRequest request, Model model*/) {
        /*// 获取cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                Admin admin;
                if (cookie.getName().equals("remember")) {
                    // 从json中获取对象
                    admin = JSON.parseObject(cookie.getValue(), Admin.class);
                    // 返回前端
                    model.addAttribute("admin", admin);
                } else {
                    model.addAttribute("admin", new Admin());
                }
            }
        }*/
        return "login";
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/error")
    public String error() {
        return "../static/404";
    }

    /**
     * ajax请求测试类
     *
     * @param employee
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/testdemo")
    public Employee test(Employee employee) {
        System.out.println(employee);
        return employee;
    }

    @ResponseBody
    @PostMapping(value = "/tologin")
    public boolean tologin(Admin admin/*, String remember, HttpServletResponse response*/) {
        /*if ("remember-me".equals(remember)) {
            // 转化为json字符串
            String adminJson = JSON.toJSONString(admin);
            // 保存在cookie中
            Cookie cookie = new Cookie("remember", adminJson);
            response.addCookie(cookie);
        }*/

        return adminService.login(admin);
    }
}
