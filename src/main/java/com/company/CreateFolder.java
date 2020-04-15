package com.company;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CreateFolder {

    public static final String CALCULATE = "calculate_files";
    public static final String RESULTS = "results";

    public void createDefaultFiles() {

        createFiles(CALCULATE);
        createFiles(RESULTS);

    }


    public void createFiles(String nameOfFile) {
        File index = new File(nameOfFile);

        try {
            FileUtils.deleteDirectory(index);
            FileUtils.forceMkdir(index);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
