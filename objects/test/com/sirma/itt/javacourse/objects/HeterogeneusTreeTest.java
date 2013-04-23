package com.sirma.itt.javacourse.objects;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sirma.itt.javacourse.objects.trees.HeterogeneusTree;
import com.sirma.itt.javacourse.objects.trees.HeterogeneusTreeData;
import com.sirma.itt.javacourse.objects.trees.HeterogeneusTree.HeterogeneusTreeNode;

/**
 * Test class for heterogeneust tree methods.
 * 
 * @version 1.1 18 April 2013
 * @author Stella Djulgerova
 */
public class HeterogeneusTreeTest {

	// Create the tree
	HeterogeneusTree<HeterogeneusTreeData> tree = new HeterogeneusTree<HeterogeneusTreeData>();

	/**
	 * Data used for tests.
	 * 
	 * @return test data and valid data
	 */
	@DataProvider
	private Object[][] validData() {
		return new Object[][] { {
				new HeterogeneusTreeData[] { new HeterogeneusTreeData("String1"),
						new HeterogeneusTreeData(8), new HeterogeneusTreeData(2.76564),
						new HeterogeneusTreeData(true), new HeterogeneusTreeData(2.6f),
						new HeterogeneusTreeData("String2"),
						new HeterogeneusTreeData(13),
						new HeterogeneusTreeData("String3") },
						"String3"} };
	}

	/**
	 * Test method search.
	 * 
	 * @param inputData - elements of tree
	 * @param valid - correct value
	 */
	@Test(dataProvider = "validData")
	public void search(HeterogeneusTreeData[] inputData, String valid) {

		// print the tree sorted
		HeterogeneusTreeNode result = tree.search(new HeterogeneusTreeData("String2"));
		
		System.out.println(" Val " + result.value);
		Assert.assertEquals(result.value, valid);
	}

	/**
	 * Test method insert.
	 * 
	 * @param inputData - elements of tree
	 * @param valid - correct value
	 */
	@Test(dataProvider = "validData")
	public void insert(HeterogeneusTreeData[] inputData, String valid) {

		// insert into tree
		tree.insert(new HeterogeneusTreeData("String4"));

	}

	/**
	 * Test method print.
	 * 
	 * @param inputData - elements of tree
	 * @param valid - correct value
	 */
	@Test(dataProvider = "validData")
	public void printTree(HeterogeneusTreeData[] inputData, String valid) {

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
	public void load(HeterogeneusTreeData[] inputData) {

		for (HeterogeneusTreeData obj : inputData) {
			tree.insert(obj);
		}
	}

}
