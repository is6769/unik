package algorithms.semester1.practice4.myHashMap;

import java.util.*;

public class MyHashMap<K,V> {

    private int SIZE=8;
    private final double loadFactor=0.75;
    private ArrayList<LinkedList<MyEntry<K,V>>> values = new ArrayList<>();


    public MyHashMap() {
        initValues();
    }

    public MyHashMap(int size) {
        SIZE=size;
        initValues();
    }

    private void initValues(){
        for (int i = 0; i < SIZE; i++) {
            values.add(null);
        }
    }

    public void put(K key,V value){
        var index=index(hash(key));
        if (values.get(index)==null) {
            values.set(index, new LinkedList<>());
        }
        ifEntryWithKeyExistsDelete(index,key);
        values.get(index).add(new MyEntry<K,V>(key,value));
        if (values.stream().filter(Objects::nonNull).map(LinkedList::size).reduce(Integer::sum).orElse(0)/(double) SIZE  >= loadFactor){
            for (int i = 0; i < SIZE; i++) {
                values.add(null);
            }
            SIZE=SIZE*2;
            recreateValuesWithNewSize();
        }
    }

    public void remove(K key){
        var index=index(hash(key));
        ifEntryWithKeyExistsDelete(index,key);
    }

    private void recreateValuesWithNewSize(){
        var oldValues=values;
        values=new ArrayList<>();
        initValues();
        oldValues.stream().filter(Objects::nonNull)
                .forEach(bucket->
                        bucket.forEach(entry->
                                put(entry.getKey(), entry.getValue())));
    }

    private boolean getInnerIndex(int index,K key) {
        return values.get(index).stream().anyMatch(key::equals);
    }

    private void ifEntryWithKeyExistsDelete(int index, K key) {
        values.get(index).removeIf(entry -> entry.getKey().equals(key));
    }

    private int hash(K key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private int index(int h){
        return h & (SIZE-1);
    }

    public V get(K key){
        var index=index(hash(key));
        for (MyEntry<K,V> entry: values.get(index) ){
            if (entry.getKey().equals(key)){
                return entry.getValue();
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        MyHashMap<String,Object> myHashMap=new MyHashMap<>();
        myHashMap.put("aaaa",1);
        myHashMap.put("aab",2);
        myHashMap.put("aac",3);
        myHashMap.put("aaq",4);
        myHashMap.put("a1z",5);
        myHashMap.put("a2z",5);
        myHashMap.put("a3z",5);
        myHashMap.put("a4z",5);
        myHashMap.put("a5z",5);
        System.out.println(myHashMap.get("a5z"));
        myHashMap.put("a5z",6);
        myHashMap.remove("a5z");
        //System.out.println(myHashMap.get("a5z"));


    }
}
