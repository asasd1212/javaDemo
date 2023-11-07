package cn.tbs.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(JdbcProperties.class)
public class jdbcConfig {
//
//    JdbcProperties jdbcProperties;

//    public jdbcConfig(JdbcProperties jdbcProperties){
//        this.jdbcProperties = jdbcProperties;
//    }

    @Bean
    @ConfigurationProperties(prefix = "jdbc")
    public DataSource getDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();

        return druidDataSource;
    }

}
