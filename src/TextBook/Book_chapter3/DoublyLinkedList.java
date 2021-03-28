package TextBook.Book_chapter3;

public class DoublyLinkedList<E> {

    private static class Node<E> {

        E element;
        Node<E> next;
        Node<E> prev;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
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

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList() {
        header = new Node<E>(null, null, null);
        trailer = new Node<E>(null, header, null);
        header.setNext(trailer);
    }

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
        return header.getNext().getElement();
    }

    public E last(){
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev().getElement();
    }

    public void addFirst(E e){
        addBetween(e,header,header.getNext());
    }

    public void addLast(E e){
        addBetween(e,trailer, trailer.getPrev());
    }

    public E removeFirst(){
        if(isEmpty()) return null;
        return remove(header.getNext());
    }
    public E removeLast(){
        if(isEmpty()) return null;
        return remove(trailer.getPrev());
    }



    private void addBetween(E e, Node<E> predecessor, Node<E> successor){
        Node<E> newest = new Node<E>(e,predecessor,successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    } 

    private E remove(Node<E> node){
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();

        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
}
