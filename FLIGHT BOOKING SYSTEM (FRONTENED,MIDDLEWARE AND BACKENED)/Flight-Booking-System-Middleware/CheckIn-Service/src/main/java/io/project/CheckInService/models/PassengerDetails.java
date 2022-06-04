package io.project.CheckInService.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="passengerbookingdetails")
public class PassengerDetails {
        @Id
	    int referenceNum;
        private String name;
    	private String dob;
    	private String gender;
    	private String city;

    	private String flight_number;

    	private String traveling_from;

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
		private String traveling_to;
    	 private String date_of_travel;
	    String msg;
	    
		public PassengerDetails() {
			super();
		}
		public PassengerDetails(String msg) {
			super();
			
			this.msg = msg;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getFlight_number() {
			return flight_number;
		}
		public void setFlight_number(String flight_number) {
			this.flight_number = flight_number;
		}
		public String getDate_of_travel() {
			return date_of_travel;
		}
		public void setDate_of_travel(String date_of_travel) {
			this.date_of_travel = date_of_travel;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public int getReferenceNum() {
			return referenceNum;
		}
		public void setReferenceNum(int referenceNum) {
			this.referenceNum = referenceNum;
		}
	    

}
