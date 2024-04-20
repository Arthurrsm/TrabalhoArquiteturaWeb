package com.example.ClimaApi.repository;

import com.example.ClimaApi.model.ClimaApiEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimaApiRepository extends MongoRepository<ClimaApiEntity, String> {
}
