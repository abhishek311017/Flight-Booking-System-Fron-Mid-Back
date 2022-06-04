package io.project.PassengerLogin.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("passenger")
public class Users {
	@Id
	public ObjectId _id;
	public String email;
	public String password;

	public Users() {
	}

	public Users(ObjectId _id, String email, String password) {
		this._id = _id;
		this.email = email;
		this.password = password;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String get_id() {
		return this._id.toHexString();
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
