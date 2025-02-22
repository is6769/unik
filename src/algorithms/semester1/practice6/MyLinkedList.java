package algorithms.semester1.practice6;

import java.util.Objects;

public class MyLinkedList <T>{

    private Node first;
    private Node last;
    private int nodeCount=0;

    public class Node  {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            MyLinkedList.this.nodeCount++;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(data, node.data);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(data);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public void addLast(T data) {
        if (isEmpty()) {
            first = new Node(data);
            last = first;
        } else if (last == null) {
            last = new Node(data);
        } else {
            last.next = new Node(data);
            last = last.next;
        }
    }

    public void addFirst(T data) {
        var newNode = new Node(data);
        if (isEmpty()) {
            last = newNode;
        }
        newNode.next = first;
        first = newNode;
    }

    public void addLast(MyLinkedList<T> incomingList){
        for (int i = 0; i < incomingList.nodeCount; i++) {
            addLast(incomingList.get(i));
        }
    }

    public void set(T data,int index) {
        if (index==-1) addFirst(data);
        else if (nodeCount-1 == index) addLast(data);
        else {
            var newNode = new Node(data);
            Node currentNode = first;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            newNode.next=currentNode.next;
            currentNode.next = newNode;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int length() {
        return nodeCount;
    }

    public T get(int index) {
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        Node node = first;
        for (int i = 0; i < nodeCount; i++) {
            str.append(node.data);
            str.append(",");
            node=node.next;
        }
        return str.append("]").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MyLinkedList<?> that = (MyLinkedList<?>) o;
        if (nodeCount != that.nodeCount || !Objects.equals(first, that.first) || !Objects.equals(last, that.last)) return false;
        for (int i = 0; i < nodeCount; i++) {
            if (!Objects.equals(this.get(i),that.get(i))) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last, nodeCount);
    }

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addFirst("Hello");
        list.addLast("World");
        MyLinkedList<String> list2 = new MyLinkedList<>();
        list2.addFirst("Hello");
        list2.addLast("World");
        System.out.println(list.equals(list2));

        list.set("My",0);
        list.set("Dear",1);
        list.addFirst("Working");
        list.addLast("Working");

        System.out.println(list2);
        System.out.println(list);
        list.addLast(list2);
        System.out.println(list);

    }
}
