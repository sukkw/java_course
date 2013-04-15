package com.sirma.itt.javacourse.objects.trees;


/**
 * Fill heterogeneus tree with random values and print it on screen
 * 
 * @version 1.1 15 April 2013
 * @author Stella Djulgerova
 */
public class HeterogeneusTreeRun {
	
	/**
	 * Class main method
	 * @param args
	 */
	public static void main(String[] args) {

		//fill tree with data
		HeterogeneusTree<String> tree = new HeterogeneusTree<String>("7");
		
        
        //print tree
        tree.print();

  }
}
