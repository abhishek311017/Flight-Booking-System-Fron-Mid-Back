package io.project.SearchService.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.project.SearchService.models.Flight;
import io.project.SearchService.service.SearchService;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/Search")
@CrossOrigin("*")
public class SearchController {

	@Autowired
	private SearchService repo;

	@GetMapping("/findAllFlight")
	@ApiOperation(value="Search list Of Flights",notes="Search all the available flight details")
	public List<Flight> getFlights() {
		return repo.getAllFlights();
	}

	// find flight details by flight number
	@GetMapping("/findAllFlight/GetByFlightNumber/{flight_num}")
	@ApiOperation(value="Search Flights by flight number",notes="Search all the available flight details of specific flight using flight number")
	public List<Flight> getFlightByFlightNumber(@PathVariable String flight_num) {
		return repo.getFlightByFlight_Number(flight_num);
	}

	// find flight details by flight name
	@GetMapping("/findAllFlight/GetByFlightName/{flight_nam}")
	@ApiOperation(value="Search Flights by flight name",notes="Search all the available flight details of specific flight using flight name")
	public List<Flight> getFlightByFlightName(@PathVariable String flight_nam) {
		return repo.getFlightByFlight_Name(flight_nam);
	}
    //find flight details by source and destination
	@GetMapping("/{source}/to/{destination}")
	@ApiOperation(value="Search Flights by source and destination",notes="Search all the available flight details of specific flight using source and destination of flight")
	public List<Flight> getTrainDetailsByStartStation(@PathVariable String source, @PathVariable String destination) {
		return repo.getFlightDetailsBySourceToDest(source, destination);
	}
    //find flight details by date of travel
	@GetMapping("/findAllFlight/{dot}")
	@ApiOperation(value="Search Flights by flight's date of travel",notes="Search all the available flight details of specific flight using flight's date of travel ")
	public List<Flight> getFlightByDateOfTravel(@PathVariable String dot) {
		return repo.getFlightByDate_Of_Travel(dot);
	}

	

}








