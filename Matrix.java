package datastructures;

import java.util.*;

public class Matrix {

	static void printList(int arr[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void jaggedArray(int m[][]) {
		for (int i = 0; i < m.length; i++) {
			m[i] = new int[i + 1];
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = i;
				System.out.print(m[i][j] + " ");
			}
			System.out.println();

		}
	}

	static void snakePatternMatrix(int arr[][]) {
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			if (i % 2 == 0) {
				for (int k = 0; k < arr[i].length; k++) {
					System.out.print(arr[i][k] + " ");
				}
			} else {
				for (int j = arr[i].length - 1; j >= 0; j--) {
					System.out.print(arr[i][j] + " ");
				}

			}
		}
	}

	static void matrixBoundryTraversal(int arr[][]) {
		int n = arr.length;
		int rowCount = n;
		int colCount = n;
		if (rowCount == 1) {
			for (int i = 0; i < colCount; i++) {
				System.out.println(arr[0][i]);
			}
		}

		else if (colCount == 1) {
			for (int j = 0; j < rowCount; j++) {
				System.out.println(arr[j][0] + " ");
			}
		} else {
			for (int i = 0; i < colCount; i++) {
				System.out.print(arr[0][i] + " ");
			}
			for (int k = 1; k < rowCount; k++) {
				System.out.print(arr[k][colCount - 1] + " ");
			}
			for (int l = colCount - 2; l >= 0; l--) {
				System.out.print(arr[rowCount - 1][l] + " ");
			}

			for (int m = rowCount - 2; m >= 1; m--) {
				System.out.print(arr[m][0] + " ");
			}

		}

		System.out.println();
	}

	static void swap(int A, int B, int M[][]) {

		int temp = M[A][B];
		M[A][B] = M[B][A];
		M[B][A] = temp;

	}

	static void transpose(int arr[][]) {

		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {
				swap(i, j, arr);
			}

		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void swap2(int low, int high, int i, int mat[][]) {
		int temp = mat[low][i];
		mat[low][i] = mat[high][i];
		mat[high][i] = temp;
	}

	static void rotateBy90(int arr[][]) {

		for (int i = 0; i < arr.length; i++)
			for (int j = i + 1; j < arr.length; j++) {
				swap(i, j, arr);
			}

		for (int i = 0; i < arr.length; i++) {
			int low = 0;
			int high = arr.length - 1;

			while (low < high) {
				swap2(low, high, i, arr);
				low++;
				high--;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	static boolean search(int matrix[][], int n, int m, int x) {
		// code here
		int i = 0, j = m - 1;

		while (i < n && j >= 0) {

			if (matrix[i][j] == x) {
				return true;
			}

			if (matrix[i][j] > x) {
				j--;
			} else {
				i++;
			}
		}

		return false;
	}

	static ArrayList<Integer> spirallyTraverse(int mat[][], int r, int c) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int top = 0, bottom = r - 1, right = c - 1, left = 0;

		while (top <= bottom && left <= right) {

			for (int i = left; i <= right; i++) {
				arr.add(mat[top][i]);
			}
			top++;

			for (int j = top; j <= bottom; j++) {
				arr.add(mat[j][right]);
			}
			right--;

			if (top <= bottom) {
				for (int k = right; k >= left; k--) {
					arr.add(mat[bottom][k]);
				}
			}
			bottom--;

			if (left <= right) {
				for (int l = bottom; l >= top; l--) {
					arr.add(mat[l][left]);
				}
			}
			left++;
		}
		return arr;
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		printList(arr, arr.length);

		System.out.println();

		// jagged Array
		int m[][] = new int[3][];
		jaggedArray(m);

		int arr1[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12, 14 } };
		// snake pattern
		snakePatternMatrix(arr1);

		System.out.println("...");

		// Matrix Boundry Traversal
		matrixBoundryTraversal(arr);

		System.out.println("");

		// Transpose of Matrix
		transpose(arr);

		System.out.println("");

		// Rotate an matrix by 90 degree
		rotateBy90(arr);

		// Search in a row-column sorted Matrix
		System.out.println(search(arr, 3, 3, 9));

		// Spriral matrix
		System.out.println(spirallyTraverse(arr, 3, 3));

	}

}
