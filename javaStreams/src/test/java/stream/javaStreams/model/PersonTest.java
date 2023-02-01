package stream.javaStreams.model;


import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


class PersonTest {

    Person p1 = new Person("Aleksa", 20, 71);
    Person p2 = new Person("Ana", 27, 45);
    Person p3 = new Person("Uros", 38, 60);
    Person p4 = new Person("Petra", 46, 71);
    List<Person> personList = Arrays.asList(p1, p2, p3, p4);

    @Test
    public void getOldestPerson() {
     Person oldest = personList.stream()
             .max(Comparator.comparing(Person::getAge))
             .orElseThrow(NoSuchElementException::new);

    assertEquals(oldest, personList.get(3));

    }

    @Test
    public void isPersonInList() {
        List<Person> person = personList.stream()
                .filter(value -> value.getPoints() > 50)
                .filter(value -> value.getAge() >25)
                .collect(Collectors.toList());

        assertThat(person).contains(p3);
    }

    @Test
    public void getSum() {
        int sum = 0;
        for (Person p : personList) {
            if (p.getPoints() > 10) {
                int points = p.getPoints();
                sum += points;
            }
        }

        assertThat(sum).isEqualTo(247);
    }

}