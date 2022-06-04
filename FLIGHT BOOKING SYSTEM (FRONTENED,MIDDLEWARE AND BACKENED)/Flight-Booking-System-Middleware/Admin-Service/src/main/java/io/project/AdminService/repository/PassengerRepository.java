package io.project.AdminService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.project.AdminService.model.Passenger;


@Repository
public interface PassengerRepository extends MongoRepository<Passenger,String>{

}
