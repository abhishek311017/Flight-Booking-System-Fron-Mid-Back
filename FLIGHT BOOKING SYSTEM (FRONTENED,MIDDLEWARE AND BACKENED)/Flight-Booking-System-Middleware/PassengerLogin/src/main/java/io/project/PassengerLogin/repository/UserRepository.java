package io.project.PassengerLogin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.project.PassengerLogin.models.Users;

public interface UserRepository extends MongoRepository<Users, String> {
	Users findByEmail(String username);

}
