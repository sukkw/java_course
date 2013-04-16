package com.sirma.itt.javacourse.objects.trees;

import java.lang.reflect.Field;

/**
 * Create binary tree
 * 
 * @version 1.1 14 April 2013
 * @author Stella Djulgerova
 */
public class HeterogeneusTree<T extends HeterogeneusTreeData> {

	/**
	 * Create binary tree node /nested class/
	 * 
	 * @version 1.1 14 April 2013
	 * @author Stella Djulgerova
	 */
	private static class HeterogeneusTreeNode<T extends HeterogeneusTreeData> {

		// Class private members
		private T value;
		private HeterogeneusTreeNode<T> parent;
		private HeterogeneusTreeNode<T> leftChild;
		private HeterogeneusTreeNode<T> rightChild;

		/**
		 * nodes constructor
		 * 
		 * @param value
		 */
		public HeterogeneusTreeNode(T value) {
			this.value = value;
			this.parent = null;
			this.leftChild = null;
			this.rightChild = null;
		}
	}

	// root of the tree
	private HeterogeneusTreeNode<T> root;

	/**
	 * Tree default constructor
	 */
	public HeterogeneusTree() {
		this.root = null;
	}

	/**
	 * Insert value in the tree wrap method
	 * 
	 * @param value
	 */
	public void insert(T value) {

		if (value != null) {
			this.root = insert(value, null, root);
		}
	}

	/**
	 * Insert node in the tree
	 * 
	 * @param value
	 * @param parentNode
	 * @param node
	 * @return last inserted node
	 */
	private HeterogeneusTreeNode<T> insert(T value, HeterogeneusTreeNode<T> parentNode,
			HeterogeneusTreeNode<T> node) {

		if (node == null) {

			node = new HeterogeneusTreeNode<T>(value);
			node.parent = parentNode;

		} else {

			int compareTo = value.compareTo(node.value);
			if (compareTo < 0) {

				node.leftChild = insert(value, node, node.leftChild);

			} else if (compareTo > 0) {

				node.rightChild = insert(value, node, node.rightChild);
			}

		}
		return node;
	}

	/**
	 * search in the tree wrap method
	 * 
	 * @param value
	 */
	public void search(int key) {

		if (search(key, root) != null) {
			System.out.println("Turseniq element e: " + search(key, root).value.getKey() + " "
					+ search(key, root).value.getData());
		} else {
			System.out.println("Elementa ne syshtestvuva");
		}
	}

	/**
	 * Insert node in the tree
	 * 
	 * @param value
	 * @param parentNode
	 * @param node
	 * @return last inserted node
	 */
	private HeterogeneusTreeNode<T> search(int key, HeterogeneusTreeNode<T> node) {

		if (node == null) {

			return null;

		} else {

			if (key < node.value.getKey()) {

				return search(key, node.leftChild);

			} else if (key > node.value.getKey()) {

				return search(key, node.rightChild);
			}

		}
		return node;
	}

	/**
	 * Print elements of the tree wrap method
	 */
	public void printTree() {
		try {
			this.printTree(this.root);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Print elements of the tree sorted
	 * 
	 * @param node
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public void printTree(HeterogeneusTreeNode<T> node) throws IllegalArgumentException,
			IllegalAccessException {

		if (node != null) {

			printTree(node.leftChild);
			if (node.value.getData() instanceof HeterogeneusTreeData) {

				//try to get object fields with reflection
				Object someObject = node.value.getData();
				System.out.print(" Object type");
				for (Field field : someObject.getClass().getDeclaredFields()) {
					//Set modifier to public.
					field.setAccessible(true); 
					Object val = field.get(someObject);
					if (val != null) {
						System.out.print(" " + val);
					}
				}

				System.out.println();
			} else {
				System.out.println(" Simple type " + node.value.getKey() + "  "
						+ node.value.getData());
			}
			printTree(node.rightChild);
		}
	}
}
