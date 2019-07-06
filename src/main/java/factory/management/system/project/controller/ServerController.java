package factory.management.system.project.controller;

import factory.management.system.project.entity.Admin;
import factory.management.system.project.entity.Employee;
import factory.management.system.project.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * ServerController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description 服务器功能服务器
 * @date 2019/6/18 21:11
 */
@Controller
@RequestMapping("/server")
public class ServerController {

    @Autowired
    private AdminService adminService;

    /**
     * 跳转到服务器首页
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        // 重定向到员工管理首页
        return "redirect:/server/employee/index";
    }

    /**
     * 退出到登录页面
     *
     * @param session
     * @return
     */
    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        // 清空登录状态
        session.setAttribute("admin", "");
        return "redirect:/server/login";
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

    /**
     * 检查用户状态
     *
     * @param admin
     * @return
     */
    @ResponseBody
    @PostMapping(value = "/tologin")
    public boolean tologin(HttpSession session, Admin admin /*, String remember, HttpServletResponse response*/) {
        /*if ("remember-me".equals(remember)) {
            // 转化为json字符串
            String adminJson = JSON.toJSONString(admin);
            // 保存在cookie中
            Cookie cookie = new Cookie("remember", adminJson);
            response.addCookie(cookie);
        }*/

        // 判断是否存在管理员
        boolean result = adminService.login(admin);
        if (result) {
            session.setAttribute("admin", admin.getAdminName());
            return true;
        } else {
            return false;
        }
    }
}
