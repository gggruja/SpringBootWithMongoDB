package com.goran.interv.play.service.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfiguration {
    /*
     * Factory bean that creates the com.mongodb.Mongo instance
     */
    public @Bean MongoClient mongo() throws Exception {
        return new MongoClient("localhost",27017);
    }

    public @Bean MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "persons");
    }

}
