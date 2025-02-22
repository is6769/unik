package algorithms.semester2;

import java.util.NoSuchElementException;
import java.util.Objects;

public class MyCircularLinkedList<E> {

    private Node head; // first element of list

    private class Node {
        private Node next;
        private Node previous;
        private final E data;

        public Node(E data) {
            this.data = data;
        }
    }

    public void add(E element){
        if (head==null){
            head = new Node(element);
            head.next = head;
            head.previous = head;
        } else {
            var newNode = new Node(element);
            var tail=head.previous;
            newNode.next=head;
            newNode.previous=tail;
            tail.next=newNode;
            head.previous=newNode;
        }
    }

    public void add(E element, E elementPresent){
        if (head!=null){
            var newNode = new Node(element);
            var tail=head.previous;
            newNode.next=head;
            newNode.previous=tail;
            tail.next=newNode;
            head.previous=newNode;
        }
    }

    public void removeFirstOccurrence(E element){
        if (Objects.isNull(head)) throw new NoSuchElementException();
        else if (head.next.equals(head)) {
            head=null;
        }else if (head.data.equals(element)){
            var nextNode = head.next;
            var prevNode = head.previous;
            prevNode.next = nextNode;
            nextNode.previous = prevNode;
            head=nextNode;
        }else {
            var currentNode=head.next;
            while (!head.equals(currentNode)) {
                if (currentNode.data.equals(element)) {
                    var nextNode = currentNode.next;
                    var prevNode = currentNode.previous;
                    prevNode.next = nextNode;
                    nextNode.previous = prevNode;
                }
                currentNode = currentNode.next;
            }
        }
    }

    public int getLength(){
        int length = 0;
        if (head==null) return length;
        else {
            length+=1;
            var currentNode = head.next;
            while (currentNode!=head){
                length+=1;
                currentNode=currentNode.next;
            }
        }
        return length;
    }


//    @Override
//    public String toString() {
//        var currentNode = head;
//        while (currentNode!=null || currentNode!=head)
//        return "MyCircularLinkedList{}";
//    }

    public void print(){
        if (Objects.nonNull(head)){
            var currentNode = head;
            System.out.print(currentNode.data);
            while (currentNode.next!=head){
                System.out.print("->" + currentNode.next.data);
                currentNode=currentNode.next;
            }
            System.out.println();
        }
    }

    public void printReverse(){
        if (Objects.nonNull(head)){
            var currentNode = head.previous;
            System.out.print(currentNode.data);
            while (currentNode.previous!=head.previous){
                System.out.print("->" + currentNode.previous.data);
                currentNode=currentNode.previous;
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        var list =  new MyCircularLinkedList<Integer>();
        list.add(10);
        list.add(15);
        list.add(20);
        list.add(25);

        list.print();

        list.removeFirstOccurrence(20);


        list.print();
        System.out.println(list.getLength());


        list.add(15);

        list.print();
        System.out.println(list.getLength());

    }
}
