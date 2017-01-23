package com.adamdabrowski.words;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by adam on 18/01/2017.
 */
public class WordOperationsTest {
    @Test
    public void wordFormat() throws Exception {
        WordOperations wordOperations = new WordOperations();
        assertEquals("słowo", wordOperations.wordFormat(",@słowo,"));
    }

    @Test
    public void setWordStem() throws Exception {
        WordOperations wordOperations = new WordOperations();
        assertEquals("wiek", wordOperations.setWordStem("wieku"));
        assertEquals("Kmicic", wordOperations.setWordStem("Kmicic"));
    }

}