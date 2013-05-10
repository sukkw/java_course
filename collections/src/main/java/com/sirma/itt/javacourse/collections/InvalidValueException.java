package com.sirma.itt.javacourse.collections;

/**
 * Custom exception. 
 * Exception is thrown if no such value is found in exceptions hashMap.
 * 
 * @version 1.1 09 May 2013
 * @author Stella Djulgerova
 */
public class InvalidValueException extends Exception {

        private static final long serialVersionUID = 1L;

        /**
         * Invokes parent constructor.
         * @param msg message of exception
         */
        public InvalidValueException(String msg) {
                super(msg);
        }
}