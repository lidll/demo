//package com.noah.demo.config;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
///**
// * @ClassName DataSource2Config
// * @Description TODO
// * @Author noah
// * @Date 2019-10-15 10:14
// * @Version 1.0
// **/
//@Configuration
//@MapperScan(basePackages = DataSource2Config.PACKAGESPATH, sqlSessionTemplateRef = "db2SqlSessionTemplate")
//public class DataSource2Config {
//    public static final String PACKAGESPATH = "com.noah.noah.db2";
//
//    @Bean(name = "db2DataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.hikari.db2")
//    public DataSource testDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "db2SqlSessionFactory")
//    public SqlSessionFactory testSqlSessionFactory(@Qualifier("db2DataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        //bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/db2/*.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "db2TransactionManager")
//    public DataSourceTransactionManager testTransactionManager(@Qualifier("db2DataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "db2SqlSessionTemplate")
//    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("db2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//}