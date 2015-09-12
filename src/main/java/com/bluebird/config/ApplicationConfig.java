package com.bluebird.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import com.mangofactory.swagger.configuration.DocumentationConfig;

@Configuration
@ComponentScan("com.bluebird")
@Import(value = {ApplicationProperties.class, DocumentationConfig.class})
public class ApplicationConfig extends WebMvcConfigurationSupport {

	@Bean 
    public ServletContextTemplateResolver templateResolver() {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
        resolver.setPrefix("/views/");
        resolver.setSuffix(".html");
//        resolver.setTemplateMode("HTML5");
        resolver.setOrder(1);
        /**Uncomment below line only development mode only on need basis*/
        resolver.setCacheable(false);
        return resolver;
    }

    @Bean 
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        engine.addDialect(new LayoutDialect());
        return engine;
    }

    @Bean 
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        return resolver;
    }

	
}
