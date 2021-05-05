package com.shijl.servlet;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Arrays;

//proxyBeanMethods = true  保证容器中组件为单实例的
@Configuration(proxyBeanMethods = true)
public class MyRegistConfig {


    @Bean
    public ServletRegistrationBean myServlet(){
        return new ServletRegistrationBean(new MyServlet(),"/my");
    }

    @Bean
    public FilterRegistrationBean myFilter(){

        //拦截一个servlet请求
//        return new FilterRegistrationBean(new MyFilter(),myServlet());


        //拦截具体的请求
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>(new MyFilter());
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/my"));
        return filterFilterRegistrationBean;
    }


    @Bean
    public ServletListenerRegistrationBean myListener(){
        return new ServletListenerRegistrationBean(new MyServletContextListener());
    }

}
