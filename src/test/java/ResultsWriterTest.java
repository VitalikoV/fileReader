import com.company.ResultsWriter;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ResultsWriterTest {

    String separator = File.separator;
    Scanner scanner = null;
    ResultsWriter resultsWriter;

    {
        try {
            resultsWriter = new ResultsWriter();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws FileNotFoundException {

        String expected = "Result of doc1.txt = 100.0";
        resultsWriter.writeResultsInOutputFile(100, 1, 1);
        openFile();
        String actual = scanner.nextLine();
        Assert.assertEquals(expected, actual);

    }


    private void openFile() throws FileNotFoundException {
        String path = createPath(separator);
        File file = new File(path);
        scanner = new Scanner(file);
    }


    private static String createPath(String separator) {
        return separator + "Users" + separator + "macbook" + separator + "Documents" + separator + "fileReader" + separator + "results" + separator + "out.txt";
    }
}
