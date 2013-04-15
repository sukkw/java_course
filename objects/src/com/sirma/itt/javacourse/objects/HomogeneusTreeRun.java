package com.sirma.itt.javacourse.objects;

import com.sirma.itt.javacourse.objects.HomogeneusTree.TreeNode;

/**
 * Fill homogeneus tree with random values and print it on screen
 * 
 * @version 1.1 14 April 2013
 * @author Stella Djulgerova
 */
public class HomogeneusTreeRun {
	
	/**
	 * Class main method
	 * @param args
	 */
	public static void main(String[] args) {

		//fill tree with data
        HomogeneusTree<HomogeneusTreeData> tree = new HomogeneusTree<HomogeneusTreeData>(new HomogeneusTreeData(7, "Stella"),

                        new HomogeneusTree<HomogeneusTreeData>(new HomogeneusTreeData(19, "Stella"),

                                    new HomogeneusTree<HomogeneusTreeData>(new HomogeneusTreeData(1, "Ani")),

                                    new HomogeneusTree<HomogeneusTreeData>(new HomogeneusTreeData(12, "Stefan")),

                                    new HomogeneusTree<HomogeneusTreeData>(new HomogeneusTreeData(31, "Ivan"))),

                        new HomogeneusTree<HomogeneusTreeData>(new HomogeneusTreeData(21, "Mariana")),

                        new HomogeneusTree<HomogeneusTreeData>(new HomogeneusTreeData(14, "Oleg"),

                                    new HomogeneusTree<HomogeneusTreeData>(new HomogeneusTreeData(23, "Todor")),

                                    new HomogeneusTree<HomogeneusTreeData>(new HomogeneusTreeData(6, "Neli"),
                                    		new HomogeneusTree<HomogeneusTreeData>(new HomogeneusTreeData(4, "Marin"))))

            );
		
        //print tree
        tree.print();

  }
}
