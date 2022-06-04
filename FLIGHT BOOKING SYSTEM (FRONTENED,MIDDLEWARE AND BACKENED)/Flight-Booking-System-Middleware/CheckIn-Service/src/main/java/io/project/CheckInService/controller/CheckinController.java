package io.project.CheckInService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.project.CheckInService.service.CheckinService;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/Checkin")
public class CheckinController {
	@Autowired 
    CheckinService cs;
	@GetMapping("/get/{referenceNum}")
	@ApiOperation(value="Find the booked Flight confirmation by reference number",notes="Through this we can find that the flight is  booked or not")
	public String getUserDetailsById(@PathVariable int referenceNum )
	{
		return cs.getUserDetailsByReferenceNumber(referenceNum);
	}

}
