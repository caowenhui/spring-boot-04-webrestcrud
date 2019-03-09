package com.cao.springboot.config;

import com.cao.springboot.component.LoginHandlerInterceptor;
import com.cao.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 使用WebMvcConfigurerAdaptor可以扩展SpringMVC的功能
 * @Author cwh
 * @Date 2019/3/4 22:38.
 */
@Configuration
//@EnableWebMvc
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        //浏览器发送cwh请求，请求来到success页面
        registry.addViewController("/cwh").setViewName("success");
    }

    //所有WebMvcConfigurerAdapter组件都会一起起作用
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                // SpringBoot已经做好了静态页面的映射了
                registry.addInterceptor(new LoginHandlerInterceptor())
                        .addPathPatterns("/**")
                        .excludePathPatterns("/index.html", "/", "/user/login");
            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
