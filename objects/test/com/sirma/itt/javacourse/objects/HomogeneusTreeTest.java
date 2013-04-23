package com.sirma.itt.javacourse.objects;

import org.testng.annotations.Test;

import com.sirma.itt.javacourse.objects.trees.HomogeneusTree;

/**
 * Test class for homogeneus tree methods.
 * 
 * @version 1.1 18 April 2013
 * @author Stella Djulgerova
 */
public class HomogeneusTreeTest {

	/**
	 * Test method print.
	 */
	@Test
	public void printTree() {
		//fill tree with data
        HomogeneusTree<String> tree = new HomogeneusTree<String>("Stella",

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
        
        tree.print();
	}

}
