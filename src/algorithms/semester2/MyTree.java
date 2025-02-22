package algorithms.semester2;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class MyTree<E> {

    private Node root;

    private Comparator<E> comparator;

    public MyTree() {
    }

    public MyTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    private class Node{
        private E currentNodeData;
        private Node left;
        private Node right;

        public Node(E currentNodeData) {
            this.currentNodeData = currentNodeData;
        }
    }

    public void add(E element){
        if (root==null){
            root=new Node(element);
            return;
        }
        var currentNode=root;
        while (true){
            var currentNodeData=currentNode.currentNodeData;
            if (comparator.compare(element, currentNodeData) > 0){
                if (currentNode.right==null){
                    currentNode.right=new Node(element);
                    return;
                }
                currentNode=currentNode.right;
            } else if (comparator.compare(element, currentNodeData) < 0) {
                if (currentNode.left==null){
                    currentNode.left=new Node(element);
                    return;
                }
                currentNode=currentNode.left;
            }
        }
    }

    public void inOrderTraversal(){
        if (root!=null) inOrderTraversal(root);
    }

    public void inOrderTraversal(Node node){
        if (node.left!=null) inOrderTraversal(node.left);
        System.out.println(node.currentNodeData);
        if (node.right!=null) inOrderTraversal(node.right);
    }

    public static void main(String[] args) {
        MyTree<Integer> integerMyTree= new MyTree<>((o1, o2) -> {
            if (o1>o2) return 1;
            else if (o1.equals(o2)) return 0;
            return -1;
        });

        integerMyTree.add(10);
        integerMyTree.add(15);
        integerMyTree.add(20);

        integerMyTree.inOrderTraversal();
    }
}
