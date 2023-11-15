package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main2 {

    public static void main(String[] args) {

        List<Book> list = new ArrayList<>();
        list.add(new Book("A", "B", 1990));
        list.add(new Book("A", "B", 1994));
        list.add(new Book("C", "D", 2000));
        list.add(new Book("E", "F", 2020));

        Map<String, List<Book>> collect = list.stream()
                .collect(Collectors.groupingBy(book -> book.getAuthor(), Collectors.toList()));


        System.out.println(collect);
    }
}
