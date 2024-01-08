package com.zjx.rbacredis.configuration;

import com.zjx.rbacredis.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web配置类
 * 功能: 配置拦截器
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    //Spring中拦截器类的生成先于容器上下文的生成，所以需要提前配置
    @Bean
    LoginInterceptor getLoginInterceptor(){
        return new LoginInterceptor();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    //注册拦截器，配置排除路径
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginInterceptor()).excludePathPatterns("/login").excludePathPatterns("/loginout");
    }
}
