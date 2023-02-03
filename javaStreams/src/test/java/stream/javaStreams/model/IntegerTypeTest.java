package stream.javaStreams.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IntegerTypeTest {

    IntegerType integerType;

    @Test
    public void oneFilter() {

        List<Integer> integerList = IntStream.of(1,3,6,2,11,16,24,38,6,11)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(p -> p.getValue() > 1)
                .filter(p -> p.getValue() % 2 == 1)
                .sorted()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        assertEquals(integerList, integerType.integers);

    }
}