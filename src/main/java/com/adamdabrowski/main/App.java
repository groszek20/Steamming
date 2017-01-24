package com.adamdabrowski.main;

import com.adamdabrowski.words.FileOperations;
import com.adamdabrowski.words.WordOperations;

/**
 * Created by adam on 24/01/2017.
 */
public class App {

    public void run(){
        try {
            FileOperations fileOperations = new FileOperations("source.txt","output.txt");
            WordOperations wordOperation = new WordOperations();
            String line = fileOperations.bufferedReadLine();
            wordOperation.wordWriteToFile(line, fileOperations);
            fileOperations.closeFiles();
        } catch (Exception e){
            e.printStackTrace();
        };
    }

}
