package com.springboot.springbootmyapp;

import java.util.Comparator;

public class Supervisor {
	
	private int id;
	private String phone;
	private String jurisdiction;
	private String identificationNumber;
	private String firstName;
	private String lastName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getJurisdiction() {
		return jurisdiction;
	}
	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
//	public static Comparator<Supervisor> SupervisorJurisdictionComparator = new Comparator<Supervisor>() {
//        
//	      public int compare(Supervisor s1, Supervisor s2)
//	              {
//	  
//	                  String jurisdiction1
//	                      = s1.getJurisdiction().toUpperCase();
//	                  String jurisdiction2
//	                      = s2.getJurisdiction().toUpperCase();
//	  
//	                  // ascending order
//	                  return jurisdiction1.compareTo(
//	                		  jurisdiction2);
//	  
//	                  // descending order
//	                  // return
//	                  // StudentName2.compareTo(StudentName1);
//	              }
//	          };

}
