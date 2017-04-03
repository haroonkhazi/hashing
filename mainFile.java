package hashTable;

import java.io.*;
import java.util.ArrayList;




public class mainFile{
    //initialise a hashmap
    private static hashMap map = new hashMap(256);
    /**
     * populating hashmap
     * @param String inputFileName, takes a filename for which you want to get word count for
     */
    private static void wordCount(String inputFileName){
        //initialise the line.
        String line;
        try {
            //create a file reader
            FileReader fileReader = new FileReader(inputFileName);
            //create a buffered reader
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //go until end of file
            while((line = bufferedReader.readLine()) != null) {
                //if line is not empty
                if (!line.isEmpty()){
                    //Split string with delimineters
                    String[] splitString = line.trim().split("[.,!?'\\s+]");
                    //for loop for the hashmap
                    for(int i = 0; i < splitString.length; i++){
                        //value for hashmap
                        String value = splitString[i].toLowerCase();
                        //key value
                        Object key = value.hashCode();
                        //input into hashmap
                        map.put(key, value);
                    }
                }
            }
            //close reader
            bufferedReader.close();
        }catch (FileNotFoundException e){
        }catch (IOException e){}
    }
    
    public static void main(String[] args) {
        //name to save the count
        String countName = args[0].substring(0, args[0].length()-4) + "_count.txt";
        //use File IO to create file with tablename
        File countFile = new File(countName);
        //call wordCount method.
        wordCount(args[0]);
        //call getkeys method to save keys to array
        Object[] keys = map.getKeys();
        try{
            //create a file
            countFile.createNewFile();
            //printstream
            PrintStream tableWriter = new PrintStream(new FileOutputStream(countFile));
            //for each key
            for(Object key : keys){
                //if the key is not null and value is not an empty string
                if (key != null && !map.get(key).value.equals("")){
                    //print 
                   tableWriter.println(map.get(key).toString());
                   System.out.println(map.get(key).toString());
                }
            }
        }catch (IOException e){}
    }

    
}
