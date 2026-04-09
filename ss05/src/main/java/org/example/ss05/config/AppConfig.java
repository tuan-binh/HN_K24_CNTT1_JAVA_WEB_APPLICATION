package org.example.ss05.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("org.example.ss05")
public class AppConfig {

    // 1. Bean SpringResourceTemplateResolver - cấu hình đọc template giao diện HTML
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        // tiền tố
        resolver.setPrefix("/WEB-INF/views/");
        // hậu tố
        resolver.setSuffix(".html");
        // cần set charactor cho giao diện hiểu được các ký tự tiếng việt
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

    // 2. Bean SpringTemplateEngine - mục đích trung tâm xử lý (biên dịch nhưng cú pháp thymeleaf -> HTML)

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver( templateResolver() );
        return engine;
    }

    // 3. Bean ThymeleafViewResolver - Khởi tạo thymeleaf Spring MVC <=> ViewResolver
    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }

}
