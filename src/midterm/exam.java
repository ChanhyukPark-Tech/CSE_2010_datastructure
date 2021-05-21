package midterm;

class Node{
    int value;
    Node next;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}


public class exam {

    public static Node removeDuplicate(Node node){
        if(node.next == null){
            return node;
        }
        if(node.value == node.next.value){
            return removeDuplicate(node.next);
        }
        else{
            return new Node(node.value,removeDuplicate(node.next.next));
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1,new Node(1,new Node(2,new Node(2,new Node(3,null)))));
        Node node2 = removeDuplicate(node);

        System.out.println(node2);
    }
}
