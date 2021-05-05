package com.shijl.config;


import com.shijl.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 扩展mvc
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    /**
     * 拦截器拦截
     *
     * 1、配置拦截器
     * 2、拦截哪些请求
     * 3、放行哪些请求
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login",
                        "/css/**","/fonts/**","/images/**","/js/**","/sql");
    }
}
