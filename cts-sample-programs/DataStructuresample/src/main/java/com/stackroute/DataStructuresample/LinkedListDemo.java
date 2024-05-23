package com.stackroute.DataStructuresample;
import java.util.Scanner;

public class LinkedListDemo {


 
  public static class Node {
      int data;
      Node next;
  }

  public static class MyLinkedList {
    Node head;
    Node tail;
    int size;

  void  addFirst(int data)
  {
	  Node node=new Node();
	  node.data=data;
  
	  if (head==null)
	  {
		  head=tail=node;
		  head.next=null;
		  tail.next=null;
		  size++;
	  }
	  else
	  {
		 
	  node.next=head;
	  head=node;
	  size++;
	  //head.next=node;
	 }
  }

    void addLast(int data) {
    	Node node = new Node();
        node.data = data;
//      if(tail == null) {
//        
//        node.next = null;
//        head = tail = node;
//        size++;
//      } else {
//    	  tail.next = node;
//          node.next = null;
//                tail = node;
//        size++;
//      }
        
     //  call display()
       
       current.next=node;
       
       node.next=null;
       
       
    }
    //
    public void display() {
    	   Node current = head;
           while (current != null) {
               System.out.print(current.data + " ");
               current = current.next;
           }
           
          
           System.out.println();
    }

    // remove first
    public void removeFirst() {
      if(size == 0) {
        System.out.println("LL is empty");
      } else if(size == 1){
        head = tail = null;
        size = 0;
      } else {
    	    System.out.println("Data removed " +  head.data);
        head = head.next;
    
        size --;
      }
    }

    public int getFirst() {
      if(size == 0) {
        System.out.println("LL is empty");
        return -1;
      } else {
           return head.data;
      }
    }

    public int getLast() {
      if(size == 0) {
        System.out.println("LL is empty");
        return -1;
      } else {
      return tail.data;
      }
    }

    public int getAt(int index) {
      if(size == 0) {
        System.out.println("LL is empty");
        return -1;
      } else if(index <0 || index > size) {
        System.out.println("Invalid index value");
        return -1;
      } else {
          Node temp = head;
          for(int i=0;i<index;i++) {
            temp = temp.next;
          }
          return temp.data;
      }
    }


    public void removeLast() {
      if(size == 0) {
        System.out.println("LL is empty");
      } else if(size == 1){
        head = tail = null;
        size = 0;
      } else {
        Node temp = head;
        for(int i=0;i<size-2;i++) {
          temp = temp.next;
        }
        tail = temp;
        tail.next = null;
        size--;
      }
    }
    // reverse
    public void reverseLL() {
      int li = 0;
      int ri = size-1;
      while(li < ri) {
        Node left = getNodeAt(li);
        Node right = getNodeAt(ri);

        int temp = left.data;
        left.data = right.data;
        right.data = temp;
        li++;
        ri--;
      }
    }

    Node getNodeAt(int index) {
      Node temp = head;
      for(int i=0;i< index;i++) {
        temp = temp.next;
      }

      return temp;

    }
    
    // 1 2 3 4 5
    public int kthLast(int k) {

      Node slow = head;
      Node fast = head;

      for (int i = 0; i < k; i++) {
        fast = fast.next;
      }

      while (fast != tail) {
        slow = slow.next;
        fast = fast.next;
      }

      return slow.data;
    }


    // middle element in LL (2 pointer)
    public int middleElem() {

      Node slow = head;
      Node fast = head;

      while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }

      return slow.data;
    }



    // adding two LL
    // cycling LL

  }

  // 1. addFirst(data)
  // 2. addAtIndex(int index, int value)
  // 3. reverseLL (any other approach)-> two pointer approach

  public static void main(String[] args) 
  {
	  System.out.println("enter data");
	    Scanner sc = new Scanner(System.in);
	    int data1=sc.nextInt();
	    LinkedListDemo.MyLinkedList list=new LinkedListDemo.MyLinkedList();
	     list.addFirst(10);
	     list.addFirst(20);
	     list.addFirst(50);
	     list.addLast(90);
	     list.display();
	     
	     list.removeFirst();
	   // list.
	   
  }
}