package com.premelc.smartroommonitoringapp.controllers;

import com.mongodb.client.*;
import com.mongodb.client.model.*;
import com.premelc.smartroommonitoringapp.DTOs.AdriaIndoorDTOs.*;
import org.bson.*;
import org.bson.conversions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AdriaIndoorController {

    public static final int currentYear = 2021;

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
                lista.add(cursor.next().toJson());
            }
        }finally{
            cursor.close();
        }
        return lista;
    }


    @GetMapping("/adria/from/{time}/{room}")
    @ResponseBody
    public List<String> adriaAllAfter(@PathVariable String room,@PathVariable Long time) {
        List<String> lista = new ArrayList<>();
        long god = (time / 31556952000L) + 1970;
        String year = Long.toString(god);
        FindIterable<Document> finder = mongoTemplate.getCollection(room).find();
        if((Integer.parseInt(year) < currentYear)){
            for(int i = Integer.parseInt(year) ; i<= currentYear ; i++){
                if(i == 2013) {
                    finder = mongoTemplate2013.getCollection(room).find(Filters.and(Filters.gte("vrijeme" , time)));
                }else if(i == 2014) {
                    finder = mongoTemplate2014.getCollection(room).find(Filters.and(Filters.gte("vrijeme" , time)));
                }else if(i == 2015) {
                    finder = mongoTemplate2015.getCollection(room).find(Filters.and(Filters.gte("vrijeme" , time)));
                }else if(i == 2016) {
                    finder = mongoTemplate2016.getCollection(room).find(Filters.and(Filters.gte("vrijeme" , time)));
                }else if(i == 2017) {
                    finder = mongoTemplate2017.getCollection(room).find(Filters.and(Filters.gte("vrijeme" , time)));
                }else if(i == 2018) {
                    finder = mongoTemplate2018.getCollection(room).find(Filters.and(Filters.gte("vrijeme" , time)));
                }else if(i == 2019) {
                    finder = mongoTemplate2019.getCollection(room).find(Filters.and(Filters.gte("vrijeme" , time)));
                }else if(i == 2020) {
                    finder = mongoTemplate2020.getCollection(room).find(Filters.and(Filters.gte("vrijeme" , time)));
                }else if(i == 2021) {
                    finder = mongoTemplate2021.getCollection(room).find(Filters.and(Filters.gte("vrijeme" , time)));
                }else if(i == 2022) {
                    finder = mongoTemplate2022.getCollection(room).find(Filters.and(Filters.gte("vrijeme" , time)));
                }
                MongoCursor<Document> cursor = finder.iterator();
                try{
                    while(cursor.hasNext()){
                        /*adriaRoomAllDto novi = new adriaRoomAllDto(cursor.next());
                        lista.add(novi);*/
                        lista.add(cursor.next().toJson());
                    }
                }finally{
                    cursor.close();
                }
            }
        }
        return lista;
    }

    @GetMapping("/adria/from/{timeFrom}/to/{timeTo}/{room}")
    @ResponseBody
    public List<String> adriaAllAfterAndBefore(@PathVariable String room,@PathVariable Long timeFrom , @PathVariable Long timeTo) {
        List<String> lista = new ArrayList<>();
        long godOd = (timeFrom / 31556952000L) + 1970;
        long godDo = (timeTo / 31556952000L) + 1970;
        System.out.println("godine od: " + godOd+" Godine do: " + godDo );
        FindIterable<Document> finder = mongoTemplate.getCollection(room).find();
        if((godOd <= godDo)) {
            for (long i = godOd; i <= godDo; i++) {
                if (i == 2013) {
                    finder = mongoTemplate2013.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo)));
                } else if (i == 2014) {
                    finder = mongoTemplate2014.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo)));
                } else if (i == 2015) {
                    finder = mongoTemplate2015.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo)));
                } else if (i == 2016) {
                    finder = mongoTemplate2016.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo)));
                } else if (i == 2017) {
                    finder = mongoTemplate2017.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo)));
                } else if (i == 2018) {
                    finder = mongoTemplate2018.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo)));
                } else if (i == 2019) {
                    finder = mongoTemplate2019.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo)));
                } else if (i == 2020) {
                    finder = mongoTemplate2020.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo)));
                } else if (i == 2021) {
                    finder = mongoTemplate2021.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo)));
                } else if (i == 2022) {
                    finder = mongoTemplate2022.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo)));
                }
                MongoCursor<Document> cursor = finder.iterator();
                try {
                    while (cursor.hasNext()) {
                        lista.add(cursor.next().toJson());
                    }
                } finally {
                    cursor.close();
                }
            }
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
                lista.add(cursor.next().toJson());
            }
        }finally{
            cursor.close();
        }
        return lista;
    }

    @GetMapping("/adria/{room}")
    @ResponseBody
    public Document adriaLatestRoomStatus(@PathVariable String room) {
        return mongoTemplate.getCollection(room).find().sort(Sorts.descending("vrijeme")).first();
    }

    @GetMapping("/adria/{room}/{time}")
    @ResponseBody
    public List<String> adriaExactRoomReading(@PathVariable String room , @PathVariable Long time) {
        List<String> lista = new ArrayList<>();
        long god = (time / 31556952000L) + 1970;
        System.out.println("godina: " + god);
        FindIterable<Document> finder = mongoTemplate.getCollection(room).find();
        if((god <= currentYear)) {
            for (long i = god; i <= currentYear; i++) {
                if (i == 2013) {
                    finder = mongoTemplate2013.getCollection(room).find(Filters.and(Filters.eq("vrijeme" , time)));
                } else if (i == 2014) {
                    finder = mongoTemplate2014.getCollection(room).find(Filters.and(Filters.eq("vrijeme" , time)));
                } else if (i == 2015) {
                    finder = mongoTemplate2015.getCollection(room).find(Filters.and(Filters.eq("vrijeme" , time)));
                } else if (i == 2016) {
                    finder = mongoTemplate2016.getCollection(room).find(Filters.and(Filters.eq("vrijeme" , time)));
                } else if (i == 2017) {
                    finder = mongoTemplate2017.getCollection(room).find(Filters.and(Filters.eq("vrijeme" , time)));
                } else if (i == 2018) {
                    finder = mongoTemplate2018.getCollection(room).find(Filters.and(Filters.eq("vrijeme" , time)));
                } else if (i == 2019) {
                    finder = mongoTemplate2019.getCollection(room).find(Filters.and(Filters.eq("vrijeme" , time)));
                } else if (i == 2020) {
                    finder = mongoTemplate2020.getCollection(room).find(Filters.and(Filters.eq("vrijeme" , time)));
                } else if (i == 2021) {
                    finder = mongoTemplate2021.getCollection(room).find(Filters.and(Filters.eq("vrijeme" , time)));
                } else if (i == 2022) {
                    finder = mongoTemplate2022.getCollection(room).find(Filters.and(Filters.eq("vrijeme" , time)));
                }
                MongoCursor<Document> cursor = finder.iterator();
                try {
                    while (cursor.hasNext()) {
                        lista.add(cursor.next().toJson());
                    }
                } finally {
                    cursor.close();
                }
            }
        }
        return lista;
    }

    //288 ocitanja dnevno
    @GetMapping("/adria/{room}/at/{time}")
    @ResponseBody
    public List<String> adriaRoomOnDay(@PathVariable String room,@PathVariable Long time ) {
        List<String> lista = new ArrayList<>();
        long god = (time / 31556952000L) + 1970;
        System.out.println("godina: " + god);
        FindIterable<Document> finder = mongoTemplate.getCollection(room).find();
        if((god <= currentYear)) {
            for (long i = god; i <= currentYear; i++) {
                if (i == 2013) {
                    finder = mongoTemplate2013.getCollection(room).find(Filters.and(Filters.gte("vrijeme", time), Filters.lte("vrijeme", (time + 86400000)))).sort(Sorts.descending("vrijeme"));
                } else if (i == 2014) {
                    finder = mongoTemplate2014.getCollection(room).find(Filters.and(Filters.gte("vrijeme", time), Filters.lte("vrijeme", (time + 86400000)))).sort(Sorts.descending("vrijeme"));
                } else if (i == 2015) {
                    finder = mongoTemplate2015.getCollection(room).find(Filters.and(Filters.gte("vrijeme", time), Filters.lte("vrijeme", (time + 86400000)))).sort(Sorts.descending("vrijeme"));
                } else if (i == 2016) {
                    finder = mongoTemplate2016.getCollection(room).find(Filters.and(Filters.gte("vrijeme", time), Filters.lte("vrijeme", (time + 86400000)))).sort(Sorts.descending("vrijeme"));
                } else if (i == 2017) {
                    finder = mongoTemplate2017.getCollection(room).find(Filters.and(Filters.gte("vrijeme", time), Filters.lte("vrijeme", (time + 86400000)))).sort(Sorts.descending("vrijeme"));
                } else if (i == 2018) {
                    finder = mongoTemplate2018.getCollection(room).find(Filters.and(Filters.gte("vrijeme", time), Filters.lte("vrijeme", (time + 86400000)))).sort(Sorts.descending("vrijeme"));
                } else if (i == 2019) {
                    finder = mongoTemplate2019.getCollection(room).find(Filters.and(Filters.gte("vrijeme", time), Filters.lte("vrijeme", (time + 86400000)))).sort(Sorts.descending("vrijeme"));
                } else if (i == 2020) {
                    finder = mongoTemplate2020.getCollection(room).find(Filters.and(Filters.gte("vrijeme", time), Filters.lte("vrijeme", (time + 86400000)))).sort(Sorts.descending("vrijeme"));
                } else if (i == 2021) {
                    finder = mongoTemplate2021.getCollection(room).find(Filters.and(Filters.gte("vrijeme", time), Filters.lte("vrijeme", (time + 86400000)))).sort(Sorts.descending("vrijeme"));
                } else if (i == 2022) {
                    finder = mongoTemplate2022.getCollection(room).find(Filters.and(Filters.gte("vrijeme", time), Filters.lte("vrijeme", (time + 86400000)))).sort(Sorts.descending("vrijeme"));
                }
                MongoCursor<Document> cursor = finder.iterator();
                try {
                    while (cursor.hasNext()) {

                        lista.add(cursor.next().toJson());
                        System.out.println(lista.get(lista.size()-1));
                    }
                } finally {
                    cursor.close();
                }
            }
        }
        return lista;
    }

    @GetMapping("/adria/{room}/{field}/range/{timeFrom}/{timeTo}")
    @ResponseBody
    public List<String> adriaRoomOnDay(@PathVariable String room, @PathVariable String field , @PathVariable Long timeFrom, @PathVariable Long timeTo ) {
        List<String> lista = new ArrayList<>();
        long god = (timeFrom / 31556952000L) + 1970;
        System.out.println("godina: " + god);
        FindIterable<Document> finder = mongoTemplate.getCollection(room).find();
        if((god <= currentYear)) {
            for (long i = god; i <= currentYear; i++) {
                if (i == 2013) {
                    finder = mongoTemplate2013.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" , field) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2014) {
                    finder = mongoTemplate2014.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" , field) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2015) {
                    finder = mongoTemplate2015.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" , field) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2016) {
                    finder = mongoTemplate2016.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" , field) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2017) {
                    finder = mongoTemplate2017.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" , field) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2018) {
                    finder = mongoTemplate2018.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" , field) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2019) {
                    finder = mongoTemplate2019.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" , field) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2020) {
                    finder = mongoTemplate2020.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" , field) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2021) {
                    finder = mongoTemplate2021.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" , field) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2022) {
                    finder = mongoTemplate2022.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" , field) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                }
                MongoCursor<Document> cursor = finder.iterator();
                try {
                    while (cursor.hasNext()) {

                        lista.add(cursor.next().toJson());
                        System.out.println(lista.get(lista.size()-1));
                    }
                } finally {
                    cursor.close();
                }
            }
        }
        return lista;
    }

    @GetMapping("/adria/{room}/range/{timeFrom}/{timeTo}")
    @ResponseBody
    public List<String> adriaRoomOnDayOnlyTime(@PathVariable String room, @PathVariable Long timeFrom, @PathVariable Long timeTo ) {
        List<String> lista = new ArrayList<>();
        long god = (timeFrom / 31556952000L) + 1970;
        System.out.println("godina: " + god);
        FindIterable<Document> finder = mongoTemplate.getCollection(room).find();
        if((god <= currentYear)) {
            for (long i = god; i <= currentYear; i++) {
                if (i == 2013) {
                    finder = mongoTemplate2013.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" ) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2014) {
                    finder = mongoTemplate2014.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme") , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2015) {
                    finder = mongoTemplate2015.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" ) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2016) {
                    finder = mongoTemplate2016.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" ) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2017) {
                    finder = mongoTemplate2017.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" ) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2018) {
                    finder = mongoTemplate2018.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" ) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2019) {
                    finder = mongoTemplate2019.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme") , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2020) {
                    finder = mongoTemplate2020.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme") , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2021) {
                    finder = mongoTemplate2021.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme") , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2022) {
                    finder = mongoTemplate2022.getCollection(room).find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" ) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                }
                MongoCursor<Document> cursor = finder.iterator();
                try {
                    while (cursor.hasNext()) {

                        lista.add(cursor.next().toJson());
                        System.out.println(lista.get(lista.size()-1));
                    }
                } finally {
                    cursor.close();
                }
            }
        }
        return lista;
    }

}
