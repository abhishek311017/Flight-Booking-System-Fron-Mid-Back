package io.project.Bookingservice.service;


import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import io.project.Bookingservice.models.DbSequence;
import io.project.Bookingservice.models.PassengerDetails;
import io.project.Bookingservice.repository.BookingRepository;



@Service
public class BookingService {
	
	
	@Autowired
	BookingRepository userRepo;
	private BookingService(MongoOperations mongo) {
		BookingService.mongoOperations=mongo;
	}
	
	@Autowired
	private static MongoOperations mongoOperations;
	
	//int random_int = (int)Math.floor(Math.random()*(99));
	public static int getNextSequence(String key)  {
		  DbSequence dbSeq=mongoOperations.findAndModify(query(where("reference_num").is(key)), 
				  new Update().inc("seq",1), options().returnNew(true).upsert(true),
				  DbSequence.class); 
		  return !Objects.isNull(dbSeq) ? dbSeq.getSeq() : 1;
		  } 
	
	
	public String addUserBookingDetails(PassengerDetails passengerDetails) {
		userRepo.save(passengerDetails);	
		return ("Your ticket booked successfully...!!!  "
				+ "Your reference number is "+ passengerDetails.getReference_num() + " Please proceed to payment....");
	}
}
