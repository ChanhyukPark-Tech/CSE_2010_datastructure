package Tree;

public class NewBinTree {
    public class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            setLeft(null);
            setRight(null);
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }

    public Node root;

    public NewBinTree() {
        this.root = null;
    }

    public boolean find(int id) {
        Node current = root;
        while (current != null) {
            if (id == current.getData()) {
                return true;
            } else if (id < current.getData()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return false;
    }

    //삭제 연산

    public boolean delete(int id) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;

        while (current.getData() != id) {
            parent = current;
            if (current.getData() > id) {
                isLeftChild = true;
                current = current.getLeft();
            } else {
                isLeftChild = false;
                current = current.getRight();
            }

            if (current == null) {
                return false;
            }
        }

        // Case 1 : 자식노드가 없는 경우
        if (current.getLeft() == null && current.getRight() == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        }

        //Case 2 : 하나의 자식을 갖는 경우
        else if (current.getRight() == null) {
            if (current == root) {
                root = current.getLeft();
            } else if (isLeftChild) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
        } else if (current.getLeft() == null) {
            if (current == root) {
                root = current.getRight();
            } else if (isLeftChild) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
        }

        // Case 3 : 두개의 자식을 갖는 경우

        else if (current.getLeft() != null && current.getRight() != null) {
            // 오른쪽 서브트리의 최솟값을 찾음
            Node successor = getSuccessor(current);
            if (current == root) {
                root =successor;
            }else if (isLeftChild){
                parent.setLeft(successor);
            }else{
                parent.setRight(successor);
            }
            successor.setLeft(current.getLeft());
        }
        return true;
    }

    public Node getSuccessor(Node deleteNode){
        Node successor = null;
        Node successorParent = null;
        Node current = deleteNode.getRight();
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeft();
        }
        if(successor != deleteNode.getRight()){
            successorParent.setLeft(successor.getRight());
            successor.setRight(deleteNode.getRight());
        }
        return successor;
    }

    //삽입 연산
    public void insert(int id){
        Node newNode = new Node(id);
        if(root==null){
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while(true){
            parent = current;
            if(id < current.getData()){
                current = current.getLeft();
                if(current == null){
                    parent.setLeft(newNode);
                    return ;
                }
            }
            else{
                current = current.getRight();
                if (current == null) {
                    parent.setRight(newNode);
                    return ;
                }
            }
        }
    }

    public void display(Node root){
        if (root != null) {
            display(root.getLeft());
            System.out.println(" " + root.getData());
            display(root.getRight());
        }
    }

    public static void main(String[] args) {
        NewBinTree b = new NewBinTree();
        b.insert(3);
        b.insert(8);
        b.insert(1);
        b.insert(4);
        b.insert(6);
        b.insert(2);
        b.insert(10);
        b.insert(20);
        b.insert(25);
        b.insert(15);
        b.insert(16);


        System.out.println("삽입결과");
        b.display(b.root);
    }

}
