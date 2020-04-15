package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;

//Mediator
public class MultiReader implements Runnable {

    public static final String PATHNAME = "calculate_files";

    synchronized public void execute() throws FileNotFoundException {

        Reader reader = new Reader();
        Resolver resolver = new Resolver();
        ResultsWriter resultsWriter = new ResultsWriter();
        int count = quantityOfFiles();

        for (int i = 1; i <= count; i++) {
            ArrayList<Double> numbers = reader.getNumbers(count, i);
            int whatToDo = reader.getWhatToDo(count, i);
            double result = resolver.getResults(numbers, whatToDo);
            resultsWriter.writeResultsInOutputFile(result, i, count);
        }
    }

    public int quantityOfFiles() {
        return Objects.requireNonNull(new File(PATHNAME).list()).length;
    }


    @Override
    public void run() {
        try {
            execute();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
