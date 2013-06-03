package com.sirma.itt.javacourse.annotation;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Order instances of different Plane classes using annotation and reflection.
 * 
 * @version 1.1 27 April 2013
 * @author Stella Djulgerova
 */
public class PlainOrder {

	/**
	 * Order all instances following annotation rules.
	 * 
	 * @return - array with ordered instances
	 */
	public Plane[] orderInstances(Plane[] instances) {
		Arrays.sort(instances, planeAnnotationComparator);
		return instances;
	}

	/**
	 * Compare different instances using annotation.
	 */
	public static Comparator<Plane> planeAnnotationComparator = new Comparator<Plane>() {

		/**
		 * Compare one instance to another.
		 * 
		 * @param firstInstance - first instance to compare
		 * @param secondInstance - second instance to compare
		 * @return - result after comparison
		 */
		public int compare(Plane firstInstance, Plane secondInstance) {
			
			// check if instances to compare are not null
			if(firstInstance == null || secondInstance ==null) {
				return 0;
			}
			
			Class fiClass = firstInstance.getClass();
			PlaneAnnotation fiAnnotation = (PlaneAnnotation) fiClass
					.getAnnotation(PlaneAnnotation.class);

			Class siClass = secondInstance.getClass();
			PlaneAnnotation siAnnotation = (PlaneAnnotation) siClass
					.getAnnotation(PlaneAnnotation.class);

			// check if each instance have such annotation
			if(fiAnnotation == null || siAnnotation == null) {
				return 0;
			}
			
			int anno1 = fiAnnotation.value();
			int anno2 = siAnnotation.value();

			// ascending order
			return new Integer(anno1).compareTo(anno2);

			// descending order
			// return new Integer(anno2).compareTo(anno1);
		}
	};
}
