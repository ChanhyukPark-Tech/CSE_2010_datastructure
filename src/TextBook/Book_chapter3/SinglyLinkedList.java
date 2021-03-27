package TextBook.Book_chapter3;

public class SinglyLinkedList<E> {

    private static class Node<E> {
        private E element;      //reference to the element stored at this node
        private Node<E> next;

        public Node(E e, Node<E> n) {
            this.element = e;
            this.next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    // instance variables of the SinglyLinkedList
    private Node<E> head = null;        // first node of the list ( or null if empty)
    private Node<E> tail = null;    // last node of the list (or null if empty)
    private int size = 0;       // number of nodes in the list

    /**
     * access methods
     */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<E>(e, head);
        if (isEmpty()) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {

        Node<E> newest = new Node<E>(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        E temp = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) {            // special case as list is now empty
            tail = null;
        }
        return temp;
    }
}
