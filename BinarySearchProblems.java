package datastructures;

public class BinarySearchProblems {

	static int iterativeBinarySearch(int arr[], int n, int x) {
		int low = 0, high = n - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (x == arr[mid])
				return mid;
			else if (x > arr[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}

		return -1;

	}

	static int recursiveBS(int arr[], int low, int high, int x) {
		int mid = (low + high) / 2;

		if (low > high)
			return -1;

		if (x == arr[mid])
			return mid;
		else if (x > arr[mid])
			return recursiveBS(arr, mid + 1, high, x);
		else
			return recursiveBS(arr, low, mid - 1, x);

	}

	static int firstOcc(int arr[], int n, int x) {

		int low = 0, high = n - 1;

		while (low <= high) {

			int mid = (low + high) / 2;
			if (x > arr[mid])
				low = mid + 1;
			else if (x < arr[mid])
				high = mid - 1;
			else {
				if (mid == 0 || arr[mid - 1] != arr[mid])
					return mid;
				else
					high = mid - 1;
			}
		}

		return -1;

	}

	static int lassOccu(int arr[], int low, int high, int x) {

		if (low > high)
			return -1;

		int mid = (low + high) / 2;

		if (x > arr[mid])
			return lassOccu(arr, mid + 1, high, x);
		else if (x < arr[mid])
			return lassOccu(arr, low, mid - 1, x);
		else {
			if (mid == 0 || arr[mid + 1] != arr[mid])
				return mid;
			else
				return lassOccu(arr, mid + 1, high, x);
		}

	}

	static int countOcc(int arr[], int n, int x) {
		int first = firstOcc(arr, n, x);
		int last = lassOccu(arr, 0, n - 1, x);
		if (last - first > 0) {
			return last - first + 1;
		} else
			return 0;
	}

	static int countnoOf1(int arr[], int n, int x) {
		int high = n - 1;
		int first = firstOcc(arr, n, x);
		if (first == -1)
			return 0;
		else
			return high - first + 1;

	}

	static int sqreOfNumber(int x) {
//
//		int i=1;
//		while(i*i <=x)
//			i++;
//		
//		return i-1;
//
		// 10 --> 1 to 10 --> 1+ 10/ 2 = 5 --> 5*5 = 25 -> then ele -> left half
		// so high = mid -1
		// 1 to 5 ==> 3 is mid then 3 * 3 --> 10 < 9 -> F so goes to else -> ans = mid
		// 3,4 --> then both at 4 --> high = 4-1 = 3-> next itr -> 4<=3 breaks the loop
		// ans = 3 finally
		int low = 1, high = x, ans = -1;

		while (low <= high) {
			int mid = (low + high) / 2;
			int mSq = mid * mid;

			if (mSq == x)
				return mid;
			else if (x < mSq) {
				high = mid - 1;
			}

			else {
				low = mid + 1;
				ans = mid;
			}

		}

		return ans;
	}

	static int search(int arr[], int x) {

		if (arr[0] == x)
			return 0;
		int i = 1;

		while (arr[i] < x)
			i = i * 2;

		if (arr[i] == x)
			return i;

		return recursiveBS(arr, i / 2 + 1, i - 1, x);
	}

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 50, 60 }, n = 6;

		int x = 21;

		// iterative BS
		System.out.println(iterativeBinarySearch(arr, arr.length, x));

		// recursive BS
		System.out.println(recursiveBS(arr, 0, arr.length - 1, x));

		// firstOccurences of element
		int arr1[] = { 5, 6, 7, 10, 10, 10, 10, 20 }, n1 = 8;
		int x1 = 10;
		System.out.println(firstOcc(arr1, n1, x1));

		// lastoccurences of element
		System.out.println(lassOccu(arr1, 0, n1 - 1, x1));

		// countOccurences
		System.out.println(countOcc(arr1, n1, x1));

		int arr2[] = { 1, 1, 1, 1, 1 };
		int d = 1;
		int n2 = 5;
		System.out.println(countnoOf1(arr2, n2, d));

		// squareRoot of given input
		System.out.println(sqreOfNumber(10));

		// search in infinity matrix
		int arr4[] = { 1, 2, 3, 40, 50 };
		int x4 = 40;
		System.out.println(search(arr4, x4));

	}
}
