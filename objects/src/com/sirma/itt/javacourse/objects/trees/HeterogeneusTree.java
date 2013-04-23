package com.sirma.itt.javacourse.objects.trees;

/**
 * Create heterogeneus tree.
 * 
 * @version 1.1 14 April 2013
 * @author Stella Djulgerova
 */
public class HeterogeneusTree<T extends HeterogeneusTreeData> {

	/**
	 * Create binary tree node /nested class/.
	 * 
	 * @version 1.1 14 April 2013
	 * @author Stella Djulgerova
	 */
	public static class HeterogeneusTreeNode<T extends HeterogeneusTreeData> {

		// Class private members
		public T value;
		private HeterogeneusTreeNode<T> parent;
		private HeterogeneusTreeNode<T> leftChild;
		private HeterogeneusTreeNode<T> rightChild;

		/**
		 * Nodes constructor.
		 * 
		 * @param value - value of node
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
	 * Tree default constructor.
	 */
	public HeterogeneusTree() {
		this.root = null;
	}

	/**
	 * Insert value in the tree wrap method.
	 * 
	 * @param value - value of node
	 */
	public void insert(T value) {
		if (value != null) {
			this.root = insert(value, null, root);
		}
	}

	/**
	 * Insert node in the tree.
	 * 
	 * @param value - value to be added
	 * @param parentNode - parent node
	 * @param node - current node
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
	 * Finds a given value in the tree and returns the node.
	 * 
	 * @param value - the value to be found.
	 * @return the found node or null if not found.
	 */
	public HeterogeneusTreeNode<T> search(T value) {

		HeterogeneusTreeNode<T> node = this.root;

		while (node != null) {
			int compareTo = value.compareTo(node.value.getData());
			if (compareTo < 0) {
				node = node.leftChild;
			} else if (compareTo > 0) {
				node = node.rightChild;
			} else {
				break;
			}
		}

		if (node != null) {
			System.out.println("Turseniq element e: " + node.value.getData());
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
	 * @param node - current node (root at beginning of print)
	 */
	private void printTree(HeterogeneusTreeNode<T> node) {

		if (node != null) {
			printTree(node.leftChild);
			System.out.println(node.value.getData());
			printTree(node.rightChild);
		}
	}
}
