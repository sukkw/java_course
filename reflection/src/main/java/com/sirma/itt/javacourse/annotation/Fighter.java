package com.sirma.itt.javacourse.annotation;

/**
 * Represent information for fighter.
 * 
 * @version 1.1 27 April 2013
 * @author Stella Djulgerova
 */
@PlaneAnnotation(4)
public class Fighter extends MilitaryAircraft {

	@Override
	public void fly() {
		System.out.println("I fly super fast");
	}
}
