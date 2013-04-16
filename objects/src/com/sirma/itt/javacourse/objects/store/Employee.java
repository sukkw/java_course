package com.sirma.itt.javacourse.objects.store;

/**
 * Keep information for employees
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
	 * get salary
	 * 
	 * @return
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * set salary
	 * 
	 * @param salary
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * get employee's department
	 * @return
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * set employee's department
	 * @param department
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * get employee's position
	 * @return
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * set employee's position
	 * @param position
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
}
