package io.project.Passengerservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("passenger")
public class Passenger {
@Id
private String id;
@Field
private String userId;
@Field
private String name;
@Field
private String email;
@Field
private String password;
@Field
private String gender;
@Field
private String dob;
@Field
private String city;


public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
@Override
public String toString() {
	return String.format("Passenger[id='%s',userId='%s',name='%s',email='%s',password='%s',gender='%s',dob='%s',city='%s']", id,userId,name,email,password,gender,dob,city);
}

	
	
}
