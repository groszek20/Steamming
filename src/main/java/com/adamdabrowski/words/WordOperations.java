/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adamdabrowski.words;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import morfologik.stemming.WordData;
import morfologik.stemming.polish.PolishStemmer;

/**
 *
 * @author Adam
 */
public class WordOperations {

    public String wordFormat(String word) {
        String formattedWord = "";
        // tu tez sie zastanow, czy nie warto wrzucic regexpa do jakiegos public final tej klasy; ale to juz bardziej dyskusyjne niz w mainie; reszta wyglada ok :)
        Pattern pattern = Pattern.compile("[a-zA-Ząćęłńóśźż]+");
        Matcher matcher = pattern.matcher(word);
        while (matcher.find()) {
            formattedWord = matcher.group(0);
        }
        return formattedWord;
    }

    public String setWordStem(String word) {
        PolishStemmer stemmer = new PolishStemmer();
        ArrayList<CharSequence> stemList = new ArrayList<CharSequence>();
        List<WordData> processing = stemmer.lookup(word);
        processing.stream().forEach((wordData) -> {
            stemList.add(wordData.getStem());
        });
        if (stemList.size() > 0) {
            return stemList.get(0).toString();
        } else {
            return word;
        }
    }

    public void wordWriteToFile(String line, FileOperations fileOperations) {
        StringTokenizer stringTokenizer = new StringTokenizer(line);
        String element = "";
        while (stringTokenizer.hasMoreElements()) {
            element = stringTokenizer.nextElement().toString();
            element = wordFormat(element).toLowerCase();
            fileOperations.wordWriter(setWordStem(element)+ " ");
        }
    }

}
