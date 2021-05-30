package PriorityQueue;

import java.util.*;
import java.util.PriorityQueue;

/**
 * An implementation of a priority queue using an array-based heap
 */
public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    /**
     * primary collection of priority queue entries
     */
    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

    public HeapPriorityQueue() {
        super();
    }

    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    public HeapPriorityQueue(K[] keys,V[] values){
        super();
        for(int j = 0; j < Math.min(keys.length, values.length); j++){
            heap.add(new PQEntry<K, V>(keys[j], values[j]));
        }
        for(int i=0; i < heap.size(); i++){
            System.out.print(heap.get(i).getKey() + " ");
        }
        System.out.println("\n");
        heapify();
    }
    protected void heapify(){
        int startIndex = parent(size()-1);
        for(int j = startIndex; j>=0;j--){
            downheap(j);
        }
    }


    protected int parent(int j) {
        return (j - 1) / 2;
    }
    protected int left(int j){
        return 2*j +1;
    }
    protected int right(int j){
        return 2*j +2;
    }

    protected boolean hasLeft(int j ){
        return left(j) < heap.size();
    }
    protected boolean hasRight(int j){
        return right(j) < heap.size();
    }

    /** Exchanges the entries at indices i and j of the array list.  */
    protected void swap(int i, int j){
        Entry<K,V> temp = heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,temp);


    }

    /** Moves the entry at inex j higer , if necessary,  to restore the heap property ! ! ! ! !*/
    protected void upheap(int j){
        while(j > 0){                               // continue until reaching root(or break statement)
            int p = parent(j);
            if(compare(heap.get(j),heap.get(p)) >= 0 ){
                break;
            }
            swap(j,p);
            j = p;              // continue from the parent's location
        }
    }

    /** Moves the entry at index j lower , if necessary, to restore the heap property */
    protected void downheap(int j){
        while(hasLeft(j)){
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;        // although right child may be smaller ! i don't know now !
            if (hasRight(j)) {
                int rightIndex = right(j);
                if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0) {
                    smallChildIndex = rightIndex;           // right child is smaller (this is conclusion)
                }
            }
            if(compare(heap.get(smallChildIndex),heap.get(j)) >= 0){
                break;
            }
            swap(smallChildIndex , j);
            j = smallChildIndex;
        }
    }

    // public methods


    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K,V> newest = new PQEntry<K, V>(key,value);
        heap.add(newest);
        upheap(heap.size() - 1);
        return newest;

    }

    @Override
    public Entry<K, V> min() {
        if(heap.isEmpty()) return null;
        return heap.get(0);
    }



    @Override
    public Entry<K, V> removeMin() {
        if(heap.isEmpty()){
            return null;
        }
        Entry<K,V> answer = heap.get(0);
        swap(0,heap.size() - 1);
        heap.remove(heap.size() -1 );
        downheap(0);
        return answer;
    }


    public static void main(String[] args) {
        Integer[] keys = {14,4,6,15,5,7,17,16,25,9,12,11,8,23,20};
        Integer[] values = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        HeapPriorityQueue<Integer, Integer> heap = new HeapPriorityQueue(keys,values);
        for(int i=0; i < heap.size(); i++){
            System.out.print(heap.heap.get(i).getKey() + " ");
        }

    }
}
