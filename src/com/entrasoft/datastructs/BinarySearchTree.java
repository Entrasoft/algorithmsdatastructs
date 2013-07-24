package com.entrasoft.datastructs;


public class BinarySearchTree {

	/**
	 * @param args
	 */

	// Root node pointer. Is null for an empty tree.
	private static Node root;

	/*
	 * Need to define a node. The binary tree is built using this nested node
	 * class. Each node stores one data element, and has left and right sub-tree
	 * pointers which may be null.
	 */

	public static class Node {
		public Node left;
		public Node right;
		public int data;

		public Node(int newData) {
			left = null;
			right = null;
			data = newData;
		}
	}

	/*
	 * Create an empty binary tree -
	 */
	public BinarySearchTree() {
		root = null;
	}

	/*
	 * Returns true if the given target is in the binary tree.
	 */
	public boolean lookup(int data) {
		return (lookup(root, data));
	}

	/*
	 * Recursive lookup - given a node recurse down
	 */
	private boolean lookup(Node node, int data) {
		if (node == null) {
			return false;
		}
		if (data == node.data) {
			return true;
		} else if (data < node.data) {
			return (lookup(node.left, data));
		} else {
			return (lookup(node.right, data));
		}

	}

	/*
	 * Insert
	 */
	public void insert(int data) {
		root = insert(root, data);
	}

	/*
	 * Recursive insert
	 */
	public static Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		} else {
			if (data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		return (node);
	}

	/*
	 * Print the node values in the inorder order.
	 */
	public static void printTree(Node node) {
		if (node == null)
			return;

		// left, node, right
		printTree(node.left);
		System.out.println(node.data + " ");
		printTree(node.right);
	}

	/*
	 * Return the size of a tree
	 */
	public static int size(Node node) {
		if (node == null)
			return (0);
		else {
			return (size(node.left) + 1 + size(node.right));
		}
	}

	/*
	 * Return the maximum depth from root to leaf of the tree
	 */
	public static int maxDepth(Node node) {
		if (node == null)
			return (0);
		else {
			int leftDepth = maxDepth(node.left);
			int rightDepth = maxDepth(node.right);

			return (Math.max(leftDepth, rightDepth) + 1);
		}
	}

	/*
	 * Return the min value from the tree
	 */
	public static int min(Node node) {
		Node current = node;
		while (current.left != null) {
			current = current.left;
		}
		return (current.data);
	}

	/*
	 * Return the max value
	 */

	public static int max(Node node) {
		Node current = node;
		while (current.right != null) {
			current = current.right;
		}
		return current.data;
	}
}
