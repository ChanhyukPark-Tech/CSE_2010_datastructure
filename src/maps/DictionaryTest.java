package maps;

import java.util.*;

import static java.util.Collections.emptyList;

class CustomMultiMap<K extends Comparable<K>, V>{
    private Map<K, List<V>> dic = new HashMap<>();

    public void add(K key, V newValue){
        List<V> currentValue = dic.get(key);
        if(currentValue == null){
            currentValue = new ArrayList<>();
            dic.put(key,currentValue);
        }
        currentValue.add(newValue);
    }

    public void add(K key, List<V> values){
        List<V> currentValue = dic.get(key);
        if(currentValue == null){
            currentValue = new ArrayList<>();
            dic.put(key,currentValue);
        }
        currentValue.addAll(values);
    }

    public int size(){
        return dic.values().stream().mapToInt(Collection::size).sum();
    }

    public List<V> get(K key){
        List<V> result = dic.get(key);
        return result != null ? result : emptyList();

    }
    public V remove(K key){
        List<V> result = dic.get(key);
        if(result == null){
            return null;
        }

        V value = result.get(0);
        result.remove(0);
        if(result.isEmpty()){
            dic.remove(key);
        }
        return value;
    }

    


}

public class DictionaryTest {
}
