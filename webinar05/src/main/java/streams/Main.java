package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {

        List<Book> list = new ArrayList<>();
        list.add(new Book("A", "B", 1990));
        list.add(new Book("A", "B", 1994));
        list.add(new Book("C", "D", 2000));
        list.add(new Book("E", "F", 2020));

        List<Book> list1 = new ArrayList<>();
        for (Book book : list) {
            if (book.getYear() > 1995) {
                list1.add(book);
            }
        }

        System.out.println(list1);

//        int i = 1995;
//        i = 1996;

//        List<Book> collect = list.stream()
////                .filter((book) -> {
////                    return book.getYear() < i;
////                })
////                .filter(book -> book.getAuthor().startsWith("A"))
//                .collect(Collectors.toList());

//        Set<String> collect = list.stream()
//                .map(book -> book.getAuthor())
//                .collect(Collectors.toSet());
//
//        System.out.println(collect);

        List<List<Book>> l = new ArrayList<>();
        List<Book> l1 = new ArrayList<>();
        l1.add(new Book("A", "B", 1990));
        List<Book> l2 = new ArrayList<>();
        l2.add(new Book("A", "B", 1994));
        List<Book> l3 = new ArrayList<>();
        l3.add(new Book("C", "D", 2000));
        l3.add(new Book("C", "D", 2020));

        l.add(l1);
        l.add(l2);
        l.add(l3);

        System.out.println(l);

        List<Book> collect = l.stream()
                .flatMap(ll -> ll.stream())
                .collect(Collectors.toList());

        System.out.println(collect);

        long count = l.stream()
                .flatMap(ll -> ll.stream())
                .count();
        System.out.println(count);

    }
}
