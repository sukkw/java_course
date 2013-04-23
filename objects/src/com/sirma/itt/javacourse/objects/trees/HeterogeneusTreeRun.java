package com.sirma.itt.javacourse.objects.trees;

import java.util.Random;

/**
 * Fill heterogeneus tree with random values and print it on screen.
 * 
 * @version 1.1 15 April 2013
 * @author Stella Djulgerova
 */
public class HeterogeneusTreeRun {

	/**
	 * Class main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Create the tree
		HeterogeneusTree<HeterogeneusTreeData> tree = new HeterogeneusTree<HeterogeneusTreeData>();

		for (int i = 0; i < 10; i++) {
			tree.insert(new HeterogeneusTreeData("String " + i));
		}

		//insert random type values in tree
		tree.insert(new HeterogeneusTreeData(9));
		tree.insert(new HeterogeneusTreeData("test"));
		tree.insert(new HeterogeneusTreeData(4.6755));
		tree.insert(new HeterogeneusTreeData(true));
		tree.insert(new HeterogeneusTreeData(2.4f));

		// print the tree sorted
		tree.printTree();

		// search in tree by given value
		tree.search(new HeterogeneusTreeData("test"));
	}
}
