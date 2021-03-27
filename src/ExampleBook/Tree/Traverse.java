package ExampleBook.Tree;

class Nodes {
    int key;
    Nodes left;
    Nodes right;
    Nodes parent;

    Nodes(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

public class Traverse {

    Nodes root;

    static void inorder(Nodes root) {
        if (root.left != null) {
            inorder(root.left);
        }
        System.out.print(root.key);
        if (root.right != null) {
            inorder(root.right);
        }
    }

    static void preorder(Nodes root) {
        System.out.print(root.key);
        if (root.left != null) {
            preorder(root.left);
        }
        if (root.right != null) {
            preorder(root.right);
        }
    }

    static void postorder(Nodes root) {
        if (root.left != null) {
            postorder(root.left);
        }
        if (root.right != null) {
            postorder(root.right);
        }
        System.out.print(root.key);
    }


    public static void main(String[] args) {
        Nodes nodesix = new Nodes(6);
        Nodes nodenine = new Nodes(9);
        Nodes nodefour = new Nodes(4);
        Nodes nodethree = new Nodes(3);

        nodesix.left = nodenine;
        nodesix.right = nodefour;
        nodenine.parent = nodesix;
        nodefour.parent = nodesix;
        nodenine.right = nodethree;
        nodethree.parent = nodenine;

        Traverse.inorder(nodesix);
        System.out.println("\n");
        Traverse.preorder(nodesix);
        System.out.println("\n");
        Traverse.postorder(nodesix);

    }
}
