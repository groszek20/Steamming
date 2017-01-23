package com.adamdabrowski.words;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileOperations {

    private FileReader fileReader;

    public FileOperations(String fileInput) throws FileNotFoundException {
        this.fileReader = new FileReader(fileInput);
    }

    public String bufferedReadLine() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(this.fileReader);
        String buffer = bufferedReader.readLine();
        return buffer;
    }

    public void closeFileReader() throws IOException {
        this.fileReader.close();
    }

}
