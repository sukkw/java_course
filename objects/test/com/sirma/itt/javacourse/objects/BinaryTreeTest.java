package com.sirma.itt.javacourse.objects;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sirma.itt.javacourse.objects.trees.BinaryTree;
import com.sirma.itt.javacourse.objects.trees.BinaryTreeData;

/**
 * Test class for binary tree methods
 * 
 * @version 1.1 17 April 2013
 * @author Stella Djulgerova
 */
public class BinaryTreeTest {

	// Create the tree from the sample
	BinaryTree<BinaryTreeData> tree = new BinaryTree<BinaryTreeData>();

	/**
	 * Data used for tests
	 * 
	 * @return test data and valid data
	 */
	@DataProvider
	private Object[][] validData() {
		return new Object[][] { {
				new BinaryTreeData[] { new BinaryTreeData(19, "String1 "),
						new BinaryTreeData(35, "String2"),
						new BinaryTreeData(11, "String3"),
						new BinaryTreeData(7, "String4"),
						new BinaryTreeData(16, "String5"),
						new BinaryTreeData(23, "String6"),
						new BinaryTreeData(13, "String7"),
						new BinaryTreeData(17, "String8") },
				new String("Turseniq element e: 11 String3") } };
	}

	/**
	 * Test method search
	 * 
	 * @param inputData
	 * @param valid
	 */
	@Test(dataProvider = "validData")
	public void search(BinaryTreeData[] inputData, String valid) {

		// print the tree sorted
		String result = tree.search(11);
		Assert.assertEquals(result, valid);
	}

	/**
	 * Test method insert
	 * 
	 * @param inputData
	 * @param valid
	 */
	@Test(dataProvider = "validData")
	public void insert(BinaryTreeData[] inputData, String valid) {

		// insert into tree
		tree.insert(new BinaryTreeData(40, "String8"));

	}

	/**
	 * Test method print
	 * 
	 * @param inputData
	 * @param valid
	 */
	@Test(dataProvider = "validData")
	public void printTree(BinaryTreeData[] inputData, String valid) {

		// load tree data
		load(inputData);

		// print the tree sorted
		tree.printTree();
	}

	/**
	 * Load test data
	 * 
	 * @param inputData
	 * @param valid
	 */
	public void load(BinaryTreeData[] inputData) {

		for (BinaryTreeData obj : inputData) {
			tree.insert(obj);
		}
	}

}
