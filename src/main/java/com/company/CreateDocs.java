package com.company;


import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CreateDocs {
    PrintWriter printWriter;

    public CreateDocs() {
    }

    public void createFiles(int quantityOfFiles) throws FileNotFoundException {

        exceptionsForCreateFile(quantityOfFiles);

        for (int i = 1; i <= quantityOfFiles; i++) {
            printWriter = new PrintWriter("calculate_files/doc" + i + ".txt");
            printWriter.println(giveRandomAction());
            printWriter.print(giveRandomNumber());

            printWriter.close();
        }

    }

    public void createFiles(int quantityOfFiles, int restriction) throws FileNotFoundException {

        exceptionsForCreateFile(quantityOfFiles, restriction);

        for (int i = 1; i <= quantityOfFiles; i++) {
            printWriter = new PrintWriter("calculate_files/doc" + i + ".txt");
            printWriter.println(giveRandomAction());
            printWriter.print(giveRandomNumberWithRestriction(restriction));

            printWriter.close();
        }
    }


    protected static int giveRandomAction() {
        return (int) (Math.random() * 4 + 1);
    }

    protected static String giveRandomNumber() {
        return (Math.random() * 1000 + " " + Math.random() * 1000);
    }

    protected static String giveRandomNumberWithRestriction(int restriction) {
        return (Math.random() * restriction + " " + Math.random() * restriction);
    }


    private void exceptionsForCreateFile(int quantityOfFiles, int restriction) {

        if (quantityOfFiles < 0 || quantityOfFiles > 10000) {
            throw new IllegalArgumentException("Quantity of files must be above 0, but below 10000");
        }
        if (restriction < 0 || restriction > 100000) {
            throw new IllegalArgumentException("Restriction must be from 0 to 100000");
        }

    }


    private void exceptionsForCreateFile(int quantityOfFiles) {
        if (quantityOfFiles < 0 || quantityOfFiles > 10000) {
            throw new IllegalArgumentException("Quantity of files must be above 0, but below 10000");
        }
    }


}
