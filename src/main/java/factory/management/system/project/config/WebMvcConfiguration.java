package factory.management.system.project.config;

import factory.management.system.project.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * WebMvcConfiguration
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/7/6 15:01
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    private LoginInterceptor loginInterceptor;

    /**
     * 配置拦截路径
     *
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/server/**").excludePathPatterns("/server/login", "/server/tologin", "/static/**");
        super.addInterceptors(registry);
    }

    /**
     * 配置静态文件路径
     *
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}
