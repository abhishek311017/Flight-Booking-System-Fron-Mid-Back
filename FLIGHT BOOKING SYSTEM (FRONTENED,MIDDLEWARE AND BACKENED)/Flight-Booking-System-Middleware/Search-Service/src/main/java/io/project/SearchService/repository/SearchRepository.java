package io.project.SearchService.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import io.project.SearchService.models.Flight;


@Repository
public interface SearchRepository extends MongoRepository<Flight, String> {
	@Query("{'flight_number' : ?0}")
	public List<Flight> findByFlight_Number(String flight_number);

	@Query(value = "{'flight_number' : ?0}", delete = true)
	public void deleteByFlight_Number(String flight_number);

	@Query("{'flight_name' : ?0}")
	public List<Flight> findByFlight_Name(String flight_name);

	@Query("{'date_of_travel' : ?0}")
	public List<Flight> findByDate_Of_Travel(String dot);
	@Query("{'traveling_from' : ?0,'traveling_to' : ?1}")
	public List<Flight> getFlightDetailsBySourceToDest(String source, String destination);
}
