package com.rnd.backendspring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration(exclude = {HibernateJpaAutoConfiguration.class})
public class ConfigHibernate {

    @Value("${db.driver}")
    private String dbDriver;

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String dbUsername;

    @Value("${db.password}")
    private String dbPassword;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;

    @Value("${hibernate.show_sql}")
    private String hibernateShowSql;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateHbm2ddlAuto;

    @Value("${entitymanager.packagesToScan}")
    private String hibernateEntityPackageToScan;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataManagerSource = new DriverManagerDataSource();
        dataManagerSource.setDriverClassName(dbDriver);
        dataManagerSource.setUrl(dbUrl);
        dataManagerSource.setUsername(dbUsername);
        dataManagerSource.setPassword(dbPassword);
        return dataManagerSource;
    }

    @Bean
    public LocalSessionFactoryBean factoryBean(){
        LocalSessionFactoryBean beanFactory = new LocalSessionFactoryBean();
        beanFactory.setDataSource(dataSource());
        beanFactory.setPackagesToScan(hibernateEntityPackageToScan);
        Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", hibernateShowSql);
        properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        beanFactory.setHibernateProperties(properties);
        return beanFactory;
    }


    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(factoryBean().getObject());
        return transactionManager;
    }

}
