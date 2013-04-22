package com.sirma.itt.javacourse.objects.trees;

import java.util.Random;

/**
 * Fill binary tree with random values and print in on screen.
 * 
 * @version 1.1 14 April 2013
 * @author Stella Djulgerova
 */
public class BinaryTreeRun {
	
	/**
	 * Class main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Create the tree
		BinaryTree<BinaryTreeData> tree = new BinaryTree<BinaryTreeData>();

		// call java class Random to generate numbers
		Random randomGenerator = new Random();

		for (int i = 0; i < 20; i++) {

			tree.insert(new BinaryTreeData(randomGenerator.nextInt(30), "String " + i));
		}

		// print the tree sorted
		tree.printTree();

		// search in tree by given key value
		System.out.println(tree.search(12));
	}
}
