package io.pivotal.cf.demo.springbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
@EnableMongoRepositories
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
@ComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


//    @Bean
//    public MongoDbFactory mongo() {
//        try {
//            return new SimpleMongoDbFactory(new MongoClient("ds035280.mongolab.com", 35280), "CloudFoundry_4hurnk80_9f2haksv",
//                    new UserCredentials("springbox", "password"));
//        } catch (UnknownHostException e) {
//            throw new RuntimeException("Error creating MongoDbFactory: " + e);
//        }
//    }
}
