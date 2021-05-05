package com.shijl.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 *          <dependency>
 *             <groupId>com.alibaba</groupId>
 *             <artifactId>druid-spring-boot-starter</artifactId>
 *             <version>1.2.6</version>
 *         </dependency>
 *
 *         加入springboot整合druid的依赖，以下配置不需要
 *
 *         //标注过时的注解   @Deprecated
 */
//@Configuration
@Deprecated
public class MyDataSourceConfig {

    /**
     * springboot默认配置的HikariDataSource数据源，在没有配置数据源时生效
     *
     * @ConfigurationProperties("spring.datasource")
     */
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl(url);
//        druidDataSource.setDriverClassName(driver);
//        druidDataSource.setUsername(username);
//        druidDataSource.setPassword(password);
        try {

            //wall  防火墙
            // stat监控功能
            //在配置文件也可以配置
            druidDataSource.setFilters("stat,wall");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return druidDataSource;
    }

    /**
     * druid  监控页功能
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        //添加监控页访问的账号密码
        statViewServletServletRegistrationBean.addInitParameter("loginUsername","admin");
        statViewServletServletRegistrationBean.addInitParameter("loginPassword","123");
        return statViewServletServletRegistrationBean;
    }

    /**
     * 监控web应用
     * 采集web-jdbc关联监控的数据
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> webStatFilterFilterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        webStatFilterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        webStatFilterFilterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return webStatFilterFilterRegistrationBean;
    }
}
