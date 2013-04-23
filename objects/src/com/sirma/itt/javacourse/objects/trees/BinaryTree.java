package com.sirma.itt.javacourse.objects.trees;

/**
 * Create binary tree.
 * 
 * @version 1.1 14 April 2013
 * @author Stella Djulgerova
 */
public class BinaryTree<T extends Comparable<T>> {

	/**
	 * Create binary tree node /nested class/
	 * 
	 * @version 1.1 14 April 2013
	 * @author Stella Djulgerova
	 */
	public static class BinaryTreeNode<T extends Comparable<T>> implements
			Comparable<BinaryTreeNode<T>> {

		// Class private members
		public T value;
		private BinaryTreeNode<T> parent;
		private BinaryTreeNode<T> leftChild;
		private BinaryTreeNode<T> rightChild;

		/**
		 * Nodes constructor.
		 * 
		 * @param value - node value
		 */
		public BinaryTreeNode(T value) {
			this.value = value;
			this.parent = null;
			this.leftChild = null;
			this.rightChild = null;
		}

		@Override
		public int compareTo(BinaryTreeNode<T> nodeValue) {
			return this.value.compareTo(nodeValue.value);
		}
		
	}

	// root of the tree
	private BinaryTreeNode<T> root;

	/**
	 * Tree default constructor.
	 */
	public BinaryTree() {
		this.root = null;
	}

	/**
	 * Insert value in the tree (wrap method).
	 * 
	 * @param value - value to be inserted
	 */
	public void insert(T value) {
		if (value != null) {
			this.root = insert(value, null, root);
		}
	}

	/**
	 * Insert node in the tree.
	 * 
	 * @param value - value to be inserted
	 * @param parentNode - the parent of node
	 * @param node - current node
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
	 * Finds a given value in the tree and returns the node.
	 * 
	 * @param value - the value to be found.
	 * @return the found node or null if not found.
	 */
	public BinaryTreeNode<T> search(T value) {

		BinaryTreeNode<T> node = this.root;

		while (node != null) {
			int compareTo = value.compareTo(node.value);
			if (compareTo < 0) {
				node = node.leftChild;
			} else if (compareTo > 0) {
				node = node.rightChild;
			} else {
				break;
			}
		}

		if (node != null) {
			System.out.println("Turseniq element e: " + node.value);
		} else {
			System.out.println("Elementa ne syshtestvuva");
		}
		return node;
	}

	/**
	 * Print elements of the tree wrap method.
	 */
	public void printTree() {
		this.printTree(this.root);
	}

	/**
	 * Print elements of the tree sorted.
	 * 
	 * @param node - tree node (root at beginning)
	 */
	public void printTree(BinaryTreeNode<T> node) {

		if (node != null) {
			printTree(node.leftChild);
			System.out.println(node.value);
			printTree(node.rightChild);
		}
	}

}