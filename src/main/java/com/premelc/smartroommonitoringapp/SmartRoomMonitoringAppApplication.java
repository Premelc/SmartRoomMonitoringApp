package com.premelc.smartroommonitoringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.*;
import org.springframework.boot.autoconfigure.mongo.*;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@EnableMongoRepositories

public class SmartRoomMonitoringAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartRoomMonitoringAppApplication.class, args);
    }
}
