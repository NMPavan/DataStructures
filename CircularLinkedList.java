package datastructures;

public class CircularLinkedList {

	static class Node {
		Node next;
		int data;

		Node(int x) {
			data = x;
			next = null;
		}
	}

	// O(N)
	static Node insertAtBegin(Node head, int data) {
		Node temp = new Node(data);
		if (head == null) {
			temp.next = temp;
			return temp;
		}
		Node curr = head;

		while (curr.next != head) {
			curr = curr.next;
		}
		curr.next = temp;
		temp.next = head;

		return temp;
	}

	// O(1)

	static Node insertAtBeginOne(Node head, int data) {
		Node temp = new Node(data);

		if (head == null) {
			temp = temp.next;
			return temp;
		} else {

			// 10 20 30 --> insert in between 10 and 20 --> 15 20 30
			temp.next = head.next;
			head.next = temp;
			int t = head.data;
			head.data = temp.data;
			temp.data = t;
			return head;

		}
	}

	// O(N)
	static Node insertAtEnd(Node head, int data) {
		Node temp = new Node(data);
		if (head == null) {
			temp.next = temp;
			return temp;
		}
		Node curr = head;

		while (curr.next != head) {
			curr = curr.next;
		}
		curr.next = temp;
		temp.next = head;

		return head;
	}

	static Node insertAtEndOne(Node head, int data) {
		Node temp = new Node(data);

		if (head == null) {
			temp = temp.next;
			return temp;
		} else {
			temp.next = head.next;
			head.next = temp;
			int t = head.data;
			head.data = temp.data;
			temp.data = t;
			return temp;

		}
	}

	static void printList(Node head) {
		Node curr = head;

		do {
			System.out.println("curr.data=" + curr.data);
			curr = curr.next;
		} while (curr != head);
	}

	public static void main(String[] args) {

		Node head = new Node(10);
		Node temp = new Node(20);
		Node temp1 = new Node(30);

		head.next = temp;
		temp.next = temp1;
		temp1.next = head;

		// insertAtBegin O(N)
		// head = insertAtBegin(head, 5);

		head = insertAtBeginOne(head, 5);

		// O(N)
		// head = insertAtEnd(head,50);

		head = insertAtEndOne(head, 50);

		// traverse the list
		printList(head);
	}

}
