package com.jeffreyahn.driverslicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jeffreyahn.driverslicense.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	List<Person> findAll();
	Person findPersonByFirstNameAndLastName(String firstName, String LastName);
}
