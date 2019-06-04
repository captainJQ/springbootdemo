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
@MapperScan(basePackages = "com.jql.mapper1",sqlSessionFactoryRef = "sqlSessionFactory1")*/
public class DataSourceConfig1 {
    @Bean(name = "dataSource1")
    @ConfigurationProperties(prefix = "spring.datasource.ds1")
    public DataSource getDataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "sqlSessionFactory1")
    public SqlSessionFactory getSqlSessionFactory(@Qualifier("dataSource1") DataSource dataSource)throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        /*bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:/mapping/mapping1/*.xml")
        );*/
        return bean.getObject();
    }
        @Bean(name = "dataSourceTransactionManager1")
        public DataSourceTransactionManager getDataSourceTransactionManager(@Qualifier("dataSource1") DataSource dataSource){
            return new DataSourceTransactionManager(dataSource);
        }
    @Bean(name = "sqlSessionTemplate1")
    public SqlSessionTemplate getSqlSessionTemplate(@Qualifier("sqlSessionFactory1") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
