package PriorityQueue;


import java.util.Comparator;
/**
 * The AbstractPriorityQueue class. This provides a nested PQEntry class that composes a key and a value into a single object
 *, and support for managing a comparator. For convenience, we also provide an implementation of isEmpty based on a presumed size method
 * */
public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {

    protected static class PQEntry<K, V> implements Entry<K, V> {
        private K k;
        private V v;

        public PQEntry(K key, V value) {
            this.k = key;
            this.v = value;
        }

        public K getKey() {
            return k;
        }

        public V getValue() {
            return v;
        }

        public void setK(K k) {
            this.k = k;
        }

        public void setV(V v) {
            this.v = v;
        }
    }
    private Comparator<K> comp;
    protected AbstractPriorityQueue(Comparator<K> c){
        comp = c;
    }
    protected AbstractPriorityQueue(){
        this(new DefaultComparator<K>());
    }
    protected int compare(Entry<K,V> a,  Entry<K,V> b){
        return comp.compare(a.getKey(),b.getKey());
    }

    protected boolean checkKey(K key) throws IllegalArgumentException{
        try{
            return (comp.compare(key,key) == 0);
        }catch (ClassCastException e){
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    public boolean isEmpty(){
        return size() == 0 ;
    }
}
