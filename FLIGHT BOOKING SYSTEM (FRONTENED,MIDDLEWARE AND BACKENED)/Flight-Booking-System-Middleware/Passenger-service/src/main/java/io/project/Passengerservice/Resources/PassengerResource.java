package io.project.Passengerservice.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.project.Passengerservice.Repository.PassengerRepository;
import io.project.Passengerservice.models.Flight;
import io.project.Passengerservice.models.Passenger;
import io.project.Passengerservice.models.PassengerDetails;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Passenger")
@CrossOrigin("*")
public class PassengerResource {

	@Autowired
	private PassengerRepository repo;
	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;
	@Autowired
	private RestTemplate restTemplates;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// returns list of flight
	@HystrixCommand(fallbackMethod = "getFallbackFlight")
	@GetMapping(value = "/findAllFlight")
	@ApiOperation(value = "Find the list Of Flights", notes = "Search all the available flight details")
	public Flight[] getFlight() {

		Flight[] response = restTemplate.getForObject("http://Search-service/Search/findAllFlight", Flight[].class);
		return response;
	}

	public Flight[] getFallbackFlight() {
		Flight[] response = { new Flight("", "", "", "", 0, 0, "", "", "", 0) };
		return response;

	}

	// find flight by flight Number
	@HystrixCommand(fallbackMethod = "getFallbackFlightByFlightNumber")
	@GetMapping(value = "/findAllFlight/{flightnumber}")
	@ApiOperation(value = "Find the list Of Flights by flight number", notes = "Search all the available flight details of specific flight using flight number")
	public Flight[] getFlightByFlightNumber(@PathVariable String flightnumber) {
		Flight[] response = restTemplate.getForObject(
				"http://Search-service/Search/findAllFlight/GetByFlightNumber/" + flightnumber, Flight[].class);
		return response;
	}

	public Flight[] getFallbackFlightByFlightNumber(@PathVariable String flightnumber) {
		Flight[] response = { new Flight("", "", "", "", 0, 0, "", "", "", 0) };
		return response;

	}

	// find flight by flight Name
	@HystrixCommand(fallbackMethod = "getFallbackFlightByFlightName")
	@GetMapping(value = "/findAllFlight/get/{flightname}")
	@ApiOperation(value = "Find the list Of Flights by flight name", notes = "Search all the available flight details of specific flight using flight name")
	public Flight[] getFlightByFlightName(@PathVariable String flightname) {
		Flight[] response = restTemplate.getForObject(
				"http://Search-service/Search/findAllFlight/GetByFlightName/" + flightname, Flight[].class);
		return response;
	}

	public Flight[] getFallbackFlightByFlightName(@PathVariable String flightname) {
		Flight[] response = { new Flight("", "", "", "", 0, 0, "", "", "", 0) };
		return response;

	}

	// find flight by date of travel
	@HystrixCommand(fallbackMethod = "getFallbackFlightByDOT")
	@GetMapping(value = "/findAllFlight/Date/{date_Of_Travel}")
	@ApiOperation(value = "Find the list Of Flights by flight's date of travel", notes = "Search all the available flight details of specific flight using flight's date of travel ")
	public Flight[] getFlightByDOT(@PathVariable String date_Of_Travel) {
		Flight[] response = restTemplate.getForObject("http://Search-service/Search/findAllFlight/" + date_Of_Travel,
				Flight[].class);
		return response;
	}

	public Flight[] getFallbackFlightByDOT(@PathVariable String date_Of_Travel) {
		Flight[] response = { new Flight("", "", "", "", 0, 0, "", "", "", 0) };
		return response;

	}

	// Find by source and destination
	@HystrixCommand(fallbackMethod = "getFallbackFlightBySourceAndDestination")
	@GetMapping(value = "/{source}/{destination}")
	@ApiOperation(value = "Find the list Of Flights by source and destination", notes = "Search all the available flight details of specific flight using source and destination of flight")
	public Flight[] getFlightBySourceAndDestination(@PathVariable String source, @PathVariable String destination) {
		Flight[] response = restTemplate.getForObject("http://Search-service/Search/" + source + "/to/" + destination,
				Flight[].class);
		return response;
	}

	public Flight[] getFallbackFlightBySourceAndDestination(@PathVariable String source,
			@PathVariable String destination) {
		Flight[] response = { new Flight("", "", "", "", 0, 0, "", "", "", 0) };
		return response;

	}

	// Booking
	@CrossOrigin("*")
	@PostMapping(value = "/addbooking")
	@ApiOperation(value = "Book a flight ticket", notes = "Booking a flight ticket through this")
	public String addNewBooking(@RequestBody PassengerDetails booking) {
		return restTemplates.postForObject("http://localhost:8083/booking/book/add", booking, String.class);
	}

	// payment
	// @GetMapping(value = "/Payment")
	// public String getPayment() {
	// String response =
	// restTemplate.getForObject("http://localhost:8084/doPayment", String.class);
	// return response;
	// }
	// checkIn by reference Number
	@HystrixCommand(fallbackMethod = "getFallbackBookingDetailsByRefNumber")
	@GetMapping(value = "/Booking/{referencenumber}")
	@ApiOperation(value = "Find the booked Flight confirmation by reference number", notes = "Through this we can find that the flight is  booked or not")
	public String getBookingDetailsByRefNumber(@PathVariable String referencenumber) {
		String response = restTemplate.getForObject("http://Checkin-service/Checkin/get/" + referencenumber,
				String.class);
		return response;
	}

	public Flight[] getFallbackBookingDetailsByRefNumber(@PathVariable String referencenumber) {
		Flight[] response = { new Flight("", "", "", "", 0, 0, "", "", "", 0) };
		return response;

	}

	@GetMapping("/findAll")
	public List<Passenger> getPassengers() {
		return repo.findAll();
	}

	@PostMapping("/create")
	@ApiOperation(value = "Register to the site ", notes = "Through this any person can register to the site")
	public Passenger create(@RequestBody Passenger pass) {
		pass.setPassword(bCryptPasswordEncoder.encode(pass.getPassword()));
		return repo.save(pass);
	}
}
