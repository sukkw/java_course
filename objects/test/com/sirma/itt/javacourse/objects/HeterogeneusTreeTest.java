package com.sirma.itt.javacourse.objects;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sirma.itt.javacourse.objects.trees.HeterogeneusTree;
import com.sirma.itt.javacourse.objects.trees.HeterogeneusTreeData;

/**
 * Test class for heterogeneust tree methods
 * 
 * @version 1.1 18 April 2013
 * @author Stella Djulgerova
 */
public class HeterogeneusTreeTest {

	// Create the tree
	HeterogeneusTree<HeterogeneusTreeData> tree = new HeterogeneusTree<HeterogeneusTreeData>();

	/**
	 * Data used for tests
	 * 
	 * @return test data and valid data
	 */
	@DataProvider
	private Object[][] validData() {
		return new Object[][] { {
				new HeterogeneusTreeData[] {
						new HeterogeneusTreeData(19, "String1 "),
						new HeterogeneusTreeData(35, 8),
						new HeterogeneusTreeData(11, 2.76564),
						new HeterogeneusTreeData(7, true),
						new HeterogeneusTreeData(16, 2.6f),
						new HeterogeneusTreeData(23, "String2"),
						new HeterogeneusTreeData(13, new HeterogeneusTreeData(1, 5)),
						new HeterogeneusTreeData(17, "String3") },
				new String("Turseniq element e: 16 2.6") } };
	}

	/**
	 * Test method search
	 * 
	 * @param inputData
	 * @param valid
	 */
	@Test(dataProvider = "validData")
	public void search(HeterogeneusTreeData[] inputData, String valid) {

		// print the tree sorted
		String result = tree.search(16);
		Assert.assertEquals(result, valid);
	}

	/**
	 * Test method insert
	 * 
	 * @param inputData
	 * @param valid
	 */
	@Test(dataProvider = "validData")
	public void insert(HeterogeneusTreeData[] inputData, String valid) {

		// insert into tree
		tree.insert(new HeterogeneusTreeData(40, "String4"));

	}

	/**
	 * Test method print
	 * 
	 * @param inputData
	 * @param valid
	 */
	@Test(dataProvider = "validData")
	public void printTree(HeterogeneusTreeData[] inputData, String valid) {

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
	public void load(HeterogeneusTreeData[] inputData) {

		for (HeterogeneusTreeData obj : inputData) {
			tree.insert(obj);
		}
	}

}
