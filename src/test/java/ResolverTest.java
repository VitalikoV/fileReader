import com.company.Resolver;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ResolverTest {

    Resolver resolver = new Resolver();
    ArrayList<Double> numbers = new ArrayList<Double>() {{
        add(42.77);
        add(57.23);
    }};

    @Test
    public void testForNumbers() {
        ArrayList<Double> wrongNumbers = new ArrayList<Double>() {{
            add(34.45);
            add(57.23);
            add(23.98);
        }};
        assertThrows(IllegalArgumentException.class,
                () -> resolver.getResults(wrongNumbers, 2)
        );
    }

    @Test
    public void testForWhatToDo() {
        assertThrows(IllegalArgumentException.class,
                () -> resolver.getResults(numbers, 6));
    }


    @Test
    public void testForCorrectAnswerPlus() {
        double expected = 100.0;
        double actual = resolver.getResults(numbers, 1);
        assertEquals(expected, actual, 0.5);
    }


    @Test
    public void testForCorrectAnswerMultiply() {
        double expected = 2447.72;
        double actual = resolver.getResults(numbers, 2);
        assertEquals(expected, actual, 0.5);
    }

    @Test
    public void testForCorrectAnswerDivision() {
        double expected = 0.7433;
        double actual = resolver.getResults(numbers, 3);
        assertEquals(expected, actual, 0.5);
    }

    @Test
    public void testForCorrectAnswerSumOfSquares() {
        double expected = 5104.54;
        double actual = resolver.getResults(numbers, 4);
        assertEquals(expected, actual, 0.5);
    }
}
