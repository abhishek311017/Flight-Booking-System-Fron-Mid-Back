package io.project.Passengerservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.project.Passengerservice.models.Passenger;
@Repository
public interface PassengerRepository extends MongoRepository<Passenger,String>{

}
