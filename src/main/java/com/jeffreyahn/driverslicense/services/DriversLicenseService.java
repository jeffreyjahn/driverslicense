package com.jeffreyahn.driverslicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jeffreyahn.driverslicense.models.License;
import com.jeffreyahn.driverslicense.models.Person;
import com.jeffreyahn.driverslicense.repositories.LicenseRepository;
import com.jeffreyahn.driverslicense.repositories.PersonRepository;

@Service
public class DriversLicenseService {
	private final LicenseRepository licenseRepository;
	private final PersonRepository personRepository;
	public DriversLicenseService(LicenseRepository licenseRepository, PersonRepository personRepository) {
		this.licenseRepository = licenseRepository;
		this.personRepository = personRepository;
	}
	public List<Person> findPeople(){
		return personRepository.findAll();
	}
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}

	public Person findPersonByName(String fName, String lName) {
		Person person = personRepository.findPersonByFirstNameAndLastName(fName, lName);
		return person;
	}
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
	public License createLicense(License license) {
		return licenseRepository.save(license);
	}
}
