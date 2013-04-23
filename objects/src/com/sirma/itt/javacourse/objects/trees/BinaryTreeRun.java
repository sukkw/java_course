package com.sirma.itt.javacourse.objects.trees;

import java.util.Random;

/**
 * Fill binary tree with random values and print in on screen.
 * 
 * @version 1.1 14 April 2013
 * @author Stella Djulgerova
 */
public class BinaryTreeRun {
	public static void main(String[] args) {

		// Create string tree
		BinaryTree<String> stringTree = new BinaryTree<String>();

		// call java class Random to generate numbers
		Random randomGenerator = new Random();

		for (int i = 0; i < 20; i++) {
			stringTree.insert("String" + randomGenerator.nextInt(25));
		}

		// print the tree sorted
		stringTree.printTree();

		// search in tree by given value
		stringTree.search("String3");

		// Create integer tree
		BinaryTree<Integer> intTree = new BinaryTree<Integer>();

		for (int i = 0; i < 20; i++) {
			intTree.insert(randomGenerator.nextInt(25));
		}

		// print the tree sorted
		intTree.printTree();

		// search in tree by given value
		intTree.search(12);
	}
}
