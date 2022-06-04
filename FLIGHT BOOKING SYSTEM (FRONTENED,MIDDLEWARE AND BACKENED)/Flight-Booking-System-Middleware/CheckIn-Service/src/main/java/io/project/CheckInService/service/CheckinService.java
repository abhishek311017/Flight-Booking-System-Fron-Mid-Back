package io.project.CheckInService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.project.CheckInService.models.PassengerDetails;
import io.project.CheckInService.repository.CheckinRepository;

@Service
public class CheckinService {
	@Autowired
	CheckinRepository repo;

	public String getUserDetailsByReferenceNumber(int referenceNum) {

		List<PassengerDetails> passengerDetails = repo.findAll();
		for (PassengerDetails x : passengerDetails) {
			if (x.getReferenceNum() == referenceNum) {
				x.setMsg("booked successfully");
				repo.save(x);
			}

		}
		return "You  have " + repo.findByReferenceNum(referenceNum).getMsg();
	}

}
