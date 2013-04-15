package com.sirma.itt.javacourse.objects.trees;

import java.util.Random;

/**
 * Fill heterogeneus tree with random values and print it on screen
 * 
 * @version 1.1 15 April 2013
 * @author Stella Djulgerova
 */
public class HeterogeneusTreeRun {

	/**
	 * Class main method
	 * 
	 * @param args
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

		// Create the tree from the sample
		HeterogeneusTree<HeterogeneusTreeData> tree = new HeterogeneusTree<HeterogeneusTreeData>();

		// call java class Random to generate numbers
		Random randomGenerator = new Random();

		for (int i = 0; i < 20; i++) {

			tree.insert(new HeterogeneusTreeData(randomGenerator.nextInt(30), "S" + i));
		}

		tree.insert(new HeterogeneusTreeData(32, 9));
		// print the tree sorted
		tree.printTree();

		// search in tree by given key value
		tree.search(12);
	}
}
