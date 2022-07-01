package com.premelc.smartroommonitoringapp.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDBconfig  {

    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "2021");
    }

    @Bean
    public MongoTemplate mongoTemplate2013() {
        return new MongoTemplate(mongoClient(), "2013");
    }

    @Bean
    public MongoTemplate mongoTemplate2014() {
        return new MongoTemplate(mongoClient(), "2014");
    }

    @Bean
    public MongoTemplate mongoTemplate2015() {
        return new MongoTemplate(mongoClient(), "2015");
    }

    @Bean
    public MongoTemplate mongoTemplate2016() {
        return new MongoTemplate(mongoClient(), "2016");
    }

    @Bean
    public MongoTemplate mongoTemplate2017() {
        return new MongoTemplate(mongoClient(), "2017");
    }

    @Bean
    public MongoTemplate mongoTemplate2018() {
        return new MongoTemplate(mongoClient(), "2018");
    }

    @Bean
    public MongoTemplate mongoTemplate2019() {
        return new MongoTemplate(mongoClient(), "2019");
    }

    @Bean
    public MongoTemplate mongoTemplate2020() {
        return new MongoTemplate(mongoClient(), "2020");
    }

    @Bean
    public MongoTemplate mongoTemplate2021() {
        return new MongoTemplate(mongoClient(), "2021");
    }

    @Bean
    public MongoTemplate mongoTemplate2022() {
        return new MongoTemplate(mongoClient(), "2022");
    }
}
