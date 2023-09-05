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
        entityManagerFactoryRef = "moicEntityManager",
        transactionManagerRef = "moicTransactionManager",

        /* 혜지 : 작성 시마다 패키지 추가 필요 */
        basePackages = {
                "com.test.study.user.model.repository",
                "com.test.study.card.model.repository",
                "com.test.study.cardBenefit.model.repository",
                "com.test.study.giftCard.model.repository",
                "com.test.study.shop.model.repository",
                "com.test.study.userCard.model.repository",
                "com.test.study.userBookMark.model.repository",
        }
)
public class MoicDBConfig {

    @Autowired
    private Environment env;

    @Primary
    @Bean
    public DataSource moicDataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();

        dataSource.setDriverClassName(env.getProperty("spring.moicDB.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.moicDB.datasource.jdbc-url"));
        dataSource.setUsername(env.getProperty("spring.moicDB.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.moicDB.datasource.password"));

        return dataSource;
    }

//    @Primary
//    @Bean
//    @ConfigurationProperties("spring.moicDB.datasource")
//    public DataSourceProperties moicDataSourceProperties(){
//        return new DataSourceProperties();
//    }
//
//    @Primary
//    @Bean
//    @ConfigurationProperties("spring.moicDB.datasource.configuration")
//    public DataSource moicDataSourceConfig(){
//        return moicDataSourceProperties()
//                .initializeDataSourceBuilder()
//                .type(HikariDataSource.class)
//                .build();
//    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean moicEntityManager(){
        LocalContainerEntityManagerFactoryBean bean
                =new LocalContainerEntityManagerFactoryBean();
        HibernateJpaVendorAdapter vendorAdapter
                =new HibernateJpaVendorAdapter();
        HashMap<String, Object> properties=new HashMap<>();

        bean.setDataSource(moicDataSource());

        /* 혜지 : 작성 시마다 패키지 추가 필요 */
        bean.setPackagesToScan(new String[]{
                "com.test.study.user.model.entity",
                "com.test.study.card.model.entity",
                "com.test.study.cardBenefit.model.entity",
                "com.test.study.giftCard.model.entity",
                "com.test.study.shop.model.entity",
                "com.test.study.userCard.model.entity",
                "com.test.study.userBookMark.model.entity",
        });

        bean.setJpaVendorAdapter(vendorAdapter);
        properties.put("hibernate.hbm2ddl.auto",env.getProperty("spring.moicDB.hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("spring.moicDB.hibernate.dialect"));
        bean.setJpaPropertyMap(properties);
        return bean;
    }

    @Primary
    @Bean
    public PlatformTransactionManager moicTransactionManager(){
        JpaTransactionManager transactionManager=new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(moicEntityManager().getObject());
        return transactionManager;
    }
}
