package datastructures;

import datastructures.LinkedList.Node;

public class LinkedlistProblems {

	static class Node {
		Node next;
		int data;

		Node(int x) {
			data = x;
			next = null;
		}
	}

	static Node insertNewNode(Node head, int data) {
		Node curr = head;
		Node temp = new Node(data);

		if (data < head.data) {
			temp.next = head;
			return temp;
		}

		while (curr.next != null) {
			if (curr.next.data > data) {
				break;
			}
			curr = curr.next;
		}

		temp.next = curr.next;
		curr.next = temp;

		return head;
	}

	// O(N+ N) --> O(N)
	static int bruteForcemiddleNode(Node head) {
		Node curr = head;
		int count = 0;
		while (curr.next != null) {
			count++;
			curr = curr.next;
		}

		int mid = (count % 2 == 0) ? (count / 2) : (count + 1) / 2;
		curr = head;

		for (int i = 1; i <= mid; i++) {
			curr = curr.next;
		}
		return curr.data;
	}

	static int efficientMiddleNode(Node head) {

		// using 2 pointers approach we can get it in single traversle
		// 5 10 20 30 40
		// s    f
		//    s    f
		//       s     f

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;

	}

	static int bruteForcenthNodeFromEnd(Node head, int k) {
		Node curr = head;

		int count = 1;
		while (curr.next != null) {
			curr = curr.next;
			count++;
		}

		curr = head;
		for (int i = 1; i < count - k + 1; i++) {
			curr = curr.next;
		}

		return curr.data;
	}

	static int efficientNthNodeFromEnd(Node head, int k) {
		Node slow = head, fast = head;

		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}
		// k= 2 move k to 2 times ahead in linkedlist
		// 5 10 20 30 40
		// s     f            1st iteration
		//    s     f         2nd iteration
		//       s     f      3rd iteration
		
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow.data;
	}
	
	static Node reverseLinkedList(Node head) {
		Node curr = head;
		Node prev = null;
		Node next = null;
		
		// 5 --> 10  --> 20 --> 30 --> 40
		// 5 <-- 10  <-- 20 <-- 30 <-- 40
		// tail                        head
		while(curr!=null) {
			next =curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
	static Node recRevL(Node head){
        if(head==null||head.next==null)
        	return head;
        
        //1 2 3 4
        //1 4 3 2
        //  rh
        Node rest_head=recRevL(head.next);
        Node rest_tail=head.next;
        rest_tail.next=head;
        head.next=null;
        return rest_head;
    }
	
	
	static void removeDuplicates(Node head) {
		
		Node curr = head;
		
		while(curr!=null && curr.next!=null) {
			if(curr.data == curr.next.data) {
				curr.next = curr.next.next;
			}else {
				curr = curr.next;	
			}
		}
		
	}

	static void printlist(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.println("data=" + curr.data);
			curr = curr.next;
		}
	}
	// 10 20 30 40

	public static void main(String[] args) {
		Node head = new Node(10);
		Node h1 = new Node(10);
		Node h2 = new Node(20);
		Node h3 = new Node(20);
		Node h4 = new Node(20);
		Node h5 = new Node(20);
		Node h6 = new Node(40);

		head.next = h1;
		h1.next = h2;
		h2.next = h3;
		h3.next = h4;
		h4.next = h5;
		h5.next = h6;
		h6.next = null;
		
		removeDuplicates(head);

		// insert a new node to sorted
		head = insertNewNode(head, 5);

		int data = bruteForcemiddleNode(head);

		int data1 = efficientMiddleNode(head);

		int data2 = bruteForcenthNodeFromEnd(head, 2);

		int data3 = efficientNthNodeFromEnd(head, 2);
		
		head = reverseLinkedList(head);
		
		//head = recRevL(head);
		
		//System.err.println("result=" + data3);

		printlist(head);
	}

}
