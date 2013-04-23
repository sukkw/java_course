package com.sirma.itt.javacourse.objects.store;

/**
 * Keep information for employees.
 * 
 * @version 1.1 16 April 2013
 * @author Stella Djulgerova
 */
public class Employee extends Person {

	// class private members
	private Department department;
	private Position position;
	private double salary;

	/**
	 * Get salary.
	 * 
	 * @return employee salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * Set salary.
	 * 
	 * @param salary
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * Get employee's department.
	 * 
	 * @return employee's department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * Set employee's department.
	 * 
	 * @param department
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * Get employee's position.
	 * 
	 * @return employee's position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * Set employee's position.
	 * 
	 * @param position
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
}
