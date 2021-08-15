package org.lin.config;

import org.lin.interceptor.BaseInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class BaseConfig implements WebMvcConfigurer {

  @Bean
  public BaseInterceptor baseInterceptor() {
    return new BaseInterceptor();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
//    registry.addInterceptor(new BaseInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/login/**");
    registry.addInterceptor(baseInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/login/**");
  }
}
