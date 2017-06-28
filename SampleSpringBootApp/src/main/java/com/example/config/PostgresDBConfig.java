package com.example.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class PostgresDBConfig {
	
    @Bean(name="worldRegionDb")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource db1DataSource(){
        return new org.apache.tomcat.jdbc.pool.DataSource();
    }
    
    
    @Bean(name="wrJDBCTemplate")
    public JdbcTemplate jdbcTemplate(DataSource worldRegionDb){
    	return new JdbcTemplate(worldRegionDb);
    }
    
    @Bean(name="wrTransactionManager")
    public PlatformTransactionManager transactionManager(DataSource worldRegionDb){
    	return new DataSourceTransactionManager(worldRegionDb);
    }
    
    
   
//    @Bean(name="db2.datasource")
//    @ConfigurationProperties(prefix="db2.datasource")
//    public DataSource db2DataSource(){
//        return DataSourceBuilder.create().build();
//    } 

}
