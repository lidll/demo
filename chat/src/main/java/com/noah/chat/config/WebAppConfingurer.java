package com.noah.chat.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebAppConfingurer
 * @Description TODO
 * @Author noah
 * @Date 2019-10-21 15:49
 * @Version 1.0
 **/
@Configuration
public class WebAppConfingurer implements WebMvcConfigurer {
    //还可以通过extends WebMvcConfigurationSupport
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }

    //配置资源映射路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/")
                .addResourceLocations("classpath:/static/");
    }
}
