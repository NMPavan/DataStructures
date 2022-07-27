package datastructures;
import java.util.*;
import datastructures.LinkedList.Node;

//pending
//Remove Nodes from unsorted linkedlist
//Swap Kth nodes from ends
//using Merge sort sort the  LinkedList
//LRU cache
//merge two sorted linkedlists
//Clone a linked list with next and random pointer

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
	
	
	static boolean polindrome(Node head)  {
        
		//find the mid
        //mid+1 to end  just reverse the list
        //keep the start node after reverse as h1
        // traverse the list from start and compare each element with after mid+1 element
        
        Node slow= head,fast= head;
        
        // if(head == null || head.next==null){
        //     return false;
        // }
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Node rev = reverseLinkedList(slow.next);
        
        slow = head;
        
        //1   2    2    1
        //sf
        //.   s.   f
        //1   2.   1.    2      null
        //s        rev
        //.   s          rev
        //.         s           rev
        while(rev!=null){
            if(rev.data!= slow.data){
                return false;
            }else{
                slow= slow.next;
                rev= rev.next;
            }
        }
        
        return true;
    }  
	
	 public static Node rotate(Node head, int k) {
	        // add code here
		 
		 if(k<1)
			 return head;
	        
	        Node curr = head;
	        Node KthNode = head;
	        
	        //2    4     7       8         9
	        //c,k
	        //                                     ex: k= 3 k = 3-1 = 2 
	        //                                       //move k-1 times right
	        
	        for(int i=1;i<k && curr!=null;i++){
	            curr = curr.next;
	        }
	        
	        if(curr== null){
	            return null;
	        }
	        
	        KthNode = curr;
	        
	        while(curr.next!=null){
	            curr = curr.next;
	        }
	        
	        curr.next = head;
	        head = KthNode.next;
	        KthNode.next = null;
	        
	      
	      return head;
	        
	          
	    }
	
	 static Node rotateClock(Node head,int k) {
		 Node slow = head, fast = head;
		 Node curr = head;

		 
			for (int i = 0; i <k; i++) {
				fast = fast.next;
			}
			// k= 2 move k to 2 times ahead in linkedlist
			// 5 10 20 30 40
			// s     f            1st iteration
			//    s     f         2nd iteration
			//       s     f      3rd iteration
			
			while (fast.next!= null) {
				slow = slow.next;
				fast = fast.next;
			}
			
			Node kThNode = slow;
			

			fast.next = curr;
			curr = slow.next;
			slow.next = null;
			
			return  curr;
			
			
			
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
		
		//remove duplicatesfrom sorted List;
		
		//polindrome or not
		polindrome(head);
		
		//rotate the linkedlist by kth times in anti clock wise
		//head = rotateAnti(head, 1); 
		
		//rotate the linkedlist by ktimes in clock wise
		head = rotateClock(head,1);
		printlist(head);
	}

}
