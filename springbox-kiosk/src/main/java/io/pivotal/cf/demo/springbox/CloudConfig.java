package io.pivotal.cf.demo.springbox;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("cloud")
public class CloudConfig extends AbstractCloudConfig {

    @Bean
    public ConnectionFactory rabbitConnectionFactory() {
        return connectionFactory().rabbitConnectionFactory();
    }

    @Bean
    public DataSource dataSource() {
        return connectionFactory().dataSource();
    }
}
