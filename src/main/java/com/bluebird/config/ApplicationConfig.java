package com.bluebird.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.mangofactory.swagger.configuration.DocumentationConfig;

@Configuration
@ComponentScan("com.bluebird")
@Import(value = {ApplicationProperties.class, DocumentationConfig.class})
public class ApplicationConfig extends WebMvcConfigurationSupport {

	
}
