package io.project.AdminService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.project.AdminService.model.Flight;
import io.project.AdminService.model.Passenger;
import io.project.AdminService.repository.AdminRepository;
import io.project.AdminService.repository.PassengerRepository;

@Service
public class AdminService {
	
	
	@Autowired
	private AdminRepository repo;
	
	
    @Autowired
    private PassengerRepository pass;
    
    
	public void addFlight(Flight flight) {
		repo.save(flight);
	}

	public List<Flight> getAllFlights() {
		return repo.findAll();
	}
	public Flight getFlightByFlight_Number(String flight_num) {
		return repo.findByFlight_Number(flight_num);
	}

	public String deleteFlight(String flight_num) {
		repo.deleteByFlight_Number(flight_num);
		return "Flight deleted with id:" + flight_num;
	}

	public Flight getFlightByFlight_Name(String flight_name) {
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

	public Flight updateFlight(String fn, Flight flight) {
		Flight Details = repo.findByFlight_Number(fn);
		Details.setDate_of_travel(Details.getDate_of_travel());
		Details.setFlight_fare_in_rupees(Details.getFlight_fare_in_rupees());
		Details.setDistance_in_km(Details.getDistance_in_km());
		Details.setFlight_name(Details.getFlight_name());
		Details.setTraveling_from(Details.getTraveling_from());
		Details.setTraveling_to(Details.getTraveling_to());
		Details.setNumber_of_available_seats(Details.getNumber_of_available_seats());
		Details.setDeparture_time(Details.getArrival_time());
		Details.setArrival_time(Details.getArrival_time());
		return repo.save(Details);

	}
	public List<Passenger> getPassengerList(){
		return pass.findAll();
	}

}
