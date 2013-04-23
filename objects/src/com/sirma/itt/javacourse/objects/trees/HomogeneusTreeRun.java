package com.sirma.itt.javacourse.objects.trees;

/**
 * Fill homogeneus tree with random values and print it on screen.
 * 
 * @version 1.1 14 April 2013
 * @author Stella Djulgerova
 */
public class HomogeneusTreeRun {
	
	/**
	 * Class main method.
	 * @param args
	 */
	public static void main(String[] args) {

		//fill tree with  string data
        HomogeneusTree<String> stringTree = new HomogeneusTree<String>("Stella",

                        new HomogeneusTree<String>("Eli",

                                    new HomogeneusTree<String>("Ani"),

                                    new HomogeneusTree<String>("Stefan"),

                                    new HomogeneusTree<String>("Ivan")),

                        new HomogeneusTree<String>("Mariana"),

                        new HomogeneusTree<String>( "Oleg",

                                    new HomogeneusTree<String>("Todor"),

                                    new HomogeneusTree<String>("Neli",
                                    		new HomogeneusTree<String>("Marin")))

            );
        
		//fill tree with integer data
        HomogeneusTree<Integer> intTree = new HomogeneusTree<Integer>(23,

                        new HomogeneusTree<Integer>(5,

                                    new HomogeneusTree<Integer>(18),

                                    new HomogeneusTree<Integer>(44),

                                    new HomogeneusTree<Integer>(23)),

                        new HomogeneusTree<Integer>(2),

                        new HomogeneusTree<Integer>(34,

                                    new HomogeneusTree<Integer>(33),

                                    new HomogeneusTree<Integer>(16,
                                    		new HomogeneusTree<Integer>(8)))

            );
		
        //print tree
        stringTree.print();
        intTree.print();


}
}