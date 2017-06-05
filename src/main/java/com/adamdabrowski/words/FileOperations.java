package com.adamdabrowski.words;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileOperations {

    private FileReader fileReader;
    private PrintWriter printWriter;

    public FileOperations(String fileInput, String fileOutput) throws FileNotFoundException {
        this.fileReader = new FileReader(fileInput);
        this.printWriter = new PrintWriter(fileOutput);
    }

    FileOperations() {
    }

    public String bufferedReadLineText() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(this.fileReader);
        String buffer = bufferedReader.readLine();
        return buffer;
    }

    public List<String> bufferedReadLineCommaSeparated() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(this.fileReader);
        List<String> list = new ArrayList<String>();
        String line = "";
        String cvsSplitBy = ",";
        String[] buffer = null;
        while ((line = bufferedReader.readLine()) != null) {
            // use comma as separator
            buffer = line.split(cvsSplitBy);
            list.add(buffer[0]);
        }
        return list;
    }

    public void wordWriter(String word) {
        this.printWriter.print(word);
    }

    public void closeFiles() throws IOException {
        this.fileReader.close();
        this.printWriter.close();
    }

    public List<String> stopWordList() throws IOException {
        List<String> lista = new ArrayList<>();
        try {
            FileReader fr = new FileReader("stopwords.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                lista.add(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
