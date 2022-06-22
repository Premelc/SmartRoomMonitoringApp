package com.premelc.smartroommonitoringapp.repositories;

import com.premelc.smartroommonitoringapp.models.*;
import org.springframework.data.mongodb.repository.*;
import org.springframework.data.rest.core.annotation.*;

import java.util.*;

@RepositoryRestResource(collectionResourceRel = "dhmzObradeno", path = "dhmzObradeno")
public interface DHMZObradenoRepository extends MongoRepository<DHMZObradeno, String> {

    public DHMZObradeno findOneBy_id(String id);
    public List<DHMZObradeno> findAll();
    public DHMZObradeno findOneByVrijemeGreaterThanEqual(double vrijeme);

    public long count();
}
