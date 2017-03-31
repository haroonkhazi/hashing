package hashTable;

import java.io.*;
import java.util.ArrayList;


public class hashMap{
    private transient hashEntry[] myHash;
    private transient int size;
    private int max;
    private float loadFactor;
    
    public hashMap(int inCapacity, int loadFactor){
        this.loadFactor = loadFactor;
        table = hashEntry[inCapacity];
        max = (int)(inCapacity * loadFactor);
    }
    
    public hashMap(int inCapacity){
        this(inCapacity, 0.75f);
    }
    
    public int size(){
        return size;
    }
    
    public String get(Object key){
        hashEntry[] t = table;
        int hash = key.hashcode();
        int index = (hash & 0x7FFFFFFF) % t.length;
        for (hashEntry i = t[index]; i != null; i = i.next){
            if (i.hash == hash && i.key.value.equals(key))
                return i.value;
        }
        return null;
    }
    
    public void rehash() {
        
    }
    
    
}
