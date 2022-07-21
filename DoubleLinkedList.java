package datastructures;

public class DoubleLinkedList {

	static class Node {
		Node next;
		Node prev;
		int data;

		Node(int x) {
			data = x;
			next = null;
			prev = null;
		}
	}

	static Node inserAtBegin(Node head, int data) {
		Node newNode = new Node(data);

		if (head == null) {
			return newNode;
		}
		newNode.next = head;
		head.prev = newNode;

		return newNode;
	}

	static Node insertAtEnd(Node head, int data) {
		Node curr = head;

		Node newNode = new Node(data);

		while (curr.next != null) {
			curr = curr.next;
		}

		if (head == null) {
			return newNode;
		}

		curr.next = newNode;
		newNode.prev = curr;

		return head;
	}

	static void printList(Node head) {
		Node curr = head;

		// 10 20ref 20 30ref 30 null
		while (curr != null) {
			// System.out.println("curr.prev=" + curr.prev);
			System.out.println("curr.data=" + curr.data);
			// System.out.println("curr.next=" + curr.next);

			curr = curr.next;
		}
	}

	static Node DeleteAtFirst(Node head) {

		if (head == null) {
			return null;
		}

		head = head.next;
		// head.prev =null;
		// Node da = head.prev;
		// System.out.println("head.prev"+ da.data);

		return head;
	}

	static Node DeleteAtEnd(Node head) {
		Node curr = head;

		if (head == null) {
			return null;
		}

		while (curr.next != null) {
			curr = curr.next;
		}

		curr.prev.next = null;
		curr.next = null;

		return head;

	}

	static Node InsertAtGivenPos(Node head, int data, int pos) {
		Node curr = head;

		Node newNode = new Node(data);

		for (int i = 1; i <= pos - 2 && curr != null; i++) {
			curr = curr.next;
		}

		// 10 20 30 40
		newNode.next = curr.next;
		curr.next = newNode;
		curr.next.prev = newNode;
		newNode.prev = curr;

		return head;
	}

	static Node DeleteAtGivenPos(Node head, int pos) {
		Node curr = head;

		if (head == null) {
			return null;
		}

		for (int i = 1; i <= pos - 2 && curr != null; i++) {
			curr = curr.next;
		}

		// 10 20 30 40
		curr.next = curr.next.next;
		curr.next.prev = curr;

		return head;

	}

	static Node reversetheList(Node head) {
		Node temp = null;
		Node current = head;

		while (current != null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}

	//	if (temp != null) {
			//head = temp.prev;
	//	}
		return temp.prev;
	}

	public static void main(String[] args) {
		Node head = new Node(10);
		Node temp1 = new Node(20);
		Node temp2 = new Node(30);

		head.next = temp1;
		temp1.prev = head;
		temp1.next = temp2;
		temp2.prev = temp1;

		head = reversetheList(head);
		// insertAtBegin
		head = inserAtBegin(head, 5);

		// insertAtEnd
		head = insertAtEnd(head, 35);

		// DeleteAtFirst
		head = DeleteAtFirst(head);

		// DeleteAtEnd

		head = DeleteAtEnd(head);

		// InsertAtGivenPos

		head = InsertAtGivenPos(head, 25, 3);

		// DeleteAtGivenPos
		head = DeleteAtGivenPos(head, 3);
		

		printList(head);

		

	}

}
