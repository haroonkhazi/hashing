package hashTable;

import java.io.*;
import java.util.ArrayList;


public class hashEntry{
    
    
    int hash;
    Object key;
    String value;
    hashEntry next;
    int count;
    @Override
    public String toString(){
//System.out.println("toString");
        String st = value + " " + count;
        return st;
    }
    
}
