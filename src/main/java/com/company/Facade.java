package com.company;

import java.io.FileNotFoundException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Facade {


    public static void execute(int quantityOfFiles, int restriction) throws FileNotFoundException {

        CreateFolder createFolder = new CreateFolder();
        createFolder.createDefaultFiles();

        CreateDocs createDocs = new CreateDocs();
        createDocs.createFiles(quantityOfFiles, restriction);

        MultiReader multiReader = new MultiReader();
        MultiReader multiReader2 = new MultiReader();

        multiReader.run();
        multiReader2.run();


        ExecutorService executorService = Executors.newWorkStealingPool(2);
        executorService.submit(multiReader);
        executorService.submit(multiReader2);
    }


}
