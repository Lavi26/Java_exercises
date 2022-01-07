package org.espire.linkedlist;


public class ReverseLinkedList {

    // head of list
    static Node head;
    private static Node tail;

    // class for creating node
    static class Node {
        // data
        private Integer data;

        // reference to next node
        Node next;

        // constructor to create a new node
        public Node(Integer d) {
            data = d;

            // last of the list
            next = null;
        }

    }

    //add new node in the list
    public static void addNode(Integer data) {

        // create new node
        Node newNode = new Node(data);

        // check if list is empty
        if (head == null) {

            // if list is empty head and tail pointing new node
            head = newNode;
            tail = newNode;

        } else {

            // new node added next to the tail
            tail.next = newNode;

            // tail pointing to new node
            tail = newNode;
        }
    }


    //to display the list
    public static void printList(Node head) {
        if (head == null) {
            return;
        }
        while (head != null) {
            System.out.println("" + head.data);
            head = head.next;
        }

    }


    public static Node reverseList(Node head) {

        if (head == null) {
            return null;
        }

        Node current = head;
        Node previous = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;

    }

    public static void main(String args[]) {

        ReverseLinkedList.head = new Node(10);
        ReverseLinkedList.head.next = new Node(20);
        ReverseLinkedList.head.next.next = new Node(30);

        ReverseLinkedList.printList(head);

        Node reverse = ReverseLinkedList.reverseList(head);
        ReverseLinkedList.printList(reverse);
    }
}
