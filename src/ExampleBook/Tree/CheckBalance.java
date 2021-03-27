package ExampleBook.Tree;

class Tree_balance {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    Tree_balance(int size) {
        root = makeBST(0, size - 1);
    }

    Node makeBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.left = makeBST(start, mid - 1);
        node.right = makeBST(mid + 1, end);
        return node;
    }

    boolean isBalanced(Node root) {
        if (root == null) return true;
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        }
        else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    int getHeight(Node root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getHeight(root.left),getHeight(root.right)) + 1;
    }

}

public class CheckBalance {

    public static void main(String[] args) {
        Tree_balance t = new Tree_balance(10);
        System.out.println(t.isBalanced(t.root));
    }


}
