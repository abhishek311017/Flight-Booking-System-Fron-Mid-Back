package io.project.CheckInService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.project.CheckInService.models.PassengerDetails;
@Repository
public interface CheckinRepository extends MongoRepository<PassengerDetails,String> {

	PassengerDetails findByReferenceNum(int referenceNum);

}
