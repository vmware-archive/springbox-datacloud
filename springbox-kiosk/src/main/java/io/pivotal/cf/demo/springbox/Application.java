package io.pivotal.cf.demo.springbox;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.integration.annotation.IntegrationComponentScan;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories
@IntegrationComponentScan
@ImportResource("integration-context.xml")
@Import(RepositoryRestMvcConfiguration.class)
public class Application {

    @Bean
    public RabbitTemplate amqpTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("blue-turtle.rmq.cloudamqp.com");
        connectionFactory.setUsername("qglbylca");
        connectionFactory.setPassword("j87N0EMNL_5mBZ_FbqY1L1S5T8kYF5Q7");
        connectionFactory.setVirtualHost("qglbylca");
        return connectionFactory;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
