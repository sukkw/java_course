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

		// Create the tree from the sample
		BinaryTree<BinaryTreeData> tree = new BinaryTree<BinaryTreeData>();

		// call java class Random to generate numbers
		Random randomGenerator = new Random();

		for (int i = 0; i < 20; i++) {

			tree.insert(new BinaryTreeData(randomGenerator.nextInt(30), randomString()));
		}

		// print the tree sorted
		tree.printTree();

		// search in tree by given key value
		tree.search(12);
	}

	/**
	 * Generate random string
	 * 
	 * @return
	 */
	public static String randomString() {
		String randomStr = "";
		for (int j = 0; j < 10; j++) {
			int randomInt = 0;
			do {
				randomInt = (int) (Math.random() * (122 - 48)) + 48;
			} while ((randomInt > 57 && randomInt < 65) || (randomInt > 90 && randomInt < 97));
			char randomChar = (char) randomInt;
			randomStr += new Character(randomChar).toString();
		}
		return randomStr;
	}
}
