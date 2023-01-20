package com.sau.badmintonhallinformationmanagementsystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author SRDZ
 * @date 2023/1/19 20:02
 */

@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOriginPatterns("*")
        .allowedMethods("POST","GET","PUT","DELETE","OPTIONS")
        .maxAge(168000)
        .allowedHeaders("*")
        .allowCredentials(true);
  }
}
