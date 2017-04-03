package hashTable;

import java.io.*;
import java.util.ArrayList;


public class hashMap{
    private  hashEntry[] myHash;
    private  int size;
    private int max;
    private float loadFactor;
    
    public hashMap(int inCapacity, float loadFactor){
        this.loadFactor = loadFactor;
        myHash = new hashEntry[inCapacity];
        max = (int)(inCapacity * loadFactor);
    }
    
    public hashMap(int inCapacity){
        this(inCapacity, 0.75f);
    }
    
    public int size(){
        return size;
    }
    
    public hashEntry get(Object key){
        hashEntry[] t = myHash;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % t.length;
        for (hashEntry i = t[index]; i != null; i = i.next){
            if (i.hash == hash && i.key.equals(key)){
                return i;
            }
        }
        return null;
    }
    
    public void rehash() {
        int oldCap = myHash.length;
        hashEntry[] oldHash = myHash;
        
        int newCap = oldCap * 2 + 1;
        hashEntry[] newHash = new hashEntry[newCap];
        max = (int)(newCap * loadFactor);
        myHash = newHash;
        
        for(int i = oldCap; i-- > 0;){
            for(hashEntry old = oldHash[i]; old != null;){
                hashEntry entry = old;
                old = old.next;
                
                int index = (entry.hash & 0x7FFFFFFF) % newCap;
                entry.next = newHash[index];
                newHash[index] = entry;
            }
        }
        
    }
    public Object put(Object key, String value){
        if (value == null) {
            throw new NullPointerException();
        }
       
        hashEntry[] t = myHash;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % t.length;
        for (hashEntry i = t[index]; i != null; i = i.next){
            if (i.hash == hash && i.key.equals(key)){
                String old = i.value;
                i.value = value;
                i.count++;
                return old;
            }
        }
        if (size >= max){
            rehash();
            //System.out.println(myHash.length);

            return put(key, value);
        }
        
        hashEntry entry = new hashEntry();
        entry.hash = hash;
        entry.key = key;
        entry.value = value;
        entry.next = t[index];
        entry.count = 1;
        t[index] = entry;
        size++;
        return null;
    }
    
    public Object[] getKeys(){
        Object[] keys = new Object[myHash.length];
        hashEntry[] t = myHash;
        for (int i = 0; i < t.length; i++){
            if (t[i] != null)
                keys[i] = t[i].key;
        }
        return keys;
    }
}




