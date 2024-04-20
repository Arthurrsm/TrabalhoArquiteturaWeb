package com.example.Rest_ApiFipe.repository;

import com.example.Rest_ApiFipe.model.RestApiFipeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestApiFipeRepository extends MongoRepository<RestApiFipeEntity, String>{
}
