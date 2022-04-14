package com.springboot.springbootmyapp;

import java.util.ArrayList;
import java.util.List;

public class SupervisorList {
	private List<Supervisor> employees;

    public SupervisorList() {
        employees = new ArrayList<>();
    }

	public List<Supervisor> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Supervisor> employees) {
		this.employees = employees;
	}
}
