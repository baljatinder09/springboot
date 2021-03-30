package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.President;


@RepositoryRestResource(path="data", collectionResourceRel="data")
public interface PresidentRepository extends CrudRepository<President, Long	>
{

}
