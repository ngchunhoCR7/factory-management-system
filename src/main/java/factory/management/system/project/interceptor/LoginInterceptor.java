package factory.management.system.project.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * LoginInterceptor
 *
 * @author ngchunho
 * @version 1.0.0
 * @description 登录拦截器
 * @date 2019/6/26 22:21
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        // 如果没有登录就总之请求并发送到登录页面
        if (session.getAttribute("admin") == null || "".equals(session.getAttribute("admin"))) {
            //获得用户要访问的路径，保存到session，这样，用户登录成功之后，可以从session获得该路径，从而跳转到对应的路径
            String uri = request.getRequestURI();
            session.setAttribute("path", uri);
            response.sendRedirect("/server/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
    }
}
