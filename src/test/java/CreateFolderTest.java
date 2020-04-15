import com.company.CreateFolder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateFolderTest {
    public static final String TEST_FOLDER = "test_folder";
    public static final String RESULTS = "results";
    public static final String CALCULATE_FILES = "calculate_files";
    CreateFolder createFolder = new CreateFolder();
    boolean expected = true;


    @Test
    public void testForCreateFiles() {
        createFolder.createFiles(TEST_FOLDER);
        boolean actual = false;
        actual = changeActual(actual, TEST_FOLDER);
        Assert.assertEquals(expected, actual);
        deleteFolder();
    }


    @Test
    public void testForCreateDefaultFiles() {
        createFolder.createDefaultFiles();

        boolean actual = false;

        actual = changeActual(actual, CALCULATE_FILES, RESULTS);

        Assert.assertEquals(expected, actual);

    }


    private boolean changeActual(boolean actual, String nameOfFile) {
        if (isDirectoryExist(nameOfFile)) {
            actual = true;
        }
        return actual;
    }


    private boolean changeActual(boolean actual, String nameOfFirstFile, String nameOfSecondFile) {
        if (isDirectoryExist(nameOfFirstFile) && isDirectoryExist(nameOfSecondFile)) {
            actual = true;
        }
        return actual;
    }


    private boolean isDirectoryExist(String path) {
        return Files.isDirectory(Paths.get(path));
    }

    private void deleteFolder() {
        try {
            Files.deleteIfExists(Paths.get(TEST_FOLDER));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
