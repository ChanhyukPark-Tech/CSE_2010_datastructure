package Hash;

public class ChainHash<K, V> {

    class Node<K, V> {
        private K key;
        private V data;
        private Node<K, V> next;

        // Constructor

        Node(K key, V data, Node<K, V> next) {
            this.key = key;
            this.data = data;
            this.next = next;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return data;
        }

        public int hashCode() {
            return key.hashCode();
        }
    }

    private int size;          // the size of hash table
    private Node<K, V>[] table; // hash table;

    //  constructor
    public ChainHash(int capacity) {
        try {
            table = new Node[capacity];
            this.size = capacity;
        } catch (OutOfMemoryError e) {
            this.size = 0;
        }
    }

    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

    // 키 값 key 를 갖는 요소의 검색 (데이터를 반환)
    public V search(K key) {
        int hash = hashValue(key);      //검색할 데이터의 해시 값
        Node<K, V> p = table[hash];      //선택 노드

        while (p != null) {
            if (p.getKey().equals(key)) {
                return p.getValue();                   // 검색 성공
            }
            p = p.next;                                // 다음 노드에 주목
        }
        return null;                                   // 검색 실패
    }

    public int add(K key, V data) {
        int hash = hashValue(key);              // 추가할 데이터의 해시 값
        Node<K, V> p = table[hash];

        while (p != null) {
            if (p.getKey().equals(key)) {
                return 1;
            }
            p = p.next;
        }
        Node<K, V> temp = new Node<K, V>(key, data, table[hash]);
        table[hash] = temp;
        return 0;
    }

    // 키 값 key 를 갖는 요소의 삭제
    public int remove(K key) {
        int hash = hashValue(key); //삭제할 데이터의 해시 값
        Node<K, V> p = table[hash];
        Node<K, V> pp = null;                // 바로 앞의 선택 노드

        while (p != null) {
            if (p.getKey().equals(key)) {
                if (pp == null) {
                    table[hash] = p.next;
                } else {
                    pp.next = p.next;
                }
                return 0;
            }
            pp = p;
            p = p.next;                 // 다음 노드를 가리킵니다.
        }
        return 1;                   // 그 키 값은 없습니다

    }


    // 해시 테이블을 덤프
    public void dump() {
        for (int i = 0; i < size; i++) {
            Node<K, V> p = table[i];
            System.out.printf("%02d  ", i);
            while (p != null) {
                System.out.printf(" == > %s (%s)  ", p.getKey(), p.getValue());
                p = p.next;
            }
            System.out.println();
        }
    }




}
