package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ResultsWriter {


    PrintWriter printWriter = new PrintWriter("results/out.txt");
    int countOfWroteResults = 0;

    public ResultsWriter() throws FileNotFoundException {
    }

    public void writeResultsInOutputFile(double result, int position, int quantityOfFiles) {
        printWriter.println("Result of doc" + position + ".txt = " + result);
        countOfWroteResults++;
        isAlreadyToClose(quantityOfFiles);

    }


    private void isAlreadyToClose(int quantityOfFiles) {
        if (countOfWroteResults == quantityOfFiles) {
            printWriter.close();
        }
    }
}

