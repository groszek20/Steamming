package com.adamdabrowski.main;

import com.adamdabrowski.words.FileOperations;
import com.adamdabrowski.words.WordOperations;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        
        try {
            FileOperations fileOperations = new FileOperations("source.txt");
            WordOperations wordOperation = new WordOperations();
            PrintWriter wordWritter = new PrintWriter("output.txt");
            String line = fileOperations.bufferedReadLine();
            StringTokenizer stringTokenizer = new StringTokenizer(line);
            String element = "";
            while (stringTokenizer.hasMoreElements()) {
                element = stringTokenizer.nextElement().toString();
                element = wordOperation.wordFormat(element).toLowerCase();
                wordWritter.print(wordOperation.setWordStem(element)+ " ");
            }
            fileOperations.closeFileReader();
            wordWritter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
