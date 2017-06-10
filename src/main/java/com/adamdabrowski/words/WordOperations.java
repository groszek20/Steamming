/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adamdabrowski.words;

import java.io.IOException;
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
        String empty = "";
        if (removeCharacters(word).length() <= 2) {
            return empty;
        } else if (userFilter(word) == true) {
            return "@user";
        } else if (word.contains("https://") == true) {
            return empty;
        } else if (stopWord(word) == true) {
            return empty;
        } else {
            word = word.replaceAll("(.)\\1{1,}", "$1");
            return removeCharacters(word);
        }
    }

    public String removeCharacters(String word) {
        String formattedWord = "";
        Pattern pattern = Pattern.compile("[a-zA-Ząćęłńóśźż]+");
        Matcher matcher = pattern.matcher(word);
        while (matcher.find()) {
            formattedWord = matcher.group(0);
        }
        return formattedWord;
    }

    public boolean userFilter(String word) {
        boolean isUser = true;
        if (word.charAt(0) == '@' || word.charAt(1) == '@' ) {
            return isUser;
        } else {
            isUser = false;
            return isUser;
        }
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
        if (line == ";0") {
            fileOperations.wordWriter(line + "\r\n");
        }
        if (line == ";1") {
            fileOperations.wordWriter(line + "\r\n");
        }
        StringTokenizer stringTokenizer = new StringTokenizer(line);
        String element = "";
        while (stringTokenizer.hasMoreElements()) {
            element = stringTokenizer.nextElement().toString();
            element = wordFormat(element).toLowerCase();
            fileOperations.wordWriter(setWordStem(element) + " ");
        }
    }

    public boolean stopWord(String word) {
        boolean isStopList = false;
        FileOperations fo = new FileOperations();
        List<String> list = null;
        try {
            list = fo.stopWordList();
        } catch (IOException ex) {
            System.err.println(ex);
        }
        for (int i = 0; i < list.size(); i++) {
            if (word.equals(list.get(i))) {
                isStopList = true;
            }
        }
        return isStopList;
    }

}
