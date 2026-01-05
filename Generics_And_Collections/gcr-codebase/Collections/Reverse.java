import java.util.*;

class Node{
    int data;
    Node next;

    Node(int d){
        data=d;
    }
}

public class Reverse {
    public static void main(String[] args) {
        
        Node head=new Node(10);
        head.next=new Node(20);
        head.next.next=new Node(30);   
        head.next.next.next=new Node(40);
        head.next.next.next.next=new Node(50);

        System.out.println("Original list");
        print(head);
        head=ReverseList(head);
        System.out.println("\nReversed list");
        print(head);

        System.out.println();


        ArrayList<Integer> al=new ArrayList<>();
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);
        al.add(50);
        System.out.println("Original arrayList :");
        System.out.println(al);
        System.out.println("Reversed arrayList :");
        System.out.println(al.reversed());
    }

    public static Node ReverseList(Node head){
        Node curr=head;
        Node prev=null;

        while(curr!=null){
           Node next=curr.next;
           curr.next=prev;
           prev=curr;
           curr=next;
        }

        return prev;
    }

    public static void print(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
}
