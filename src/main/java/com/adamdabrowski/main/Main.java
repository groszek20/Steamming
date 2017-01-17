package com.adamdabrowski.main;

import com.adamdabrowski.words.WordOperations;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import com.sun.xml.internal.fastinfoset.util.CharArray;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import morfologik.stemming.WordData;
import morfologik.stemming.polish.PolishStemmer;

public class Main {

    public static void main(String[] args) {
        try {
            WordOperations wordOperation = new WordOperations();
            FileReader fileReader = new FileReader("source.txt");
            PrintWriter wordWritter = new PrintWriter("output.txt");
            BufferedReader buff = new BufferedReader(fileReader);
            String line = buff.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(line);
            String element = "";
            while (stringTokenizer.hasMoreElements()) {
                element = stringTokenizer.nextElement().toString();
                element = wordOperation.wordFormat(element).toLowerCase();
                wordWritter.print(wordOperation.setWordStem(element)+ " ");
            }
            fileReader.close();
            wordWritter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
