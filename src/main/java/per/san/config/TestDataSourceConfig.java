package per.san.config;

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
 * description:
 *
 * @author shencai.huang@hand-china.com
 * @date 2020/10/7 11:06 上午
 * lastUpdateBy: shencai.huang@hand-china.com
 * lastUpdateDate: 2020/10/7
 */
//@Configuration
//@MapperScan(basePackages = "per.san.mapper",
//        sqlSessionTemplateRef = "testSqlSessionTemplate")
public class TestDataSourceConfig {

    @Bean(name = "testDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "testSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory (@Qualifier("testDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "testTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("testDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "testSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("testSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
