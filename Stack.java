package datastructures;

import java.util.*;

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

class ArrayStack {
	ArrayList<Integer> a1 = new ArrayList<Integer>();

	void push(int x) {
		a1.add(x);
	}

	int pop() {
		return a1.remove(a1.size() - 1);
	}

	boolean isEmpty() {
		return a1.isEmpty();
	}

	int size() {
		return a1.size();
	}

	int peek() {
		return a1.get(a1.size() - 1);
	}

}

class LinkedListStack {
	Node head;
	int sz;

	LinkedListStack() {
		head = null;
		sz = 0;
	}

	void push(int data) {
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
		sz++;
	}

	int pop() {
		if (head == null) {
			return Integer.MAX_VALUE;
		}
		int res = head.data;
		head = head.next;
		sz--;
		return res;
	}

	int peek() {
		return head.data;
	}

	int size() {
		return sz;
	}

	boolean isEmpty() {
		return head == null;
	}
}

public class Stacks {

	public static boolean matching(char a, char b) {
		return ((a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}'));
	}

	static boolean parenthesisChecker(String str) {
		Stack<Character> s = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '[' || str.charAt(i) == '(' || str.charAt(i) == '{') {
				s.add(str.charAt(i));
			} else {
				if (s.isEmpty())
					return false;
				else if (matching(s.peek(), str.charAt(i)) == false)
					return false;
				else {
					s.pop();
				}

			}
		}
		return (s.isEmpty() == true);
	}

	static void stockSpan(int arr[], int n) {

		Stack<Integer> s = new Stack<Integer>();
		s.add(0);
		System.out.print(1 + " ");

		// 18,12,13,14,11,16
		// intially push index 0 to stack
		// traverse from 12 from index 1
		// inside while always find the previous greater element by comparing with
		// current
		for (int i = 1; i < n; i++) {
			while (s.isEmpty() == false && arr[s.peek()] <= arr[i]) { // 18<=12 = false//12<=13 so remove 1 index from
																		// stack again check same
				s.pop();
			}

			int span = s.isEmpty() ? i + 1 : i - s.peek();// 1 - 0 = 1//2-0//
			System.out.print(span + " "); // 1
			s.push(i);// 0 1
		}
	}

	static void previousGreater(int arr[], int n) {
		Stack<Integer> s1 = new Stack<Integer>();

		s1.add(arr[0]);

		for (int i = 0; i < n; i++) {
			while (s1.isEmpty() == false && s1.peek() <= arr[i]) {
				s1.pop();
			}

			int pg = s1.isEmpty() ? -1 : s1.peek();

			System.out.print(pg + " ");
			s1.add(arr[i]);
		}

	}

	static ArrayList<Integer> nextGreaterElement(int arr[], int n) {
		Stack<Integer> s2 = new Stack<Integer>();

		ArrayList<Integer> a1 = new ArrayList<Integer>();

		s2.add(arr[n - 1]);
		a1.add(-1);

		for (int i = n - 2; i >= 0; i--) {
			while (s2.isEmpty() == false && s2.peek() <= arr[i]) {
				s2.pop();
			}

			int ng = s2.isEmpty() ? -1 : s2.peek();
			a1.add(ng);
			s2.add(arr[i]);

		}

		Collections.reverse(a1);

		return a1;

	}

	static boolean AknowsB(int M[][], int A, int B) {
		if (M[A][B] == 1)
			return true;
		else
			return false;
	}

	// Function to find if there is a celebrity in the party or not.
	static int celebrity(int M[][], int n) {
		// code here
		Stack<Integer> s = new Stack<Integer>();

		// step1: push all elemnts of given n till n-1 to stack
		for (int i = 0; i < n; i++) {
			s.push(i);
		}

		// step 2: iterate the stack until stack.size() 1 for finding celebrity
		while (s.size() > 1) {
			int A = s.peek();
			s.pop();
			int B = s.peek();
			s.pop();

			if (AknowsB(M, A, B)) {
				s.push(B);
			} else {
				s.push(A);
			}
		}

		int potentialCandiate = s.peek();

		// step 3: verify the potential Candidate
		// 2 things to verify 1 is the celebrity row will be all '0'
		// and its columns will be 1 except the diagonal element

		int zeroCount = 0;

		int oneCount = 0;

		for (int i = 0; i < n; i++) {
			if (M[potentialCandiate][i] == 0)
				zeroCount++;

			if (M[i][potentialCandiate] == 1)
				oneCount++;
		}

		if (zeroCount != n)
			return -1;

		if (oneCount != n - 1)
			return -1;

		return potentialCandiate;

	}

	public static void main(String[] args) {
		ArrayStack s1 = new ArrayStack();

		s1.push(20);
		s1.push(30);
		System.out.println(s1.peek());

		s1.pop();

		System.out.println(s1.peek());

		LinkedListStack l1 = new LinkedListStack();

		l1.push(30);
		l1.push(25);
		l1.pop();

		System.out.println(l1.size());

		// balanced Parenthesis
		String s = "{()}[]";
		if (parenthesisChecker(s)) {
			System.out.println("Yes");
		} else {
			System.out.println("NO");
		}

		//stock span problem
		int[] arr = new int[] { 18, 12, 13, 14, 11, 16 };
		stockSpan(arr, arr.length);

		System.out.println();

		// previous Greater Problem
		previousGreater(arr, arr.length);

		System.out.println();

		// Next greater Problem
		int arr1[] = { 5, 15, 10, 8, 6, 12, 9, 18 };

		System.out.println("next greater elements:= " + nextGreaterElement(arr1, arr1.length));

		// celebrity probelm
		int M[][] = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 } };
		System.out.println();
		System.out.println("potential=" + celebrity(M, 3));

	}

}
