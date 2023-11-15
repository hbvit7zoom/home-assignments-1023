package xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {

        Book book = new Book("Толстой", "Детство", 2021);

        XmlMapper mapper = new XmlMapper();

        String s = mapper.writeValueAsString(book);

        System.out.println(s);

        Book book1 = mapper.readValue(s, Book.class);
        System.out.println(book1);
    }
}
