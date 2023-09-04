package com.test.study.util.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "MoicSecurityEntityManager",
        transactionManagerRef = "MoicSecurityTransactionManager",

        /* 혜지 : 패키지 추가 완료 */
        basePackages = {"com.test.study.userSecurity.model.repository",}
)
public class MoicSecurityDBConfig {

    @Autowired
    private Environment env;

    @Primary
    @Bean
    public DataSource moicSecurityDataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();

        dataSource.setDriverClassName(env.getProperty("spring.moicSecurityDB.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.moicSecurityDB.datasource.jdbc-url"));
        dataSource.setUsername(env.getProperty("spring.moicSecurityDB.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.moicSecurityDB.datasource.password"));

        return dataSource;
    }

    @Primary
    @Bean
    @ConfigurationProperties("spring.moicSecurityDB.datasource")
    public DataSourceProperties moicSecurityDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    @ConfigurationProperties("spring.moicSecurityDB.datasource.configuration")
    public DataSource moicSecurityDataSourceConfig(){
        return moicSecurityDataSourceProperties()
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean moicSecurityEntityManager(){
        LocalContainerEntityManagerFactoryBean bean
                =new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendorAdapter
                =new HibernateJpaVendorAdapter();
        HashMap<String, Object> properties=new HashMap<>();

        bean.setDataSource(moicSecurityDataSource());

        /* 혜지 : 패키지 추가 완료 */
        bean.setPackagesToScan(new String[]{"com.test.study.userSecurity.model.entity"});

        bean.setJpaVendorAdapter(vendorAdapter);
        properties.put("hibernate.hbm2ddl.auto",env.getProperty("spring.moicSecurityDB.hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("spring.moicSecurityDB.hibernate.dialect"));
        bean.setJpaPropertyMap(properties);
        return bean;
    }

    @Primary
    @Bean
    public PlatformTransactionManager moicSecurityTransactionManager(){
        JpaTransactionManager transactionManager=new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(moicSecurityEntityManager().getObject());
        return transactionManager;
    }
}
