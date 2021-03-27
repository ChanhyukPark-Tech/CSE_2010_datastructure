package ExampleBook.Tree;

import java.util.Comparator;

public class BinTree<K, V> {

    public static class Node<K, V> {
        private K key;
        private V data;
        private Node<K, V> left;
        private Node<K, V> right;

        Node(K key, V data, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        K getKey() {
            return this.key;
        }

        V getValue() {
            return data;
        }

        void print(){
            System.out.println(data);
        }
    }

    private Node<K,V> root;                         // root 에 대한 참조를 보존, 유지 하는 필드
    private Comparator<? super K> comparator =null ;        // 키 값의 대소 관계를 비교하는 비교자

    public BinTree(){
        root = null;
    }

    public BinTree(Comparator<? super K> c){
        this();
        comparator = c;
    }

    private int comp(K key1, K key2){
        return (comparator ==null) ? ((Comparable<K>)key1).compareTo(key2):comparator.compare(key1,key2);
    }
    // 키에 의한 검색

    public V search(K key){
        Node<K,V> p = root;

        while(true){
            if(p == null){
                return null;
            }
            int cond = comp(key,p.getKey());

            if (cond == 0) {
                return p.getValue();
            }
            else if (cond < 0){
                p = p.left;
            }
            else{
                p = p.right;
            }
        }
    }

    private void addNode(Node<K,V> node, K key, V data){
        int cond = comp(key, node.getKey());
        if (cond == 0) {
            return ;
        }else if (cond < 0){
            if(node.left == null){
                node.left = new Node<K,V>(key,data,null,null);
            }else{
                node = node.left;
                addNode(node, key, data);
            }
        }
        else{
            if (node.right == null) {
                node.right = new Node<K,V>(key,data,null,null);
            }else{
                node = node.right;
                addNode(node,key,data);
            }
        }
    }

    public void add(K key , V data){
        if(root == null){
            root = new Node<K,V>(key,data,null,null);
        }
        else{
            addNode(root,key,data);
        }
    }

    // 키 값이 key 인 노드를 삭제
    public boolean remove(K key){
        Node<K,V> p = root;             // 스캔 중인 노드
        Node<K,V> parent = null;        // 스캔 중인 노드의 부모 노드
        boolean isLeftChild = true;     // p는 부모의 왼쪽 자식 노드인가?

        while(true){
            if(p== null){
                return false;
            }
            int cond = comp(key, p.getKey());
            if (cond == 0) {
                break;
            }
            else{
                parent = p;
                if (cond < 0) {
                    isLeftChild = true;         // key 쪽이 작으면 왼쪽 자식으로 내려감
                    p = p.left;
                }else{
                    isLeftChild = false;
                    p = p.right;
                }
            }
        }

        if(p.left == null){
            if (p == root){
                root = p.right;
            }else if( isLeftChild){
                parent.left = p.right;
            }else{
                parent.right = p.right;
            }
        }else if (p.right == null){
            if(p ==root){
                root = p.left;
            } else if (isLeftChild) {
                parent.left = p.left;
            }else{
                parent.right = p.left;
            }
        }else {
            parent = p;

        }
        // not complete

        return false;
    }





}
