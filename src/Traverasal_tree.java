import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Traverasal_tree {

    public static void main(String[] args) throws IOException {

        Tree t = new Tree();
        t.add('A','B','C');
        t.add('B','D','.');
        t.add('C','E','F');
        t.add('E','.','.');
        t.add('F','.','G');
        t.add('D','.','.');
        t.add('G','.','.');


        t.preorder(t.root);
        System.out.println( );
        t.inorder(t.root);
        System.out.println();
        t.postorder(t.root);
    }
}


class Node{
    char data;
    Node left, right;
    public Node(char data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Tree{
    Node root;
    public void add(char data, char leftData, char rightData) {
        if (root == null) {
            if (data != '.') {
                root = new Node(data);
                if (leftData != '.') {
                    root.left = new Node(leftData);
                }
                if (rightData != '.') {
                    root.right = new Node(rightData);
                }
            }
        }
        else {
                search(root, data, leftData, rightData);
            }
        }



    private void search(Node root, char data,  char leftData, char rightData){
        if(root==null){
            return;
        }
        else if(root.data == data){
            if(leftData!='.'){
                root.left = new Node(leftData);
            }
            if (rightData!='.'){
                root.right = new Node(rightData);
            }
        }
        else{
            search(root.left,data,leftData,rightData);
            search(root.right,data,leftData,rightData);
        }
    }

    public void preorder(Node root){
        System.out.print(root.data);
        if(root.left != null){
            preorder(root.left);
        }
        if(root.right != null){
            preorder(root.right);
        }

    }
    public void inorder(Node root){


        if(root.left != null){
            inorder(root.left);
        }
        System.out.print(root.data);
        if(root.right != null){
            inorder(root.right);
        }
    }
    public void postorder(Node root){
        if(root.left != null){
            postorder(root.left);
        }

        if(root.right != null){
            postorder(root.right);
        }
        System.out.print(root.data);
    }

}