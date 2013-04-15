package com.sirma.itt.javacourse.objects;

/**
 * Create binary tree
 * 
 * @version 1.1 14 April 2013
 * @author Stella Djulgerova
 */
public class BinaryTree<T extends BinaryTreeData> {

	/**
	 * Create binary tree node /nested class/
	 * 
	 * @version 1.1 14 April 2013
	 * @author Stella Djulgerova
	 */
	private static class BinaryTreeNode<T extends BinaryTreeData> {

		// Class private members
		private T value;
		private BinaryTreeNode<T> parent;
		private BinaryTreeNode<T> leftChild;
		private BinaryTreeNode<T> rightChild;

		/**
		 * nodes constructor
		 * 
		 * @param value
		 */
		public BinaryTreeNode(T value) {
			this.value = value;
			this.parent = null;
			this.leftChild = null;
			this.rightChild = null;
		}
	}

	// root of the tree
	private BinaryTreeNode<T> root;

	/**
	 * Tree default constructor
	 */
	public BinaryTree() {
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
	private BinaryTreeNode<T> insert(T value, BinaryTreeNode<T> parentNode, BinaryTreeNode<T> node) {

		if (node == null) {

			node = new BinaryTreeNode<T>(value);
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
	private BinaryTreeNode<T> search(int key, BinaryTreeNode<T> node) {

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
		this.printTree(this.root);
	}

	/**
	 * Print elements of the tree sorted
	 * 
	 * @param node
	 */
	public void printTree(BinaryTreeNode<T> node) {

		if (node != null) {
			printTree(node.leftChild);
			System.out.println(node.value.getKey() + "  " + node.value.getData());
			printTree(node.rightChild);
		}
	}
}
