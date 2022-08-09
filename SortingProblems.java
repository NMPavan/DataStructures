package datastructures;

import java.util.Arrays;

public class SortingProblems {

	static void swap(int arr[], int j, int k) {

		int temp = arr[j];
		arr[j] = arr[k];
		arr[k] = temp;
	}

	static void bubbleSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	static void selectionSort(int arr[]) {
		// find the minimum element from i+1 to n
		for (int i = 0; i < arr.length - 1; i++) {
			int min_index = i;
			for (int j = i + 1; j < arr.length; j++) {

				if (arr[min_index] > arr[j])
					min_index = j;
			}
			swap(arr, i, min_index);
		}
	}

	public static void main(String[] args) {

		// bubble sort
		int arr[] = { 4, 1, 6, 2, 10, -1 };

		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));

		// selection sort
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
