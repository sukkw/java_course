package com.sirma.itt.javacourse.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Custom annotation describing specific class order.
 * 
 * @version 1.1 27 April 2013
 * @author Stella Djulgerova
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface PlaneAnnotation {
	int value();
}