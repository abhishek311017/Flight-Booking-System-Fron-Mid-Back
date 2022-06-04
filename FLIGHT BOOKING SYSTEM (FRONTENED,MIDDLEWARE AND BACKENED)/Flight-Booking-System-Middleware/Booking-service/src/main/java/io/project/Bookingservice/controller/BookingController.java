package io.project.Bookingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.project.Bookingservice.models.PassengerDetails;
import io.project.Bookingservice.service.BookingService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/booking")
@CrossOrigin("*")
public class BookingController {


	@Autowired
	private BookingService bookingService;

	@PostMapping("/book/add")
	@ApiOperation(value="Book a flight ticket",notes="Booking a flight ticket through this")
	public String addUserDetails(@RequestBody PassengerDetails passengerDetails) {
		passengerDetails.setReference_num(BookingService.getNextSequence(PassengerDetails.SEQUENCE_NAME));
		
			return bookingService.addUserBookingDetails(passengerDetails);
		
	}

}
//String response = restTemplate.getForObject("http://localhost:8084/doPayment/", String.class);
//if (response.equalsIgnoreCase("Success")) {} else {
//	return "payment failed";
//}