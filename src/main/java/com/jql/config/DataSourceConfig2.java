package com.jql.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/*@Configuration
@MapperScan(basePackages = "com.jql.mapper2",sqlSessionFactoryRef = "sqlSessionFactory2")*/
public class DataSourceConfig2 {
    @Bean(name = "dataSource2")
    @ConfigurationProperties(prefix = "spring.datasource.ds2")
    public DataSource getDataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "sqlSessionFactory2")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("dataSource2") DataSource dataSource)throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        /*bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:/mapping/mapping2/*.xml")
        );*/
        return bean.getObject();
    }
    @Bean(name = "dataSourceTransactionManager2")
    public DataSourceTransactionManager getDataSourceTransactionManager(@Qualifier("dataSource2") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean(name = "sqlSessionTemplate2")
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("sqlSessionFactory2") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
