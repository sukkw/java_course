package com.sirma.itt.javacourse.objects;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sirma.itt.javacourse.objects.trees.HomogeneusTree;
import com.sirma.itt.javacourse.objects.trees.HomogeneusTreeData;

/**
 * Test class for homogeneus tree methods
 * 
 * @version 1.1 18 April 2013
 * @author Stella Djulgerova
 */
public class HomogeneusTreeTest {

	/**
	 * Test method print
	 * 
	 * @param inputData
	 * @param valid
	 */
	@Test
	public void printTree() {
		//fill tree with data
        HomogeneusTree<HomogeneusTreeData> tree = new HomogeneusTree<HomogeneusTreeData>(new HomogeneusTreeData(7, "Stella"),

                        new HomogeneusTree<HomogeneusTreeData>(new HomogeneusTreeData(19, "Eli"),

                                    new HomogeneusTree<HomogeneusTreeData>(new HomogeneusTreeData(1, "Ani")),

                                    new HomogeneusTree<HomogeneusTreeData>(new HomogeneusTreeData(12, "Stefan")),

                                    new HomogeneusTree<HomogeneusTreeData>(new HomogeneusTreeData(31, "Ivan"))),

                        new HomogeneusTree<HomogeneusTreeData>(new HomogeneusTreeData(21, "Mariana")),

                        new HomogeneusTree<HomogeneusTreeData>(new HomogeneusTreeData(14, "Oleg"),

                                    new HomogeneusTree<HomogeneusTreeData>(new HomogeneusTreeData(23, "Todor")),

                                    new HomogeneusTree<HomogeneusTreeData>(new HomogeneusTreeData(6, "Neli"),
                                    		new HomogeneusTree<HomogeneusTreeData>(new HomogeneusTreeData(4, "Marin"))))

            );
        
        tree.print();
	}

}
