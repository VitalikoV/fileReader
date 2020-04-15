package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    String separator = File.separator;
    Scanner scanner = null;
    int countScannedFiles = 0;


    public int getWhatToDo(int quantityOfFiles, int temporaryFile) throws FileNotFoundException {
        openFile(quantityOfFiles, temporaryFile);
        int whatToDo = Integer.parseInt(scanner.nextLine());
        invalidArgumentException(whatToDo);
        return whatToDo;
    }


    public ArrayList<Double> getNumbers(int quantityOfFiles, int temporaryFile) throws FileNotFoundException {
        openFile(quantityOfFiles, temporaryFile);
        String[] stringNumbers = getNumbersFromFile();
        ArrayList<Double> numbers = changeType(stringNumbers);
        invalidSizeException(numbers);
        return numbers;
    }

    private void invalidSizeException(ArrayList<Double> numbers) {
        if (numbers.size() > 2) {
            throw new IllegalArgumentException("There are must be 2 double format numbers");
        }
    }


    private void openFile(int quantityOfFiles, int temporaryFile) throws FileNotFoundException {

        String path = createPath(temporaryFile, separator);
        File file = new File(path);
        if (!(file.canRead())) throw new FileNotFoundException();
        scanner = new Scanner(file);
        countScannedFiles++;

        isScannerAlreadyToClose(quantityOfFiles);
    }

    private String[] getNumbersFromFile() {
        scanner.nextLine();
        String lineOfNumbers = scanner.nextLine();
        return lineOfNumbers.split(" ");
    }


    private static ArrayList<Double> changeType(String[] strNumbers) {
        ArrayList<Double> numbers = new ArrayList<>();
        for (String number : strNumbers) {
            try {
                numbers.add(Double.parseDouble(number));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("There are must be double format numbers: " + e);
            }
        }
        return numbers;
    }


    private static String createPath(int temporaryFile, String separator) {
        return separator + "Users" + separator + "macbook" + separator + "Documents" + separator + "fileReader" + separator + "calculate_files" + separator + "doc" + temporaryFile + ".txt";
    }


    private void isScannerAlreadyToClose(int quantityOfFiles) {
        int realQuantity = quantityOfFiles * 2 + 1;
        if (countScannedFiles == realQuantity) {
            scanner.close();
        }
    }


    private void invalidArgumentException(int whatToDo) {
        if (whatToDo < 1 || whatToDo > 4)
            throw new IllegalArgumentException();
    }

}



