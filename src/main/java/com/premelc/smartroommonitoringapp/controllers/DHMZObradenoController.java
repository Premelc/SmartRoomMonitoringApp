package com.premelc.smartroommonitoringapp.controllers;

import com.premelc.smartroommonitoringapp.models.*;
import com.premelc.smartroommonitoringapp.repositories.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class DHMZObradenoController {

    @Autowired
    DHMZObradenoRepository repository;

    @GetMapping("/DHMZObradeno")
    public String DHMZObradenoBasic(){
        return "DHMZObradeno basic";
    }

    @GetMapping("/dhmzid")
    public DHMZObradeno dhmzid(){
        return repository.findOneBy_id("62P2yVSD2lP9IV4H2nPTjE16");
    }

    @GetMapping("/all")
    public List<DHMZObradeno> all(){
        return repository.findAll();
    }

    @GetMapping("/counter")
    public long counter(){
        return repository.count();
    }

}
