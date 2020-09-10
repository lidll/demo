package com.noah.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @ClassName DataSource1Config
 * @Description TODO
 * @Author noah
 * @Date 2019-10-15 10:00
 * @Version 1.0
 **/
@Configuration
@MapperScan(basePackages = DataSourceConfig.PACKAGESPATH,sqlSessionTemplateRef = "dbSqlSessionTemplate")
public class DataSourceConfig {
    public static final String PACKAGESPATH = "com.noah.noah.mybatis";

    /**
     *
     * @Author yz
     * @Description 生成数据源
     * @Date 2019-10-15 10:08
     * @param
     * @return javax.sql.DataSource
     */
    @Bean(name = "dbDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    @Primary
    public DataSource testDataSource(){
        return DataSourceBuilder.create().build();
    }

    /**
     *
     * @Author yz
     * @Description 创建sqlSessionFactory
     * @Date 2019-10-15 10:13
     * @param dataSource
     * @return org.apache.ibatis.session.SqlSessionFactory
     */
    @Bean("dbSqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("dbDataSource")DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 配置事务管理
     */
    @Bean(name = "dbTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("dbDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "dbSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("dbSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
