package com.jeffreyahn.driverslicense.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeffreyahn.driverslicense.models.License;
import com.jeffreyahn.driverslicense.models.Person;
import com.jeffreyahn.driverslicense.services.DriversLicenseService;

@Controller
public class DriversLicenseController {

	private final DriversLicenseService driversLicenseService;
	public DriversLicenseController(DriversLicenseService driversLicenseService) {

		this.driversLicenseService = driversLicenseService;
		
	}
	@RequestMapping("/persons/new")
	public String persons(@ModelAttribute("person") Person person) {
		return "/driverslicense/newPerson.jsp";
	}
	@RequestMapping(value="/persons/new", method=RequestMethod.POST)
	public String newPerson(@ModelAttribute("person") Person person, Model model) {
		Person newPerson = driversLicenseService.createPerson(person);
		model.addAttribute("person", newPerson);
		return "redirect:/licenses/new";
	}
	@RequestMapping("/licenses/new")
	public String licenses(Model model, @ModelAttribute("license") License license) {
		List<Person> people = driversLicenseService.findPeople();
		model.addAttribute("people", people);
		return "/driverslicense/newLicense.jsp";
	}
	@RequestMapping(value="/licenses/new", method=RequestMethod.POST)
	public String newLicenses(Model model, @ModelAttribute("license") License license, @RequestParam(value="checkDate") String checkDate, @RequestParam(value="connectPerson") String person) throws ParseException {
		DateFormat df = new SimpleDateFormat("mm-dd-YYYY");
		Date changedDate = df.parse(checkDate);
		License addLicense = license;
		addLicense.setExpiration_date(changedDate);
		String[] split = person.split(" ");
		Person addPerson = driversLicenseService.findPersonByName(split[0], split[1]);
		addLicense.setPerson(addPerson);
		License newLicense = driversLicenseService.createLicense(addLicense);
		
		model.addAttribute("license", newLicense);
		return "redirect:/persons/" + addPerson.getId();
	}
	@RequestMapping(value="/persons/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		Person person = driversLicenseService.findPerson(id);
		model.addAttribute("person", person);
		return "/driverslicense/show.jsp";
	}
	@RequestMapping("/")
	public String index() {
		return "redirect:/persons/new";
	}
}
