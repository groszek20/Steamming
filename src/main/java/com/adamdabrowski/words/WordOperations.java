/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adamdabrowski.words;

import java.util.ArrayList;
import java.util.List;
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
        Pattern pattern = Pattern.compile("[a-zA-Ząćęłńóśźż]+");
        Matcher matcher = pattern.matcher(word);
        while (matcher.find()) {
            formattedWord = matcher.group(0);
        }
        return formattedWord;
    }

    public String setWordStem(String word) {
        PolishStemmer stemmer = new PolishStemmer();
        ArrayList<CharSequence> ListaStem = new ArrayList<CharSequence>();
        List<WordData> processing = stemmer.lookup(word);
        processing.stream().forEach((wd) -> {
            ListaStem.add(wd.getStem());
        });
        if (ListaStem.size() > 0) {
            return word = ListaStem.get(0).toString();
        } else {
            return word;
        }
    }

}
