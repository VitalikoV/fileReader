import com.company.CreateDocs;
import com.company.CreateFolder;
import com.company.Reader;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ReaderTest {

    Reader reader = new Reader();
    String separator = File.separator;
    String path = createPath(separator);
    PrintWriter printWriter;

    {
        try {
            printWriter = new PrintWriter(path);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }


    @Test
    public void test1() {
        printWriter.println("6");
        printWriter.println("23.24 56.23");
        printWriter.flush();
        Assert.assertThrows(IllegalArgumentException.class,
                () -> reader.getWhatToDo(1, 1));
    }

    @Test
    public void test2() {
        printWriter.println("3");
        printWriter.println("23.43 24.43 24.23");
        printWriter.flush();
        Assert.assertThrows(IllegalArgumentException.class,
                () -> reader.getNumbers(1, 1));
    }


    private static String createPath(String separator) {
        return separator + "Users" + separator + "macbook" + separator + "Documents" + separator + "fileReader" + separator + "calculate_files" + separator + "doc1.txt";
    }

}
