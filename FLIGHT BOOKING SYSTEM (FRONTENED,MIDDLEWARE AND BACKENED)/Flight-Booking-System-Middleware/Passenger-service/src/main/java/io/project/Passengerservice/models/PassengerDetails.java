package io.project.Passengerservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "passengerbookingdetails")
public class PassengerDetails {

	@Transient // ignoring the field ( only work & doesn't save)
	public static final String SEQUENCE_NAME = "reference_Num";

	@Id
	private int reference_num;
	private String name;
	private String dob;
	private String gender;
	private String city;

	private String flight_number;

	private String traveling_from;

	private String traveling_to;
	 private String date_of_travel;
	

	public PassengerDetails(String date_of_travel) {
		super();
		this.date_of_travel = date_of_travel;
	}

	public String getDate_of_travel() {
		return date_of_travel;
	}

	public void setDate_of_travel(String date_of_travel) {
		this.date_of_travel = date_of_travel;
	}

	public PassengerDetails() {
		super();
	}

	public PassengerDetails(String name, String dob, String gender, String city, String flight_number,
			String traveling_from, String traveling_to, int reference_num) {
		super();

		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.city = city;
		this.flight_number = flight_number;
		this.traveling_from = traveling_from;
		this.traveling_to = traveling_to;
		this.reference_num = reference_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(String flight_number) {
		this.flight_number = flight_number;
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

	public int getReference_num() {
		return reference_num;
	}

	public void setReference_num(int i) {
		this.reference_num = i;
	}

}
