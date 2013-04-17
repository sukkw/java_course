package com.sirma.itt.javacourse.objects.trees;

import java.util.ArrayList;

/**
 * Create homogeneus tree with generic type of values.
 * 
 * @version 1.1 14 April 2013
 * @author Stella Djulgerova
 */
public class HomogeneusTree<T extends HomogeneusTreeData> {

	/**
	 * Create homogeneus tree node /nested class/.
	 * 
	 * @version 1.1 14 April 2013
	 * @author Stella Djulgerova
	 */
	public static class TreeNode<T extends HomogeneusTreeData> {

		// Class private members
		private T value;
		private boolean hasParent;
		private ArrayList<TreeNode<T>> children;

		/**
		 * Node constructor.
		 * 
		 * @param value
		 */
		public TreeNode(T value) {

			if (value != null) {
				this.value = value;
				this.children = new ArrayList<TreeNode<T>>();

			}
		}

		/**
		 * Add child to a node.
		 * 
		 * @param child
		 */
		public void addChild(TreeNode<T> child) {

			if (child != null) {

				if (!child.hasParent) {
					child.hasParent = true;
					this.children.add(child);
				}
			}
		}

		/**
		 * Gets the child of the node at given index.
		 * 
		 * @param index
		 * @return the child on index position
		 */
		public TreeNode<T> getChild(int index) {
			return this.children.get(index);
		}

		/**
		 * Give number of all children.
		 * 
		 * @return
		 */
		public int getChildrenCount() {
			return this.children.size();
		}

	}

	// The root of the tree
	private TreeNode<T> root;

	/**
	 * Tree constructor.
	 * 
	 * @param value
	 */
	public HomogeneusTree(T value) {

		if (value != null) {
			this.root = new TreeNode<T>(value);
		}
	}

	/**
	 * Tree constructor.
	 * 
	 * @param value
	 * @param children
	 */
	public HomogeneusTree(T value, HomogeneusTree<T>... children) {

		this(value);

		for (HomogeneusTree<T> child : children) {

			this.root.addChild(child.root);
		}
	}

	/**
	 * Print the tree.
	 * 
	 * @param root
	 * @param spaces
	 */
	private void print(TreeNode<T> root, String spaces) {

		if (this.root != null) {

			System.out.println(spaces + root.value.getKey() + "  " + root.value.getData());
			TreeNode<T> child = null;

			for (int i = 0; i < root.getChildrenCount(); i++) {

				child = root.getChild(i);
				print(child, spaces + "    ");

			}

		}

	}

	/**
	 * Print tree wrap method.
	 */
	public void print() {

		this.print(this.root, new String());

	}

}
