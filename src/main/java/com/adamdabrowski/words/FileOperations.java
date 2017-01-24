package com.adamdabrowski.words;

import java.io.*;

public class FileOperations {

    private FileReader fileReader;
    private PrintWriter printWriter;

    public FileOperations(String fileInput, String fileOutput) throws FileNotFoundException {
        this.fileReader = new FileReader(fileInput);
        this.printWriter = new PrintWriter(fileOutput);
    }

    public String bufferedReadLine() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(this.fileReader);
        String buffer = bufferedReader.readLine();
        return buffer;
    }

    public void wordWriter(String word) {
        this.printWriter.print(word);
    }

    public void closeFiles() throws IOException{
        this.fileReader.close();
        this.printWriter.close();
    }

}
