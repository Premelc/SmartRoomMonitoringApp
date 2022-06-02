package com.premelc.smartroommonitoringapp.controllers;

import com.mongodb.client.*;
import com.mongodb.client.model.*;
import org.bson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AdriaIndoorController {

    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    MongoTemplate mongoTemplate2013;
    @Autowired
    MongoTemplate mongoTemplate2014;
    @Autowired
    MongoTemplate mongoTemplate2015;
    @Autowired
    MongoTemplate mongoTemplate2016;
    @Autowired
    MongoTemplate mongoTemplate2017;
    @Autowired
    MongoTemplate mongoTemplate2018;
    @Autowired
    MongoTemplate mongoTemplate2019;
    @Autowired
    MongoTemplate mongoTemplate2020;
    @Autowired
    MongoTemplate mongoTemplate2021;
    @Autowired
    MongoTemplate mongoTemplate2022;


    @GetMapping("/adria2013/001")
    public List<String> adriaAll(){
        List<String> lista = new ArrayList<>();
        FindIterable<Document> finder = mongoTemplate2013.getCollection("001").find();
        MongoCursor<Document> cursor = finder.iterator();
        try{
            while(cursor.hasNext()){
                lista.add(cursor.next().toString());
            }
        }finally{
            cursor.close();
        }
        return lista;
    }

    @GetMapping("/adria/{year}/{room}")
    public List<String> adriaAllSelective(@PathVariable String year , @PathVariable String room){
        List<String> lista = new ArrayList<>();
        FindIterable<Document> finder = mongoTemplate.getCollection(room).find();
        if(year.equals("2013")) {
            finder = mongoTemplate2013.getCollection(room).find();
        }else if(year.equals("2014")) {
            finder = mongoTemplate2014.getCollection(room).find();
        }else if(year.equals("2015")) {
            finder = mongoTemplate2015.getCollection(room).find();
        }else if(year.equals("2016")) {
            finder = mongoTemplate2016.getCollection(room).find();
        }else if(year.equals("2017")) {
            finder = mongoTemplate2017.getCollection(room).find();
        }else if(year.equals("2018")) {
            finder = mongoTemplate2018.getCollection(room).find();
        }else if(year.equals("2019")) {
            finder = mongoTemplate2019.getCollection(room).find();
        }else if(year.equals("2020")) {
            finder = mongoTemplate2020.getCollection(room).find();
        }else if(year.equals("2021")) {
            finder = mongoTemplate2021.getCollection(room).find();
        }else if(year.equals("2022")) {
            finder = mongoTemplate2022.getCollection(room).find();
        }
        MongoCursor<Document> cursor = finder.iterator();
        try{
            while(cursor.hasNext()){
                lista.add(cursor.next().toString());
            }
        }finally{
            cursor.close();
        }
        return lista;
    }

    @GetMapping("/adria/filter/{year}/{room}")
    @ResponseBody
    public List<String> adriaAllSelectiveAfter(@PathVariable String year , @PathVariable String room,@RequestParam Long time) {
        List<String> lista = new ArrayList<>();
        FindIterable<Document> finder = mongoTemplate.getCollection(room).find();
        if(year.equals("2013")) {
            finder = mongoTemplate2013.getCollection(room).find(Filters.and(Filters.gt("vrijeme" , time)));
        }else if(year.equals("2014")) {
            finder = mongoTemplate2014.getCollection(room).find(Filters.and(Filters.gt("vrijeme" , time)));
        }else if(year.equals("2015")) {
            finder = mongoTemplate2015.getCollection(room).find(Filters.and(Filters.gt("vrijeme" , time)));
        }else if(year.equals("2016")) {
            finder = mongoTemplate2016.getCollection(room).find(Filters.and(Filters.gt("vrijeme" , time)));
        }else if(year.equals("2017")) {
            finder = mongoTemplate2017.getCollection(room).find(Filters.and(Filters.gt("vrijeme" , time)));
        }else if(year.equals("2018")) {
            finder = mongoTemplate2018.getCollection(room).find(Filters.and(Filters.gt("vrijeme" , time)));
        }else if(year.equals("2019")) {
            finder = mongoTemplate2019.getCollection(room).find(Filters.and(Filters.gt("vrijeme" , time)));
        }else if(year.equals("2020")) {
            finder = mongoTemplate2020.getCollection(room).find(Filters.and(Filters.gt("vrijeme" , time)));
        }else if(year.equals("2021")) {
            finder = mongoTemplate2021.getCollection(room).find(Filters.and(Filters.gt("vrijeme" , time)));
        }else if(year.equals("2022")) {
            finder = mongoTemplate2022.getCollection(room).find(Filters.and(Filters.gt("vrijeme" , time)));
        }
        MongoCursor<Document> cursor = finder.iterator();
        try{
            while(cursor.hasNext()){
                lista.add(cursor.next().toString());
            }
        }finally{
            cursor.close();
        }
        return lista;
    }

    @GetMapping("/adria/filterByParam/{year}/{room}/")
    @ResponseBody
    public List<String> adriaAllSelectiveParam(@PathVariable String year , @PathVariable String room,@RequestParam String req,@RequestParam int param) {
        List<String> lista = new ArrayList<>();
        FindIterable<Document> finder = mongoTemplate.getCollection(room).find();
        if(year.equals("2013")) {
            finder = mongoTemplate2013.getCollection(room).find(Filters.and(Filters.eq(req , param)));
        }else if(year.equals("2014")) {
            finder = mongoTemplate2014.getCollection(room).find(Filters.and(Filters.gt(req, param)));
        }else if(year.equals("2015")) {
            finder = mongoTemplate2015.getCollection(room).find(Filters.and(Filters.gt(req , param)));
        }else if(year.equals("2016")) {
            finder = mongoTemplate2016.getCollection(room).find(Filters.and(Filters.gt(req , param)));
        }else if(year.equals("2017")) {
            finder = mongoTemplate2017.getCollection(room).find(Filters.and(Filters.gt(req , param)));
        }else if(year.equals("2018")) {
            finder = mongoTemplate2018.getCollection(room).find(Filters.and(Filters.gt(req, param)));
        }else if(year.equals("2019")) {
            finder = mongoTemplate2019.getCollection(room).find(Filters.and(Filters.gt(req , param)));
        }else if(year.equals("2020")) {
            finder = mongoTemplate2020.getCollection(room).find(Filters.and(Filters.gt(req , param)));
        }else if(year.equals("2021")) {
            finder = mongoTemplate2021.getCollection(room).find(Filters.and(Filters.gt(req , param)));
        }else if(year.equals("2022")) {
            finder = mongoTemplate2022.getCollection(room).find(Filters.and(Filters.gt(req, param)));
        }
        MongoCursor<Document> cursor = finder.iterator();
        try{
            while(cursor.hasNext()){
                lista.add(cursor.next().toString());
            }
        }finally{
            cursor.close();
        }
        return lista;
    }
    @GetMapping("/adria/{room}")
    @ResponseBody
    public String adriaAllSelectiveParam(@PathVariable String room) {
        List<String> lista = new ArrayList<>();
        return mongoTemplate.getCollection(room).find().sort(Sorts.descending("vrijeme")).first().toString();
    }
}
