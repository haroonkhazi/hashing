package hashTable;

import java.io.*;
import java.util.ArrayList;




public class mainFile{
    
    private static int alphSize = 256;
    //use of arraylist to store all the characters inside the file
    private static ArrayList<Character> al = new ArrayList<Character>();
    //array to compute the frequency of characters occurence
    private static int[] freq = new int[256];
    
    
    private static void scanFile(String inputFileName){
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
                    String[] splitString = line.split("[.!?'\\s]");
                }
            }
            bufferedReader.close();
        }catch (FileNotFoundException e){
        }catch (IOException e){}
}
