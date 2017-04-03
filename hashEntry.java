package hashTable;

import java.io.*;
import java.util.ArrayList;


public class hashEntry{
    
    //hash #
    int hash;
    //key of hashEntry
    Object key;
    //word of the entry
    String value;
    //the next hashentry after this
    hashEntry next;
    //number of times this word has come up
    int count;
    /**
     * @return String value containing word of entry and the count
     */
    @Override
    public String toString(){
        String st = value + " " + count;
        return st;
    }
    
}
