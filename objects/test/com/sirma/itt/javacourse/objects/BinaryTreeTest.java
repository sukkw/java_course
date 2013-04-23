package com.sirma.itt.javacourse.objects;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sirma.itt.javacourse.objects.trees.BinaryTree;
import com.sirma.itt.javacourse.objects.trees.BinaryTree.BinaryTreeNode;

/**
 * Test class for binary tree methods.
 * 
 * @version 1.1 17 April 2013
 * @author Stella Djulgerova
 */
public class BinaryTreeTest {

	// Create the tree from the sample
	BinaryTree<String> tree = new BinaryTree<String>();

	/**
	 * Data used for tests.
	 * 
	 * @return test data and valid data
	 */
	@DataProvider
	private Object[][] validData() {
		return new Object[][] { {
				new String[] { "String1 ", "String2", "String3", "String4", "String5", "String6",
						"String7", "String8" }, "String8" } };
	}

	/**
	 * Test method search.
	 * 
	 * @param inputData - elements of tree
	 * @param valid - searched element
	 */
	@Test(dataProvider = "validData")
	public void search(String[] inputData, String valid) {

		// print the tree sorted
		BinaryTreeNode result = tree.search("String8");
		Assert.assertEquals(result.value, valid);
	}

	/**
	 * Test method insert.
	 * 
	 * @param inputData - elements of tree
	 * @param valid - correct value
	 */
	@Test(dataProvider = "validData")
	public void insert(String[] inputData, String valid) {

		// insert into tree
		tree.insert("String9");

	}

	/**
	 * Test method print.
	 * 
	 * @param inputData - elements of tree
	 * @param valid - correct value
	 */
	@Test(dataProvider = "validData")
	public void printTree(String[] inputData, String valid) {

		// load tree data
		load(inputData);

		// print the tree sorted
		tree.printTree();
	}

	/**
	 * Load test data.
	 * 
	 * @param inputData - elements of tree
	 */
	public void load(String[] inputData) {

		for (String obj : inputData) {
			tree.insert(obj);
		}
	}

}
