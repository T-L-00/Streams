package streams.string.model;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@RunWith(SpringRunner.class)
public class stringTypeTest {

    StopWatch watch = new StopWatch();

    List<String> stringList = Arrays.asList("Java", "Php", "Python", "C", "Streams", "Java", "PostGre");

    @Test
    public void filterTest() {
        List <StringType> newList = new ArrayList<>();
        watch.start();
       stringList.stream()
                .filter(p -> p.length() > 5)
                .filter(p -> p.length() <= 7)
                .filter(p -> p.startsWith("S"))
                .collect(Collectors.toList());
        watch.stop();

        assertNotNull(newList);
        log.info("Total execution time to filter items: " + watch.getTotalTimeSeconds());
    }

    @Test
    public void multipleFilters() {
        List<StringType> list = new ArrayList<>();
        stringList.stream()
                .filter(p -> p.length() > 5 && p.length() <=7 && p.startsWith("S"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        assertNotNull(list);
        log.info("Total execution time to filter items with multiple filter: " + watch.getTotalTimeSeconds());
    }

    @Test
    public void parallelFilters() {
        List<String> parallelList = new ArrayList<>();
        watch.start();
        for(String s: parallelList) {
            if(s.length() > 5 && s.length() <=7 && s.startsWith("S")){
                parallelList.add(s);
            }
        }
        watch.stop();

        assertNotNull(parallelList);
        log.info("Total execution time to filter items with parallel filter : " + watch.getTotalTimeSeconds());
    }
}