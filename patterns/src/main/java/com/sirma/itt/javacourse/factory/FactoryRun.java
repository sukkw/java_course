package com.sirma.itt.javacourse.factory;

/**
 * Abstract factory design pattern run class.
 * 
 * @version 1.1 16 May 2013
 * @author Stella Djulgerova
 */
public class FactoryRun {

	/**
	 * Class main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		MyClass defaultMyClass = MyClassFactory.getMyClass();
		MyClass myClass = MyClassFactory.getMyClass("Stella", 33);
		MyClass myByReflection = MyClassFactory
				.createInstance("com.sirma.itt.javacourse.factory.MyClass");
	}
}
