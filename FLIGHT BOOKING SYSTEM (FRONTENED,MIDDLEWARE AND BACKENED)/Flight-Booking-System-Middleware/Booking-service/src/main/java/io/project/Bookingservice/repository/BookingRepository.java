package io.project.Bookingservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.project.Bookingservice.models.PassengerDetails;



@Repository
public interface BookingRepository extends  MongoRepository<PassengerDetails, String> {

}
