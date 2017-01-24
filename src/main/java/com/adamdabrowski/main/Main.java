package com.adamdabrowski.main;

import com.adamdabrowski.words.FileOperations;
import com.adamdabrowski.words.WordOperations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
