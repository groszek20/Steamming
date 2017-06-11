/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adamdabrowski.words;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *
 * @author Adam
 */
public class MakeMePretty {

    public void makePretty() throws FileNotFoundException, UnsupportedEncodingException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("output.txt"), "8859_2"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("pretty.txt"), "8859_2"));
        String line = "";
        while ((line = reader.readLine()) != null) {
            if (numberOfWords(line) > 6) {
                line = line.replaceAll("\\s+", " ");
                writer.write(line + "\r\n");
            }
        }
        writer.close();
    }
    
    private static int numberOfWords(String line){
        Scanner scanner = new Scanner(line);
        int count = 0;
        while (scanner.hasNext()) {
            scanner.next();
            count++;
        }
        scanner.close();
        return count;
    }

}
