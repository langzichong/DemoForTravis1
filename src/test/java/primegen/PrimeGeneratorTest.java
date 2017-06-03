package primegen;

import com.github.approval.Approval;
import com.github.approval.converters.Converters;
import com.github.approval.converters.ListConverter;
import com.github.approval.pathmappers.JunitPathMapper;
import com.github.approval.reporters.Reporters;
import org.junit.Rule;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PrimeGeneratorTest {
    private final Path PARENT_PATH = Paths.get("src/test/resources");

    @Rule
    public JunitPathMapper pathMapper = new JunitPathMapper(PARENT_PATH);

    private Approval<List> APPROVAL = Approval
            .of(List.class)
            .withPathMapper(pathMapper)
            .withReporter(Reporters.console())
            .withConveter(new ListConverter(Converters.STRING))
            .build();

    @Test
    public void should_generate_primes() {
        int[] nullArray = new PrimeGenerator().generatePrimes(0);
        assertEquals(0, nullArray.length);

        int[] minArray = new PrimeGenerator().generatePrimes(2);
        assertEquals(1, minArray.length);
        assertEquals(2, minArray[0]);

        int[] threeArray = new PrimeGenerator().generatePrimes(3);
        assertEquals(2, threeArray.length);
        assertEquals(2, threeArray[0]);
        assertEquals(3, threeArray[1]);

        int[] foreArray = new PrimeGenerator().generatePrimes(2000);
        for(int i=0;i<foreArray.length;i++){
            System.out.println(foreArray[i]);
        }
    }

    @Test
    public void should_generate_primes_from_0_to_500() {
        List<String> actual = new ArrayList<>();
        for (int i = 0; i <= 500; i++) {
            int[] primes = new PrimeGenerator().generatePrimes(i);
            actual.add(Arrays.toString(primes));
        }
        APPROVAL.verify(actual, Paths.get("0 to 500"));
    }

}
