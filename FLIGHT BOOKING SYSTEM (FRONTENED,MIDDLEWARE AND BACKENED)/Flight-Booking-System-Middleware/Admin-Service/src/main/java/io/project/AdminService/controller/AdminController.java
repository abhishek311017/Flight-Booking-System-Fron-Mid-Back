package io.project.AdminService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.project.AdminService.model.Flight;
import io.project.AdminService.model.Passenger;
import io.project.AdminService.service.AdminService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Admin")
@CrossOrigin("*")
public class AdminController {
	@Autowired
	private AdminService repo;
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/addFlight")
	@ApiOperation(value="Add a flight",notes="Through this admin can add a flight details")
	public String saveFlight(@RequestBody Flight flight) {
		repo.addFlight(flight);
		return flight.getId();
	}

	@GetMapping("/findAllFlight")
	@ApiOperation(value="Find the list Of Flights",notes="Print all the available flight details")
	public List<Flight> getFlights() {
		return repo.getAllFlights();
	}

	// find flight details by flight number
	@GetMapping("/findAllFlight/FindByFlightNumber/{flight_num}")
	@ApiOperation(value="Find the list Of Flights by flight number",notes="Print all the available flight details of specific flight using flight number")
	public Flight getFlightByFlightNumber(@PathVariable String flight_num) {
		return repo.getFlightByFlight_Number(flight_num);
	}

	// find flight details by flight name
	@GetMapping("/findAllFlight/FindByFlightName/{flight_nam}")
	@ApiOperation(value="Find the list Of Flights by flight name",notes="Print all the available flight details of specific flight using flight name")
	public Flight getFlightByFlightName(@PathVariable String flight_nam) {
		return repo.getFlightByFlight_Name(flight_nam);
	}

	// find flight details by source and destination
	@GetMapping("/{source}/{destination}")
	@ApiOperation(value="Find the list Of Flights by source and destination",notes="Print all the available flight details of specific flight using source and destination of flight")
	public List<Flight> getTrainDetailsByStartStation(@PathVariable String source, @PathVariable String destination) {
		return repo.getFlightDetailsBySourceToDest(source, destination);
	}

	// find flight details by date of travel
	@GetMapping("/findAllFlight/{dot}")
	@ApiOperation(value="Find the list Of Flights by flight's date of travel",notes="Print all the available flight details of specific flight using flight's date of travel ")
	public List<Flight> getFlightByDateOfTravel(@PathVariable String dot) {
		return repo.getFlightByDate_Of_Travel(dot);
	}

	@DeleteMapping("/delete/{flight_num}")
	@ApiOperation(value="Delete a flight",notes="Through this admin can delete the flight")
	public void deleteFlight(@PathVariable String flight_num) {
		repo.deleteFlight(flight_num);

	}

	@PutMapping("/update/{flight_number}")
	@ApiOperation(value="Update a flight",notes="Through this admin can update the flight")
	public Flight updateFlight(@PathVariable String flight_number, @RequestBody Flight flight) {
		return repo.updateFlight(flight_number, flight);

	}
	
	@GetMapping("/findAllPassenger")
	@ApiOperation(value="Find the list Of passenger",notes="Through this admin can see all the passenger details")
	public Passenger[] getPassenger() {
		
		Passenger[] response = restTemplate.getForObject("http://localhost:8081/Passenger/findAll", Passenger[].class);
			return  response;
		}

}
