package com.adamdabrowski.main;

import com.adamdabrowski.words.FileOperations;
import com.adamdabrowski.words.WordOperations;
import java.util.List;

/**
 * Created by adam on 24/01/2017.
 */
public class App {

    public void run(){
        try {
            FileOperations fileOperations = new FileOperations("select2.txt","output.txt");

//            Dla plików txt          
//            String line = fileOperations.bufferedReadLineText();
//            WordOperations wordOperation = new WordOperations();
//            wordOperation.wordWriteToFile(line, fileOperations);
//            fileOperations.closeFiles();
            List<String> wordsList = fileOperations.bufferedReadLineCommaSeparated();
            WordOperations wordOperation = new WordOperations();
            wordsList.forEach(line -> wordOperation.wordWriteToFile(line, fileOperations));
            fileOperations.closeFiles();
        
        } catch (Exception e){
            e.printStackTrace();
        };
    }

}
