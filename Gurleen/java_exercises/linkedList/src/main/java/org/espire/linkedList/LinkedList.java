/**
 * 
 */
package org.espire.linkedList;

/**
 * @author gurleen.kaur
 *
 */
public class LinkedList {

	private static Node head;
	private static Node tail;

	// initialization of node
	private static class Node {
		
		int data;
		
		// reference to next node
		Node next;

		// constructor to create a new node
		public Node(int d) {
			data = d;
			
			//last of the list
			next = null;
		}

	}
	
//	public Node head;
//	public Node tail;
	public int size;

	public int getFirst() throws Exception {

		if (this.size == 0) {

			throw new Exception("linked list is empty");
		}

		return this.head.data;
	}

	public int getLast() throws Exception {

		if (this.size == 0) {

			throw new Exception("linked list is empty");
		}
		return this.tail.data;
	}

	public void display() {

		Node temp = this.head;
		while (temp != null) {
			System.out.println(temp.data + " ");
			temp = temp.next;
		}
	}
	
	//to display the list
	public static void printList() {
		Node current=head;
		while(current!=null) {
			System.out.println("" + current.data);
			current=current.next;	
		}
	//	System.out.println("null"); 
		
	}
    	
	//add new node in the list
	public static void addNode(int data) {

		// create new node
		Node newNode = new Node(data);

		// check if list is empty
		if (head == null) {

			// if list is empty head and tail pointing new node
			head = newNode;
			tail=newNode;

		} else {

			// new node added next to the tail
			tail.next = newNode;

			// tail pointing to new node
			tail = newNode;
		}
	}
	
	//count the node
	public static int countNode() {
		
		int count=0;
		
		//current pointing head
		Node current = head;
		
		if(head==null && current.next==null) {
			System.out.println("List is empty");
			return 0;
		}
		
		//until current not equal to null..., count increases and current pointing to the next
		while(current!=null) {
			count++;
			current= current.next;
		}
		
		return count;
		
	}
	
	
	public static void main (String args[]) {
		
		addNode(20);
		addNode(40);
		addNode(60);
		addNode(80);
		
		printList();
		
		System.out.println("Length of the list is equal to:"+ LinkedList.countNode());
	}

}
