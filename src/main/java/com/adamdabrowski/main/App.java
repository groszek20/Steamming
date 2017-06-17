package com.adamdabrowski.main;

import com.adamdabrowski.words.FileOperations;
import com.adamdabrowski.words.MakeMePretty;
import com.adamdabrowski.words.WordOperations;
import java.util.List;

/**
 * Created by adam on 24/01/2017.
 */
public class App {

    public void run(){
        try {
            FileOperations fileOperations = new FileOperations("select1","output.txt");
            FileOperations noSteamfileOperations = new FileOperations("select1","noSteamOutput.txt");
            MakeMePretty iAmPretty = new MakeMePretty();

//            Dla plików txt          
//            String line = fileOperations.bufferedReadLineText();
//            WordOperations wordOperation = new WordOperations();
//            wordOperation.wordWriteToFile(line, fileOperations);
//            fileOperations.closeFiles();

            List<String> wordsList = fileOperations.bufferedReadLineCommaSeparated();
            WordOperations wordOperation = new WordOperations();
            wordsList.forEach(line -> wordOperation.stemWordWrite(line, fileOperations));
            wordsList.forEach(line -> wordOperation.noStemWordWrite(line, noSteamfileOperations));
            fileOperations.closeFiles();
            iAmPretty.makePretty("output.txt","pretty.txt");
            iAmPretty.makePretty("noSteamOutput.txt","noSteamPretty.txt");
        
        } catch (Exception e){
            e.printStackTrace();
        };
    }

}
