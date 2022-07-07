package sawant.mihir.springdatajdbctemplate.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.sql.DataSource;

@Configuration
public class ProjectConfig {

    @Value("${custom.ds.url}")
    private String url;

    @Value("${custom.ds.user}")
    private String userName;

    @Value("${custom.ds.pass}")
    private String password;

    @Bean
    public DataSource customMySqlDs(){
        var ds = new HikariDataSource();
        ds.setJdbcUrl(url);
        ds.setUsername(userName);
        ds.setPassword(password);
        return ds;
    }
}
