/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adamdabrowski.words;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adam
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
        assertEquals("spotkać", wordOperations.setWordStem("spotkała"));
}
    
}
