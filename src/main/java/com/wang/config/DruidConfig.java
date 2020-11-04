package com.wang.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控 : 类似web.xml
    //因为springboot 内置了 servlet容器， 所以没有web.xml 替代方法:ServletRegistrationBean
    @Bean
    public ServletRegistrationBean stateViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //后台需要有人登陆， 账号密码
        HashMap<String , String > initParameters = new HashMap<>();
        //增加配置
        initParameters.put("loginUsername", "admin"); //登陆的key值是固定的
        initParameters.put("loginPassword", "123456");
        initParameters.put("allow","");
        //禁止访问
        initParameters.put("hahak","192.12.23.1");
        bean.setInitParameters(initParameters); //设置初始化参数
        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());

        //可以过滤哪些请求
        HashMap<String , String > initParameters = new HashMap<>();
        //这些东西不进行过滤
        initParameters.put("exclusion", "*.js,*.css,/druid/**");
        bean.setInitParameters(initParameters);

        return bean;
    }


}
