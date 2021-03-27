package ExampleBook.Tree;


class Node<T> {

    private T data;
    private Node<T> leftNode;
    private Node<T> rightNode;
    private int height;         //　높이

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }
    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String toString() {
        return this.data.toString();
    }
}


public class AVLTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root; // 루트 노드

    @Override
    public void insert(T data) {
        root  = insert(root, data);
    }

    private Node<T> insert(Node<T> node, T data){
        //root 가 비어있거나 leaf 노드인 경우 새로운 노드 생성
        if (node == null) {
            return new Node<>(data);
        }

        //삽입할 데이터가 상위노드(부모노드)의 데이터보다 작으면 왼쪽 하위노드에 새로운 노드 생성
        //삽입할 데이터가 상위노드(부모노드)의 데이터보다 크면 오른쪽 하위노드에 새로운 노드 생성
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftNode(insert(node.getLeftNode(),data));
        }else{
            node.setRightNode(insert(node.getRightNode(),data));
        }

        node.setHeight(Math.max(height(node.getLeftNode()),height(node.getRightNode())) + 1);

        //삽입으로 인해 트리가 불균형이면 회전연산(LL,RR,LR,RL)수행
//        node = settleViolatuion(data,node);
        return node;

    }

    private void settleViolatuion(T data, Node<T> node){
        // not complete
    }

    //트리 균형//불균형 여부 판단
    private int getBalance(Node<T> node){

        //트리가 비어있는 상태
        if (node == null) {
            return 0;
        }


        //계산 결과가 1보다 큰 경우 : LL or LR
        // 계산 결과가 -1 보다 작은 경우 : RR or RL

        return height(node.getLeftNode()) - height(node.getRightNode()) ;
    }

    @Override
    public void traverse() {

    }

    @Override
    public void delete(T data) {

    }

    // 회전을 수행하기 위해서는 노드의 높이들을 알기 위해 위와 같이 AVL 트리 클래스에 특정노드의 높이를 반환하는 메서드를 작성한다.
    private int height(Node<T> node) {
        if (node == null) {
            return -1;
        }
        return node.getHeight();
    }

    private Node<T> rightRotation(Node<T> parentNode) {
        System.out.println("Rotating to thje right on node  : " + parentNode);

        Node<T> newParentNode = parentNode.getLeftNode();           //왼쪽 자식노드가 새로운 부모노드가 됨
        Node<T> nullNode = newParentNode.getRightNode();


        newParentNode.setRightNode(parentNode);
        newParentNode.setLeftNode(nullNode);

        //회전한 Node's 높이 갱신
        parentNode.setHeight(Math.max(height(parentNode.getLeftNode()),height(parentNode.getRightNode())) + 1);
        newParentNode.setHeight(Math.max(height(newParentNode.getLeftNode()),height(newParentNode.getRightNode())) + 1);

        return newParentNode;
    }

    private Node<T> leftRotation(Node<T> parentNode){
        System.out.println("Rotating to the left on node : " + parentNode);
        Node<T> newParentNode = parentNode.getRightNode(); // 오른쪽 자식노드가 새로운 부모노드가 됌
        Node<T> nullNode = newParentNode.getLeftNode(); // 오른쪽 자식노드가 왼쪽 자식노드

        newParentNode.setLeftNode(parentNode);
        parentNode.setRightNode(nullNode);

        parentNode.setHeight(Math.max(height(parentNode.getLeftNode()),height(parentNode.getRightNode())) + 1);
        newParentNode.setHeight(Math.max(height(newParentNode.getLeftNode()),height(newParentNode.getRightNode())) + 1);

        return newParentNode;

    }

    // 삽입

}
