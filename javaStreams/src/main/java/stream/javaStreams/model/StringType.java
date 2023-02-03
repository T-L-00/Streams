package stream.javaStreams.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StringType {

    public List<String> string = Arrays.asList("Java", "Php", "Streams", "Python", "MySQL");


}
