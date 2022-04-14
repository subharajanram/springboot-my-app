package com.springboot.springbootmyapp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WelcomeController {

	@GetMapping("/api/supervisors")
	public ArrayList<String> getSupervisors() {

		final String uri = "https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers";
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Supervisor[]> response = restTemplate.getForEntity(
				"https://o3m5qixdng.execute-api.us-east-1.amazonaws.com/api/managers", Supervisor[].class);

		Supervisor[] supervisorList = response.getBody();
		List<Supervisor> finalList = new ArrayList<Supervisor>();
		ArrayList<String> responseList = new ArrayList<String>();

		int i = 0;

		// Numeric jurisdictions should be excluded from the response
		while (i < supervisorList.length) {
			// if ( !Character.isDigit(supervisorList[i].getJurisdiction()))
			if (!isNumeric(supervisorList[i].getJurisdiction()))
				finalList.add(supervisorList[i]);
			i++;
		}

		// Supervisors within the endpoint response payload should be sorted in
		// alphabetical order first by jurisdiction, then by lastName and firstName.
		// 1. Jurisdiction comparator
		Comparator<Supervisor> jurisdictionComparatorLEx = (sup1, sup2) -> sup1.getJurisdiction()
				.compareTo(sup2.getJurisdiction());

		// 2. LastName comparator
		Comparator<Supervisor> lastNameComparatorLEx = (sup1, sup2) -> sup1.getLastName().compareTo(sup2.getLastName());

		// 3. First Name comparator
		Comparator<Supervisor> firstNameComparatorLEx = (sup1, sup2) -> sup1.getFirstName()
				.compareTo(sup2.getFirstName());

		List<Supervisor> sortedSupervisorList = finalList.stream().sorted(jurisdictionComparatorLEx // jurisdiction //
				.thenComparing(lastNameComparatorLEx) // then lastname
				.thenComparing(firstNameComparatorLEx)) // then firstName
				.collect(Collectors.toList()); // collect sorted customers to new list

		// print new list to console using forEach()
		sortedSupervisorList.stream().forEach(sup -> responseList
				.add(sup.getJurisdiction() + " - " + sup.getLastName() + " , " + sup.getFirstName()));

		return responseList;
	}

	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	@PostMapping("api/submit")
	public String printSupervisor(@RequestBody Supervisor newUser) {

		// Check required parameters
		if (newUser.getFirstName().isBlank() || newUser.getLastName().isBlank()) {
			return "Error First and Last Names are required values";
		} else
			return newUser.getFirstName() + " " + newUser.getLastName() +  " " + newUser.getPhone();
		//Or we can write a custom ErrorController for specific errors.
	}
}

	
