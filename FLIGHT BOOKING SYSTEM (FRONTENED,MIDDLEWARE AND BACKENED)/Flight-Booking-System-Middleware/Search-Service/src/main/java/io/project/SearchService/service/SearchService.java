package io.project.SearchService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.project.SearchService.models.Flight;
import io.project.SearchService.repository.SearchRepository;

@Service
public class SearchService {

	@Autowired
	private SearchRepository repo;

	public List<Flight> getAllFlights() {
		return repo.findAll();
	}

	public List<Flight> getFlightByFlight_Number(String flight_num) {
		return repo.findByFlight_Number(flight_num);
	}

	public List<Flight> getFlightByFlight_Name(String flight_name) {
		return repo.findByFlight_Name(flight_name);
	}

	public List<Flight> getFlightByDate_Of_Travel(String dot) {
		return repo.findByDate_Of_Travel(dot);
	}

	public List<Flight> getFlightDetailsBySourceToDest(String source, String destination) {
		List<Flight> detList = repo.findAll();
		List<Flight> req = new ArrayList<Flight>();
		for (Flight fl : detList) {
			String stat = fl.getTraveling_from();
			String dest = fl.getTraveling_to();
			if (stat.equals(source) && dest.equals(destination)) {
				req.add(fl);
			}
		}
		return req;
	}
}
