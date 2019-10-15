package com.noah.demo.config;

import com.sun.xml.internal.bind.v2.util.DataSourceSource;
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
@MapperScan(basePackages = DataSource1Config.PACKAGESPATH,sqlSessionTemplateRef = "db1SqlSessionTemplate")
public class DataSource1Config {
    public static final String PACKAGESPATH = "com.noah.demo.db1";

    /**
     *
     * @Author yz
     * @Description 生成数据源
     * @Date 2019-10-15 10:08
     * @param
     * @return javax.sql.DataSource
     */
    @Bean(name = "db1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hikari.db1")
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
    @Bean("db1SqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("db1DataSource")DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 配置事务管理
     */
    @Bean(name = "db1TransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("db1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "db1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
