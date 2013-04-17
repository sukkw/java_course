package com.sirma.itt.javacourse.objects;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sirma.itt.javacourse.objects.trees.BinaryTree;
import com.sirma.itt.javacourse.objects.trees.BinaryTreeData;
import com.sirma.itt.javacourse.objects.trees.HomogeneusTree;
import com.sirma.itt.javacourse.objects.trees.HomogeneusTreeData;

/**
 * Test class for homogeneus tree methods methods
 * 
 * @version 1.1 17 April 2013
 * @author Stella Djulgerova
 */
public class BinaryTreeTest {

	BinaryTree<BinaryTreeData> tree = new BinaryTree<BinaryTreeData>();
	
	/**
	 * Data used for tests
	 * 
	 * @return
	 */
	@DataProvider
	private Object[][] validData() {
		return new Object[][] {
				{ new BinaryTreeData(1, "a"), new BinaryTreeData(7, "f") },
				{ new BinaryTreeData(6, "s"), new BinaryTreeData(4, "g") },
				{ new BinaryTreeData(5, "d"), new BinaryTreeData(1, "h") } };
	}

	
	//tree.insert(new BinaryTreeData(1, "test"));
	
	/**
	 * Test method print.
	 * 
	 * @param 
	 * @param 
	 */
	@Test(dataProvider = "validData")
	public void printTree(Integer[] array, Integer[] valid) {
		//int result = tree.printTree();
		
		Random randomGenerator = new Random();
		for (int i = 0; i < 20; i++) {

			tree.insert(new BinaryTreeData(randomGenerator.nextInt(30), "String " + i));
		}
		tree.search(12);
		//Assert.assertSame(tree.printTree(), valid);
	}
	
	/**
	 * Test method search.
	 * 
	 * @param 
	 * @param 
	 */
	@Test(dataProvider = "validData")
	public void search(Integer[] array, Integer[] valid) {
		//int result = tree.printTree();
		//Assert.assertSame(tree.printTree(), valid);
	}
	
	/**
	 * Test method insert.
	 * 
	 * @param 
	 * @param 
	 */
	@Test(dataProvider = "validData")
	public void insert(Integer[] array, Integer[] valid) {
		//int result = tree.printTree();
		//Assert.assertSame(tree.printTree(), valid);
	}
}
