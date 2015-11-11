package com.bluebird.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ApplicationProperties {

	@Bean
	public PropertyPlaceholderConfigurer cachePropertiesConfigurer() {
		PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
		configurer.setLocations(
				new Resource[] {
							new ClassPathResource("jpa.properties"), 
							new ClassPathResource("swagger.properties")
						});
		configurer.setIgnoreUnresolvablePlaceholders(true);
		return configurer;
	}
}
