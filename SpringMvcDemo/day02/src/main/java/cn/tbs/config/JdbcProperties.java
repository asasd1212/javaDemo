package cn.tbs.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jdbc")
@Data
public class JdbcProperties {
    //该类的属性，是配置文件，jdbc后面的值;
    private String driverClassName;
    private String url;
    private String username;
    private String password;

}



