package com.premelc.smartroommonitoringapp.repositories;


import com.premelc.smartroommonitoringapp.models.AdriaIndoor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@RepositoryRestResource
public interface AdriaIndoorRepository extends MongoRepository<AdriaIndoor,ObjectId> {

    List<AdriaIndoor>findAll();
    List<AdriaIndoor>findAllByVrijemeAfter(long vrijeme);
    AdriaIndoor findAdriaIndoorById(ObjectId id);

    long count();
}
