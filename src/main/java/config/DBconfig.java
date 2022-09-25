package config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement

public class DBconfig {
    private String driverClassName="com.mysql.cj.jdbc.Driver";

    private String url="jdbc:mysql://localhost:3307/role";

    private String username="root";

    private String password="kkjjss103@";

    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(driverClassName);

        dataSource.setUrl(url);

        dataSource.setUsername(username);

        dataSource.setPassword(password);

        return dataSource;
    }
}
