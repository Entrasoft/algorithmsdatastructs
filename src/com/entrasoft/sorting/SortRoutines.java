/**
 * 
 */
package com.entrasoft.sorting;

import java.util.Arrays;
import java.util.Random;

import com.entrasoft.datastructs.BinarySearchTree;
import com.entrasoft.datastructs.BinarySearchTree.Node;

/**
 * @author Chris Deschenes Entrasoft, Inc. 2013
 * 
 *         Implementation of merge sort.
 * 
 */
public class SortRoutines {

	/**
	 * @param args
	 */
	public static int[] numArray;
	public static int sizeArray = 20;

	public static void main(String[] args) {

		// Create an array of numbers to work with
		// Size is adjustable with sizeArray parameter
		numArray = new int[sizeArray];

		// Generate random numbers - simple uniform distribution is
		// sufficient
		Random generator = new Random();

		int i = 0;
		for (i = 0; i < sizeArray; i++) {
			numArray[i] = generator.nextInt(sizeArray);
		}

		// Output the unsorted array
		System.out.println(Arrays.toString(numArray));

		// Sort using insertion sort
		int[] numArraySorted = insertionsort(numArray);

		// Output the sorted array
		System.out.println(Arrays.toString(numArraySorted));
		
		// Create another array
		for (i = 0; i < sizeArray; i++) {
			numArray[i] = generator.nextInt(sizeArray);
		}
		
		// Output the unsorted array
		System.out.println("Array for mergesort");
		System.out.println(Arrays.toString(numArray));
		
		// Sort using merge sort -- int and even number of elements only!
		//numArraySorted = mergesort(numArray);
		//System.out.println(Arrays.toString(numArraySorted));
		
		// Binary Search tree fun
		// Build a 3 node tree (1, 2, 3)
		Node root = new Node(10);
		Node left = new Node(5);
		Node right = new Node(15);
		Node left1 = new Node(14);
		Node left2 = new Node(16);
		
		root.left = left;
		root.right = right;
		
		right.left = left1;
		right.right = left2;
		
		// Print it
		BinarySearchTree.printTree(root);
		
		// Get the size
		int treeSize = BinarySearchTree.size(root);
		System.out.println("Size is: " + treeSize );
		
		// Get the max depth
		int maxDepth = BinarySearchTree.maxDepth(root);
		System.out.println("Max depth: " + maxDepth);
		
		// Find the minimum
		int min = BinarySearchTree.min(root);
		System.out.println("Min value: " + min);
		
		// Find the max
		int max = BinarySearchTree.max(root);
		System.out.println("Max value: " + max);
		
		// Insert a value
		BinarySearchTree.insert(root, 13);
		BinarySearchTree.printTree(root);
		
	}

	public static int[] insertionsort(int[] numArray) {
		// Sort the array using insertion sort
		// Good for small number of elements <= 7 otherwise use quicksort etc.
		// This sorts in place with at most n elements outside the array
		// It is loop invariant
		// and I believe it operates at O(n**2).

		int i = 0;
		int j = 0;
		int key = 0;
		for (i = 1; i < numArray.length; i++) {
			key = numArray[i];
			j = i - 1;
			while (j >= 0 && numArray[j] < key) {
				numArray[j + 1] = numArray[j];
				j = j - 1;
			}
			numArray[j + 1] = key;
		}

		return numArray;

	}

	public static int[] mergesort(int[] numArray) {
	
		// if the array length is 0 or 1 consider it sorted and return it
		if (numArray.length < 2){
			return numArray;
		}
		
		// Split the left and right arrays
		// ToDo modify this to work of for odd length arrays
		int m = numArray.length / 2;
		int n1 = m;
		int n2 = m;
		int[] L = new int[n1];
		int[] R = new int[n2];

		// Populate the left and right arrays
		for (int i = 0; i < n1; i++) {
			L[i] = numArray[i];
		}

		for (int j = 0; j < n2; j++) {
			R[j] = numArray[n1 + j];
		}

		// Recursively call mergesort() to continue to split until length = 1
		L = mergesort(L);
		R = mergesort(R);
		numArray = merge(L, R);
	
		// Retrun the sorted list
		return numArray;
	}
	
	public static int[] merge(int[] LArray, int[] RArray) {
		// Merge left and right arrays

		int n = LArray.length + RArray.length;
		int[] Result;
		
		Result = new int[n];
		
		
		while (LArray.length > 0 || RArray.length > 0){
			int k = 0;
			if (LArray.length > 0 && RArray.length > 0){
				// compare elements
				if (LArray[0] <= RArray[0]){
						System.out.print("K: " + k + "\n" + Result[k] + "\n");
						Result[k] = LArray[0];
				
					// copy the rest of the array
					int[] temp;
					temp = new int[LArray.length-1];
					
					System.arraycopy(LArray, 1, temp, 0, LArray.length-1);
					LArray = temp;
				} else {
					Result[k] = RArray[0];
					
					// copy the rest of the array
					int[] temp;
					temp = new int[RArray.length-1];
					
					System.arraycopy(RArray, 1, temp, 0, RArray.length-1);
					RArray = temp;
				}
			} else if (LArray.length > 0) {
					Result[k] = LArray[0];

				// copy the rest of the array
				int[] temp;
				temp = new int[LArray.length-1];
				
				System.arraycopy(LArray, 1, temp, 0, LArray.length-1);
				LArray = temp;
			} else if (RArray.length > 0){
				
					Result[k] = RArray[0];
			
				// copy the rest of the array
				int[] temp;
				temp = new int[LArray.length-1];
				System.arraycopy(RArray, 1, temp, 0, LArray.length-1);
			}
			k++;
		}
		return numArray;
	}
	
}
