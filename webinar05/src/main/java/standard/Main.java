package standard;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Book book = new Book("Пушкин", "Капитанская дочка", 2020);
//        System.out.println(book);
//
//        OutputStream os = Files.newOutputStream(Paths.get("book.bin"));
//        ObjectOutputStream oos = new ObjectOutputStream(os);
//
//        oos.writeObject(book);
//        oos.close();

        InputStream is = Files.newInputStream(Paths.get("book.bin"));
        ObjectInputStream ois = new ObjectInputStream(is);

        Book book1 = (Book) ois.readObject();

        System.out.println(book1);
    }
}
