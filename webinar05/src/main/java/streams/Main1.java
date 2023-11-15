package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main1 {

    public static void main(String[] args) {

        List<Book> list = new ArrayList<>();
        list.add(new Book("A", "B", 1990));
        list.add(new Book("A", "B", 1994));
        list.add(new Book("C", "D", 2000));
        list.add(new Book("E", "F", 2020));

        Map<String, Book> collect = list.stream()
                .collect(Collectors.toMap(book -> book.getAuthor(), Function.identity(), (a, b) -> a));


        System.out.println(collect);
    }
}
