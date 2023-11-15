package xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.ArrayList;
import java.util.List;

public class MainWithAuthors {

    public static void main(String[] args) throws JsonProcessingException {

        Author author = new Author("Лев", "Толстой");
        Author author1 = new Author("Лев", "Толстой");

        List<Author> authorList = new ArrayList<>();
        authorList.add(author);
        authorList.add(author1);

        BookWithAuthors book = new BookWithAuthors(authorList, "Детство", 2021);

        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String s = mapper.writeValueAsString(book);

        System.out.println(s);

        BookWithAuthors book1 = mapper.readValue(s, BookWithAuthors.class);
        System.out.println(book1);
    }
}
