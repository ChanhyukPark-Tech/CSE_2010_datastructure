package Hash;

public class OpenHash<K, V> {

    // 버킷의 상태
    enum Status {OCCUPIED, EMPTY, DELETED}

    ;         //{데이터 저장, 비어있음 , 삭제 마침 }

    // 버킷

    static class Bucket<K, V> {
        private K key;
        private V data;
        private Status stat;                // status;


        // constructor
        Bucket() {
            stat = Status.EMPTY;
        }


        //모든 필드에 값을 설정합니다
        void set(K key, V data, Status stat){
            this.key = key;                 // 키 값
            this.data = data;             // 데이터
            this.stat = stat;           //상태
        }

        void setStat(Status stat){
            this.stat = stat;
        }

        K getKey(){
            return key;
        }

        V getValue(){
            return data;
        }

        // 키의 해시 값을 반환합니다
        public int hashCode(){
            return key.hashCode();
        }
    }

    private int size;
    private Bucket<K,V>[] table;


    public OpenHash(int size){
        try {
            table = new Bucket[size];
            for (int i = 0; i < size; i++) {
                table[i] = new Bucket<K, V>();
            }
            this.size = size;
        }catch (OutOfMemoryError e ){       // 테이블을 생성할 수 없음
            this.size = 0;
        }
    }

    //해시 값을 구함
    public int hashValue(Object key){
        return key.hashCode() % size;
    }

    // 재해시 값을 구함
    public int rehashValue(int hash){
        return (hash + 1 ) % size ;
    }

    private Bucket<K,V> searchNode(K key){
        int hash = hashValue(key);          //검색할 데이터의 해시 값
        Bucket<K,V> p = table[hash];            //선택 버킷

        for(int i = 0 ; p.stat != Status.EMPTY && i < size; i++){
            if(p.stat == Status.OCCUPIED && p.getKey().equals(key)){
                return p ;
            }
            hash = rehashValue(hash);
            p = table[hash];
        }
        return null;
    }

}
