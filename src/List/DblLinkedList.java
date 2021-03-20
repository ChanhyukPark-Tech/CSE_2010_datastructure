package List;

import java.util.Comparator;

public class DblLinkedList<E> {

    class Node<E> {
        private E data;                 //데이터
        private Node<E> prev;           //앞쪽 포인터(앞쪽 노드에 대한 참조)
        private Node<E> next;           //뒤쪽 포인터(다음 노드에 대한 참조)

        // 생성자
        Node() {
            data = null;
            prev = next = this;
        }

        //생성자
        Node(E obj, Node<E> prev, Node<E> next) {
            this.data = obj;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;           //머리 노드 (더미 노드)
    private Node<E> crnt;           //선택 노드

    public DblLinkedList() {
        head = crnt = new Node<E>(); // 더미 노드를 생성 이 노드는 노드의 삽입과 삭제 처리를 원할하게 하도록 리스트의 머리에 계속 존재하는 더미 노드입니다.

    }

    public boolean isEmpty() {
        return head.next == head;
    }

    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = head.next; // 현재 스캔중인 Node;

        while (ptr != head) {
            if (c.compare(obj, ptr.data) == 0) {
                crnt = ptr;
                return ptr.data;//search complete
            }
            ptr = ptr.next;
        }
        return null;
    }

    public void printCurrentNode() {
        if (isEmpty()) {
            System.out.println("선택 노드가 없습니다");
        } else {
            System.out.println(crnt.data);
        }
    }

    //모든 노드를 출력
    public void dump() {
        Node<E> ptr = head.next;

        while (ptr != head) {
            System.out.println(ptr.data);
            ptr = ptr.next
        }
    }

    public void dumpReverse() {
        Node<E> ptr = head.prev;

        while (ptr != head) {
            System.out.println(ptr.data);
            ptr = ptr.prev;
        }
    }

    // 선택 노드를 하나 뒤쪽으로 이동

    public boolean next() {
        if (isEmpty() || crnt.next == head) {
            return false;
        }
        crnt = crnt.next;
        return true;
    }

    public boolean prev() {
        if (isEmpty() || crnt.prev == head) {
            return false;
        }
        crnt = crnt.prev;
        return true;
    }

    public void add(E obj) {
        Node<E> node = new Node<E>(obj, crnt, crnt.next);
        crnt.next = crnt.next.prev = node;
        crnt = node;
    }

    public void addFirst(E obj) {
        crnt = head;
        add(obj);
    }

    public void addLast(E obj) {
        crnt = head.prev;
        add(obj);
    }

    //remove;

    // 선택 노드를 삭제

    public void removeCurrentNode() {
        if (!isEmpty()) {
            crnt.prev.next = crnt.next;
            crnt.next.prev = crnt.prev;
            crnt = crnt.prev;
            if (crnt == head) {
                crnt = head.next;
            }
        }
    }

    // Node p delete;
    public void remove(Node p) {
        Node<E> ptr = head.next;

        while (ptr != head) {
            if (ptr == p) {
                crnt = p;
                removeCurrentNode();
                break;
            }
            ptr = ptr.next;
        }
    }

    //머리 노드를 삭제
    public void removeFirst(){
        crnt = head.next;
        removeCurrentNode();
    }

    // 꼬리 노드를 삭제
    public void removeLast(){
        crnt = head.prev;
        removeCurrentNode();
    }

    // 모든 노드를 삭제

    public void clear(){
        while(!isEmpty()){
            removeFirst();
        }
    }

}
