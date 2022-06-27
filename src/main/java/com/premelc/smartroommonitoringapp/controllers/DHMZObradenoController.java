package com.premelc.smartroommonitoringapp.controllers;

import com.mongodb.client.*;
import com.mongodb.client.model.*;
import com.premelc.smartroommonitoringapp.models.*;
import com.premelc.smartroommonitoringapp.repositories.*;
import org.bson.*;
import org.bson.conversions.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.mongodb.client.model.Filters.*;

@RestController
public class DHMZObradenoController {

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

    @Autowired
    DHMZObradenoRepository repository;

    @GetMapping("/DHMZObradeno")
    public String DHMZObradenoBasic() {
        return "DHMZObradeno basic";
    }

    @GetMapping("/dhmzid")
    public DHMZObradeno dhmzid() {
        return repository.findOneBy_id("62P2yVSD2lP9IV4H2nPTjE16");
    }

    @GetMapping("/all")
    public List<DHMZObradeno> all() {
        return repository.findAll();
    }

    @GetMapping("/counter")
    public long counter() {
        return repository.count();
    }

    @GetMapping("/dhmz/latest")
    @ResponseBody
    public Document DHMZLatestTime() {
        return mongoTemplate.getCollection("DHMZObradeno").find().sort(Sorts.descending("vrijeme")).first();
    }

    @GetMapping("/dhmz/from/{time}")
    @ResponseBody
    public List<String> dhmzAllAfter(@PathVariable Long time) {
        List<String> lista = new ArrayList<>();
        long god = (time / 31556952000L) + 1970;
        String year = Long.toString(god);
        FindIterable<Document> finder = mongoTemplate.getCollection("DHMZObradeno").find();
        if ((Integer.parseInt(year) < currentYear)) {
            for (int i = Integer.parseInt(year); i <= currentYear; i++) {
                if (i == 2013) {
                    finder = mongoTemplate2013.getCollection("DHMZObradeno").find(and(gte("vrijeme", time)));
                } else if (i == 2014) {
                    finder = mongoTemplate2014.getCollection("DHMZObradeno").find(and(gte("vrijeme", time)));
                } else if (i == 2015) {
                    finder = mongoTemplate2015.getCollection("DHMZObradeno").find(and(gte("vrijeme", time)));
                } else if (i == 2016) {
                    finder = mongoTemplate2016.getCollection("DHMZObradeno").find(and(gte("vrijeme", time)));
                } else if (i == 2017) {
                    finder = mongoTemplate2017.getCollection("DHMZObradeno").find(and(gte("vrijeme", time)));
                } else if (i == 2018) {
                    finder = mongoTemplate2018.getCollection("DHMZObradeno").find(and(gte("vrijeme", time)));
                } else if (i == 2019) {
                    finder = mongoTemplate2019.getCollection("DHMZObradeno").find(and(gte("vrijeme", time)));
                } else if (i == 2020) {
                    finder = mongoTemplate2020.getCollection("DHMZObradeno").find(and(gte("vrijeme", time)));
                } else if (i == 2021) {
                    finder = mongoTemplate2021.getCollection("DHMZObradeno").find(and(gte("vrijeme", time)));
                } else if (i == 2022) {
                    finder = mongoTemplate2022.getCollection("DHMZObradeno").find(and(gte("vrijeme", time)));
                }
                MongoCursor<Document> cursor = finder.iterator();
                try {
                    while (cursor.hasNext()) {
                        lista.add(cursor.next().toString());
                    }
                } finally {
                    cursor.close();
                }
            }
        }
        return lista;
    }

    @GetMapping("/dhmz/from/{timeFrom}/to/{timeTo}")
    @ResponseBody
    public List<String> dhmzAllBetween(@PathVariable Long timeFrom, @PathVariable Long timeTo) {
        List<String> lista = new ArrayList<>();
        long godOd = (timeFrom / 31556952000L) + 1970;
        long godDo = (timeTo / 31556952000L) + 1970;
        System.out.println("godine od: " + godOd + " Godine do: " + godDo);

        FindIterable<Document> finder = mongoTemplate.getCollection("DHMZObradeno").find();
        if ((godOd <= godDo)) {
            for (long i = godOd; i <= godDo; i++) {
                if (i == 2013) {
                    finder = mongoTemplate2013.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo)));
                } else if (i == 2014) {
                    finder = mongoTemplate2014.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo)));
                } else if (i == 2015) {
                    finder = mongoTemplate2015.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo)));
                } else if (i == 2016) {
                    finder = mongoTemplate2016.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo)));
                } else if (i == 2017) {
                    finder = mongoTemplate2017.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo)));
                } else if (i == 2018) {
                    finder = mongoTemplate2018.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo)));
                } else if (i == 2019) {
                    finder = mongoTemplate2019.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo)));
                } else if (i == 2020) {
                    finder = mongoTemplate2020.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo)));
                } else if (i == 2021) {
                    finder = mongoTemplate2021.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo)));
                } else if (i == 2022) {
                    finder = mongoTemplate2022.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo)));
                }
                MongoCursor<Document> cursor = finder.iterator();
                try {
                    while (cursor.hasNext()) {
                        lista.add(cursor.next().toString());
                    }
                } finally {
                    cursor.close();
                }
            }
        }
        return lista;
    }

    @GetMapping("/dhmz/at/{time}")
    @ResponseBody
    public List<String> dhmzOnDay(@PathVariable Long time) {
        List<String> lista = new ArrayList<>();
        long god = (time / 31556952000L) + 1970;

        System.out.println("godine od: " + god);

        FindIterable<Document> finder = mongoTemplate.getCollection("DHMZObradeno").find();
        if ((god <= currentYear)) {
            for (long i = god; i <= currentYear; i++) {
                if (i == 2013) {
                    finder = mongoTemplate2013.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", time), Filters.lte("vrijeme", (time + 86400000))));
                } else if (i == 2014) {
                    finder = mongoTemplate2014.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", time), Filters.lte("vrijeme", (time + 86400000))));
                } else if (i == 2015) {
                    finder = mongoTemplate2015.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", time), Filters.lte("vrijeme", (time + 86400000))));
                } else if (i == 2016) {
                    finder = mongoTemplate2016.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", time), Filters.lte("vrijeme", (time + 86400000))));
                } else if (i == 2017) {
                    finder = mongoTemplate2017.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", time), Filters.lte("vrijeme", (time + 86400000))));
                } else if (i == 2018) {
                    finder = mongoTemplate2018.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", time), Filters.lte("vrijeme", (time + 86400000))));
                } else if (i == 2019) {
                    finder = mongoTemplate2019.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", time), Filters.lte("vrijeme", (time + 86400000))));
                } else if (i == 2020) {
                    finder = mongoTemplate2020.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", time), Filters.lte("vrijeme", (time + 86400000))));
                } else if (i == 2021) {
                    finder = mongoTemplate2021.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", time), Filters.lte("vrijeme", (time + 86400000))));
                } else if (i == 2022) {
                    finder = mongoTemplate2022.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", time), Filters.lte("vrijeme", (time + 86400000))));
                }
                MongoCursor<Document> cursor = finder.iterator();
                try {
                    while (cursor.hasNext()) {
                        lista.add(cursor.next().toString());
                    }
                } finally {
                    cursor.close();
                }
            }
        }
        return lista;
    }

    @GetMapping("/dhmz/circa/{time}")
    @ResponseBody
    public String dhmzAroundTime(@PathVariable Long time) {
        long god = (time / 31556952000L) + 1970;
        System.out.println("godine od: " + god);
        Document finder = null;
        if ((god <= currentYear)) {
            for (long i = god; i <= currentYear; i++) {
                if (i == 2013) {
                    finder = mongoTemplate2013.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", time - 3600000), Filters.lte("vrijeme", (time + 3600000)))).sort(Sorts.ascending("vrijeme")).first();
                } else if (i == 2014) {
                    finder = mongoTemplate2014.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", time - 3600000), Filters.lte("vrijeme", (time + 3600000)))).sort(Sorts.ascending("vrijeme")).first();
                } else if (i == 2015) {
                    finder = mongoTemplate2015.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", time - 3600000), Filters.lte("vrijeme", (time + 3600000)))).sort(Sorts.ascending("vrijeme")).first();
                } else if (i == 2016) {
                    finder = mongoTemplate2016.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", time - 3600000), Filters.lte("vrijeme", (time + 3600000)))).sort(Sorts.ascending("vrijeme")).first();
                } else if (i == 2017) {
                    finder = mongoTemplate2017.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", time - 3600000), Filters.lte("vrijeme", (time + 3600000)))).sort(Sorts.ascending("vrijeme")).first();
                } else if (i == 2018) {
                    finder = mongoTemplate2018.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", time - 3600000), Filters.lte("vrijeme", (time + 3600000)))).sort(Sorts.ascending("vrijeme")).first();
                } else if (i == 2019) {
                    finder = mongoTemplate2019.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", time - 3600000), Filters.lte("vrijeme", (time + 3600000)))).sort(Sorts.ascending("vrijeme")).first();
                } else if (i == 2020) {
                    finder = mongoTemplate2020.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", time - 3600000), Filters.lte("vrijeme", (time + 3600000)))).sort(Sorts.ascending("vrijeme")).first();
                } else if (i == 2021) {
                    finder = mongoTemplate2021.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", time - 3600000), Filters.lte("vrijeme", (time + 3600000)))).sort(Sorts.ascending("vrijeme")).first();
                } else if (i == 2022) {
                    finder = mongoTemplate2022.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", time - 3600000), Filters.lte("vrijeme", (time + 3600000)))).sort(Sorts.ascending("vrijeme")).first();
                }
                return finder.toJson();
            }
        }
        return "empty";
    }
    //http://localhost:8080/dhmz/range/1362577200000/1609463100000
    @GetMapping("/dhmz/range/{timeFrom}/{timeTo}")
    @ResponseBody
    public List<String> dhmzOnDayOnlyTime(@PathVariable Long timeFrom, @PathVariable Long timeTo) {
        List<String> lista = new ArrayList<>();
        long god = (timeFrom / 31556952000L) + 1970;
        System.out.println("godina: " + god);
        FindIterable<Document> finder = mongoTemplate.getCollection("DHMZObradeno").find();
        if((god <= currentYear)) {
            for (long i = god; i <= currentYear; i++) {
                if (i == 2013) {
                    finder = mongoTemplate2013.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" ) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2014) {
                    finder = mongoTemplate2014.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme") , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2015) {
                    finder = mongoTemplate2015.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" ) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2016) {
                    finder = mongoTemplate2016.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" ) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2017) {
                    finder = mongoTemplate2017.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" ) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2018) {
                    finder = mongoTemplate2018.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" ) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2019) {
                    finder = mongoTemplate2019.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme") , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2020) {
                    finder = mongoTemplate2020.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme") , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2021) {
                    finder = mongoTemplate2021.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme") , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2022) {
                    finder = mongoTemplate2022.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" ) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
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

    @GetMapping("/dhmz/{field}/range/{timeFrom}/{timeTo}")
    @ResponseBody
    public List<String> dhmzReadingInRange(@PathVariable String field , @PathVariable Long timeFrom, @PathVariable Long timeTo ) {
        List<String> lista = new ArrayList<>();
        long god = (timeFrom / 31556952000L) + 1970;
        System.out.println("godina: " + god);
        FindIterable<Document> finder = mongoTemplate.getCollection("DHMZObradeno").find();
        if((god <= currentYear)) {
            for (long i = god; i <= currentYear; i++) {
                if (i == 2013) {
                    finder = mongoTemplate2013.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" , field) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2014) {
                    finder = mongoTemplate2014.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" , field) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2015) {
                    finder = mongoTemplate2015.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" , field) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2016) {
                    finder = mongoTemplate2016.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" , field) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2017) {
                    finder = mongoTemplate2017.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" , field) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2018) {
                    finder = mongoTemplate2018.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" , field) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2019) {
                    finder = mongoTemplate2019.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" , field) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2020) {
                    finder = mongoTemplate2020.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" , field) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2021) {
                    finder = mongoTemplate2021.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" , field) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
                } else if (i == 2022) {
                    finder = mongoTemplate2022.getCollection("DHMZObradeno").find(Filters.and(Filters.gte("vrijeme", timeFrom), Filters.lte("vrijeme", timeTo))).projection(Projections.fields(Projections.include("vrijeme" , field) , Projections.excludeId())).sort(Sorts.descending("vrijeme"));
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

    @GetMapping("/dhmz/{time}")
    @ResponseBody
    public String dhmzSpecificTime(@PathVariable Long time) {
        long god = (time / 31556952000L) + 1970;
        System.out.println("godine od: " + god);
        Document finder = null;
        if ((god <= currentYear)) {
            for (long i = god; i <= currentYear; i++) {
                if (i == 2013) {
                    finder = mongoTemplate2013.getCollection("DHMZObradeno").find(Filters.and(Filters.eq("vrijeme", time))).sort(Sorts.ascending("vrijeme")).first();
                } else if (i == 2014) {
                    finder = mongoTemplate2014.getCollection("DHMZObradeno").find(Filters.and(Filters.eq("vrijeme", time))).sort(Sorts.ascending("vrijeme")).first();
                } else if (i == 2015) {
                    finder = mongoTemplate2015.getCollection("DHMZObradeno").find(Filters.and(Filters.eq("vrijeme", time))).sort(Sorts.ascending("vrijeme")).first();
                } else if (i == 2016) {
                    finder = mongoTemplate2016.getCollection("DHMZObradeno").find(Filters.and(Filters.eq("vrijeme", time))).sort(Sorts.ascending("vrijeme")).first();
                } else if (i == 2017) {
                    finder = mongoTemplate2017.getCollection("DHMZObradeno").find(Filters.and(Filters.eq("vrijeme", time))).sort(Sorts.ascending("vrijeme")).first();
                } else if (i == 2018) {
                    finder = mongoTemplate2018.getCollection("DHMZObradeno").find(Filters.and(Filters.eq("vrijeme", time))).sort(Sorts.ascending("vrijeme")).first();
                } else if (i == 2019) {
                    finder = mongoTemplate2019.getCollection("DHMZObradeno").find(Filters.and(Filters.eq("vrijeme", time))).sort(Sorts.ascending("vrijeme")).first();
                } else if (i == 2020) {
                    finder = mongoTemplate2020.getCollection("DHMZObradeno").find(Filters.and(Filters.eq("vrijeme", time))).sort(Sorts.ascending("vrijeme")).first();
                } else if (i == 2021) {
                    finder = mongoTemplate2021.getCollection("DHMZObradeno").find(Filters.and(Filters.eq("vrijeme", time))).sort(Sorts.ascending("vrijeme")).first();
                } else if (i == 2022) {
                    finder = mongoTemplate2022.getCollection("DHMZObradeno").find(Filters.and(Filters.eq("vrijeme", time))).sort(Sorts.ascending("vrijeme")).first();
                }
                return finder.toJson();
            }
        }
        return "empty";
    }

}

//3600000 razmak izmedju dhmz ocitanja u ms