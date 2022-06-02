package com.premelc.smartroommonitoringapp;

import com.premelc.smartroommonitoringapp.models.*;
import org.bson.types.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.*;
import org.springframework.boot.autoconfigure.mongo.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.sql.*;
import java.util.Date;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@EnableMongoRepositories

public class SmartRoomMonitoringAppApplication /*implements CommandLineRunner*/ {

    @Autowired
    MongoTemplate mongoTemplate2013;
    @Autowired
    MongoTemplate mongoTemplate2014;

    public static void main(String[] args) {
        SpringApplication.run(SmartRoomMonitoringAppApplication.class, args);
    }
/*
    @Override
    public void run(String... args) throws Exception {

        AdriaIndoor a = new AdriaIndoor(new ObjectId(),1l, 1 , 1 ,1,1 ,1,1 , 1 ,"a" , 1 , 1 );
        AdriaIndoor b = new AdriaIndoor(new ObjectId(),1l, 1 , 1 ,1,1 ,1,1 , 1 ,"a" , 1 , 1 );
        mongoTemplate2013.getCollection("001").insertOne(AdriaIndoorDocument.createDoc(a));
        mongoTemplate2014.getCollection("001").insertOne(AdriaIndoorDocument.createDoc(a));
       /* System.out.println("Collection adriaIndoor Exists? " + mongoTemplate.collectionExists("adriaIndoor"));
        System.out.println("Collection dhmzObradeno Exists? " + mongoTemplate.collectionExists("dhmzObradeno"));
        System.out.println("Collection dhmzBase Exists? " + mongoTemplate.collectionExists("dhmzBase"));
        System.out.println("dhmzObradeno document count: " +mongoTemplate.getCollection("dhmzObradeno").countDocuments());
        System.out.println("AdriaIndoor document count: " +mongoTemplate.getCollection("001").countDocuments());
        //DHMZObradeno o = new DHMZObradeno("1234" , 0d,0d,0d,0d,0d);
        //mongoTemplate.insert(o);

    }
    */
}
