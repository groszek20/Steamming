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
            // 1. zastanow sie, czy nie warto tego wszystkiego, co sie dzieje w mainie, wyrzucic do osobnego serwisu
            // 2. wtedy zastanow sie tez, czy te klasy typu WordOperations nie powinny byc przekazane jako atrybuty klasy, tzn. w konstruktorze
            WordOperations wordOperation = new WordOperations();
            // takie rzeczy jak to "source.txt" wyrzuc do konfiga albo ewentualnie do jakiejs private final w tej klasie
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
            // jestes pewien, ze moga sie pojawic tylko te dwa typy exceptiona? jesli nie, to dodaj na samym koncu chaina generyczna obssluge Exception
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
