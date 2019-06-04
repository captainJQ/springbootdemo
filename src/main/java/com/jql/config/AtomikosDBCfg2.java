package com.jql.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.jql.mapper2",sqlSessionTemplateRef = "sqlSessionTemplate4")
public class AtomikosDBCfg2 {
    @Bean(name = "dBConfigs2")
    @ConfigurationProperties(prefix = "spring.datasource.ds2")
    public DBConfigs getDBConfigs(){
        return new DBConfigs();
    }


    //配置数据源
    @Bean(name="datasource4")
    public DataSource Datasource(@Qualifier("dBConfigs2") DBConfigs config1) {
        MysqlXADataSource mysqlXADataSource=new MysqlXADataSource();
        mysqlXADataSource.setUrl(config1.getUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword(config1.getPassword());
        mysqlXADataSource.setUser(config1.getUsername());

        AtomikosDataSourceBean atomikosDataSourceBean=new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("datasource4");

//    atomikosDataSourceBean.setMinPoolSize(config1.getMinPoolSize());
//    atomikosDataSourceBean.setMaxPoolSize(config1.getMaxPoolSize());
//    atomikosDataSourceBean.setMaxLifetime(config1.getMaxLifetime());
//    atomikosDataSourceBean.setBorrowConnectionTimeout(config1.getBorrowConnectionTimeout());
//    atomikosDataSourceBean.setLoginTimeout(config1.getLoginTimeout());
//    atomikosDataSourceBean.setMaintenanceInterval(config1.getMaintenanceInterval());
//    atomikosDataSourceBean.setMaxIdleTime(config1.getMaxIdleTime());
        return atomikosDataSourceBean;
    }

    @Bean(name = "sqlSessionFactory4")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("datasource4")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
       /* //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mapping/mapping1/xml/*Mapper.xml"));*/
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "sqlSessionTemplate4")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory4") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
