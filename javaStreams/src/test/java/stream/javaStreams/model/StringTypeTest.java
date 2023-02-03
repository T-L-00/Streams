package stream.javaStreams.model;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertNotNull;

@RunWith(SpringRunner.class)
public class StringTypeTest {

    StringType stringType;

    @Test
    public void oneFilter() {
        List<String> stringList =
                stringType.string.stream()
                        .filter(p -> p.length() > 5)
                        .filter(p -> p.length() <= 7)
                        .filter(p -> p.startsWith("P"))
                        .toList();

        assertNotNull(stringList);
    }

    @Test
    public void multipleFilter() {
        List<String> strings = stringType.string.stream()
                .filter(p -> p.length() > 5 && p.length() <= 7 && p.startsWith("P"))
                .toList();

        assertNotNull(strings);
    }

}