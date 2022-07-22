package datastructures;

public class LinkedList {

	static class Node {
		Node next;
		int data;

		Node(int x) {
			data = x;
			next = null;
		}
	}

	static void printlist(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.println("data=" + curr.data);
			curr = curr.next;
		}
	}

	static Node insertAtBegin(Node head, int x) {
		Node newNode = new Node(x);
		newNode.next = head;
		return newNode;
	}

	static Node insertAtEnd(Node head, int x1) {
		Node curr = head;
		// 10 20 ref 20 30 ref 30 40 ref 40 null

		Node newNode = new Node(x1);
		//
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = newNode;

		return head;

	}

	static Node deleteAtStart(Node head) {
		if (head == null)
			return null;
		return head.next;
	}

	static void deleteAtEnd(Node head) {

		Node curr = head;

		// 40 10ref 10 20ref 20 30ref 30 null

		while (curr.next.next != null) {
			curr = curr.next;
		}
		curr.next = null;
	}

	static Node insertAtGivenPos(Node head, int pos, int data) {
		Node h = new Node(data);
		Node curr = head;

		// 10 20ref 20 30ref 100 30 null

		for (int i = 1; i <= pos - 2 && curr != null; i++) {

			curr = curr.next;
			// System.out.println("curr.next=" + curr.data);
		}
		if (head == null)
			return null;

		h.next = curr.next;
		curr.next = h;
		return head;

	}

	static Node insertInMid(Node head, int data) {
		int count = 0;
		Node curr = head;
		Node h = new Node(data);

		if (head == null) {
			return h;
		}
		// 1 2 4 5
		// 1 2 3 4 5
		// 1 2 3 5 6

		while (curr != null) {
			count++;
			curr = curr.next;
		}

		int mid = ((count % 2) == 0) ? (count / 2) : (count + 1) / 2;

		curr = head;

		while (mid-- > 1) {
			curr = curr.next;
		}

		// 1 2 3 4
		// 1 2 5 3

		h.next = curr.next;
		curr.next = h;
		return head;

	}

	static Node deleteAtGivenPos(Node head, int pos) {
		// 10 20 30 40 50
		Node curr = head;

		for (int i = 1; i <= pos - 2 && curr != null; i++) {
			curr = curr.next;
		}

		curr.next = curr.next.next;

		return head;
		// 10 20 30 40 50
	}

	static Node deleteInMid(Node head) {
		Node curr = head;

		int count = 0;
		while (curr != null) {
			count++;
			curr = curr.next;
		}

		int mid = ((count % 2) == 0) ? count / 2 : (count + 1) / 2;

		curr = head;
		while (mid-- > 1) {
			curr = curr.next;
		}
		curr.next = curr.next.next;
		return head;
	}

	static Node reverseofList(Node head) {
		Node curr = head;

		// 10 20 30 40
		// 40 30 20 10

		Node next;
		Node prev = null;

		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return head;
		}

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;

		}

		return prev;
	}

	public static void main(String[] args) {

		// simple linked list creation
		Node head = new Node(10);
		Node h1 = new Node(20);
		Node h2 = new Node(30);
		Node h3 = new Node(40);

		head.next = h1;
		h1.next = h2;
		h2.next = h3;
		h3.next = null;

		// deleteINMID
		deleteInMid(head);
		// printlist(head);

		// insert the node at begin
		head = insertAtBegin(head, 100);
		head = insertAtBegin(head, 1);

		// insert at the end
		insertAtEnd(head, 150);

		// insert a node at mid
		insertInMid(head, 45);

		// To check insertmid use this
		// printlist(head);

		// delete at start
		head = deleteAtStart(head);

		// delete at end
		deleteAtEnd(head);

		// insert at given position
		head = insertAtGivenPos(head, 4, 200);

		// delete at given pos
		head = deleteAtGivenPos(head, 2);

		// reverseOfList
		head = reverseofList(head);

		// traverse the linkedlist
		printlist(head);

	}

}
