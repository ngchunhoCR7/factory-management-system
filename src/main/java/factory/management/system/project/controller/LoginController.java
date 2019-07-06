package factory.management.system.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * LoginController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description 登录控制器
 * @date 2019/7/6 16:31
 */
@Controller
public class LoginController {

    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping("/server/login")
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
}
