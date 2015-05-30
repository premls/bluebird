package com.bluebird.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages="com.bluebird.repository")
@EnableTransactionManagement
@Import(ApplicationProperties.class)
public class JPAConfig {
	
	@Value("${jdbc.driver}")
	private String driverClass;

	@Value("${jdbc.url}")
	private String jdbcUrl;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;
	
	@Value("${jpa.database}")
	private String jpaDatabase;
	
	@Value("${jpa.showSql}")
	private boolean jpaShowSql;
	
	@Value("${hibernate.dialect}")
	private String hibernateDialect;
	
	@Value("${hibernate.showSql}")
	private boolean hibernateShowSql;
	
	@Value("${hibernate.namingStrategy}")
	private String hibernateNamingStrategy;
	
	@Value("${hibernate.packagesToScan}")
	private String hibernatePackagesToScan;
	
	@Value("${hibernate.generateStatistics}")
	private String hibernateGenerateStatistics;
	
	@Value("${hibernate.generateDdl}")
	private boolean hibernateGenerateDDL;
	
	@Value("${hibernate.hbm2ddlAuto}")
	private String hibernateHbm2DdlAuto;
	
	@Value("${hibernate.connection.autocommit}")
	private boolean hibernateConnectionAutoCommit;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(jdbcUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean
	public JpaDialect jpaDialect() {
		return new HibernateJpaDialect();
	}
	
	@Bean
	public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabasePlatform(jpaDatabase);
		vendorAdapter.setShowSql(jpaShowSql);
		return vendorAdapter;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setJpaDialect(jpaDialect());
		factoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter());
		factoryBean.setPackagesToScan(hibernatePackagesToScan);
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto", hibernateHbm2DdlAuto);
		jpaProperties.put("hibernate.connection.autocommit", hibernateConnectionAutoCommit);
		jpaProperties.put("hibernate.dialect", hibernateDialect);
		jpaProperties.put("hibernate.ejb.naming_strategy", hibernateNamingStrategy);
		jpaProperties.put("hibernate.generate_statistics", hibernateGenerateStatistics);
		jpaProperties.put("hibernate.show_sql", hibernateShowSql);
		jpaProperties.put("hibernate.enable_lazy_load_no_trans", true);
		factoryBean.setJpaProperties(jpaProperties);
		factoryBean.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
		return factoryBean;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}
	
	@Bean
	public HibernateExceptionTranslator exceptionTranslator() {
		return new HibernateExceptionTranslator();
	}

}