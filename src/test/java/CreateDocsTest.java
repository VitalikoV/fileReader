import com.company.CreateDocs;
import com.company.CreateFolder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreateDocsTest {

    public static final String RESTRICTION = "Create files above or below restriction";
    public static final String CREATE_FILES_MORE_THAN_EXPECTED = "Create files more than expected";
    private static final String CREATE_FILES_WITH_RESTRICTION_MORE_THAN_EXPECTED = "Create files more than expected and above or below restriction";
    CreateDocs createDocs = new CreateDocs();
    ;
    CreateFolder createFolder = new CreateFolder();


    @AfterEach
    public void cleanDirectory() {
        createFolder.createDefaultFiles();
    }


    @Test
    @DisplayName("test for restrictions")
    public void createTestOutOfRestriction() {
        assertThrows(IllegalArgumentException.class,
                () -> createDocs.createFiles(100, 100001),
                RESTRICTION);

    }

    @Test
    @DisplayName("test for quantity of files")
    public void createTestOutOfQuantity() {
        assertThrows(IllegalArgumentException.class,
                () -> createDocs.createFiles(10001, 100),
                CREATE_FILES_MORE_THAN_EXPECTED);

    }

    @Test
    @DisplayName("test for quantity of files and restrictions")
    public void createTestOutOfQuantityAndRestriction() {
        assertThrows(IllegalArgumentException.class,
                () -> createDocs.createFiles(10001, 100001),
                CREATE_FILES_WITH_RESTRICTION_MORE_THAN_EXPECTED);

    }

    @Test
    @DisplayName("test for only quantity of files")
    public void createTestOutOfQuantityOnly() {
        assertThrows(IllegalArgumentException.class,
                () -> createDocs.createFiles(10001),
                CREATE_FILES_MORE_THAN_EXPECTED);

    }

}
