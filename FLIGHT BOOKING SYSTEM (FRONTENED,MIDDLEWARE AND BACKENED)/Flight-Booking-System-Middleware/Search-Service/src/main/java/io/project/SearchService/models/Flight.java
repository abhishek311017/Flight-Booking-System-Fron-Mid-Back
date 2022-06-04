package io.project.SearchService.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="flight")
public class Flight {

	@Id
	private String id;
	@Field
	private String flight_number;
    @Field
	private String flight_name;
    @Field
	private String traveling_from;
    @Field
	private String traveling_to;
    @Field
	private int distance_in_km;
    @Field
	private int flight_fare_in_rupees;
    @Field
    private String date_of_travel;
    @Field
    private String departure_time;
	@Field
	private String arrival_time;
	@Field
	private int number_of_available_seats;
	
	public String getDate_of_travel() {
		return date_of_travel;
	}
	public void setDate_of_travel(String date_of_travel) {
		this.date_of_travel = date_of_travel;
	}
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFlight_number() {
		return flight_number;
	}
	public void setFlight_number(String flight_number) {
		this.flight_number = flight_number;
	}
	public String getFlight_name() {
		return flight_name;
	}
	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}
	public String getTraveling_from() {
		return traveling_from;
	}
	public void setTraveling_from(String traveling_from) {
		this.traveling_from = traveling_from;
	}
	public String getTraveling_to() {
		return traveling_to;
	}
	public void setTraveling_to(String traveling_to) {
		this.traveling_to = traveling_to;
	}
	public int getDistance_in_km() {
		return distance_in_km;
	}
	public void setDistance_in_km(int distance_in_km) {
		this.distance_in_km = distance_in_km;
	}
	public int getFlight_fare_in_rupees() {
		return flight_fare_in_rupees;
	}
	public void setFlight_fare_in_rupees(int flight_fare_in_rupees) {
		this.flight_fare_in_rupees = flight_fare_in_rupees;
	}
	public int getNumber_of_available_seats() {
		return number_of_available_seats;
	}
	public void setNumber_of_available_seats(int number_of_available_seats) {
		this.number_of_available_seats = number_of_available_seats;
	}	
	
}