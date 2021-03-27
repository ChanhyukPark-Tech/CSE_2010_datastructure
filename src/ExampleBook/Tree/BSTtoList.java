package ExampleBook.Tree;


import java.util.ArrayList;
import java.util.LinkedList;

class Tree_BSTtoList {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    Tree_BSTtoList(int size) {
        root = makeBST(0, size - 1);
    }

    Node makeBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.right = makeBST(mid + 1, end);

        node.left = makeBST(start, mid - 1);

        return node;
    }

    ArrayList<LinkedList<Node>> BSTtoList(){
        ArrayList<LinkedList<Node>> lists = new ArrayList<LinkedList<Node>>();
        BSTtoList(root,lists,0);
        return lists;
    }

    void BSTtoList(Node root , ArrayList<LinkedList<Node>> lists,int level){
        if(root == null) return ;
        LinkedList<Node> list = null;
        if(lists.size() == level){
            list = new LinkedList<Node>();
            lists.add(list);
        }else{
            list = lists.get(level);
        }
        list.add(root);
        BSTtoList(root.left,lists,level + 1);
        BSTtoList(root.right,lists,level + 1);
    }

    void printList(ArrayList<LinkedList<Node>> arr){
        for(LinkedList<Node> list : arr){
            for(Node node : list){
                System.out.println(" " + node.data);
            }
            System.out.println("\n");
        }
    }




}

public class BSTtoList {
    public static void main(String[] args) {
        Tree_BSTtoList t = new Tree_BSTtoList(10);
        t.printList(t.BSTtoList());
    }
}
