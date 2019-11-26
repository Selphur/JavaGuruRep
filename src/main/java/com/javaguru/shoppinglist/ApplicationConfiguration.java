package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.repository.SqlRepository;
import com.javaguru.shoppinglist.validator.ProductValidator;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@Configuration
@ComponentScan(basePackages = "com.javaguru.shoppinglist")
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {
    @Bean
    public Ui ui(){
        return new Ui();
    }

    @Bean
    public ProductValidator productValidator() {
        return new ProductValidator(sqlRepository());
    }

    @Bean
    public ProductService productService() {
        return new ProductService(productValidator(), sqlRepository());
    }

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${driverClass}")
    private String driverClass;

    @Value("${database.user.name}")
    private String userName;

    @Value("${database.user.password}")
    private String password;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(jdbcUrl);
        dataSource.setDriverClassName(driverClass);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public SqlRepository sqlRepository() {
        return new SqlRepository(dataSource(), jdbcTemplate());
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
