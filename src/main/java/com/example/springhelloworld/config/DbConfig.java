//package com.example.springhelloworld.config;
//
//import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//@Configuration
//public class DbConfig {
//
////    @Bean(name = "dataSource")
////    @Primary
////    @ConfigurationProperties(prefix = "spring.datasource")
////    public DataSource mysqlDataSource() {
////        return DataSourceBuilder.create().build();
////    }
////
////    @Bean
////    @Autowired
////    public JdbcTemplate configureJdbcTempalate(@Qualifier("dataSource") DataSource dataSource){
////        return new JdbcTemplate(dataSource);
////    }
//}