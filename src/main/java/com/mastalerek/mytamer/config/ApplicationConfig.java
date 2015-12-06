package com.mastalerek.mytamer.config;

import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.google.common.base.Preconditions;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:application.properties" })
@ComponentScan({ "com.mastalerek.mytamer" })
public class ApplicationConfig {

	@Autowired
	private Environment environment;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(restDataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.mastalerek.mytamer" });
		// sessionFactory.
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	@Bean
	public BasicDataSource restDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(Preconditions.checkNotNull(environment.getProperty("jdbc.driverClassName")));
		System.out.println("jdbc.password: ");
		System.out.println(environment.getProperty("jdbc.password"));
		dataSource.setUrl(Preconditions.checkNotNull(environment.getProperty("jdbc.url")));
		dataSource.setUsername(Preconditions.checkNotNull(environment.getProperty("jdbc.username")));
		dataSource.setPassword(Preconditions.checkNotNull(environment.getProperty("jdbc.password")));

		return dataSource;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory().getObject());

		return txManager;
	}

	Properties hibernateProperties() {
		return new Properties() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 6895426937128648640L;

			{
				setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.ddl.auto"));
				setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
				setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
			}
		};
	}
}
