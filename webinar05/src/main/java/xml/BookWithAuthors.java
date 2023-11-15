package xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "book")
public class BookWithAuthors {

//    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlElementWrapper(localName = "authors")
    @JacksonXmlProperty(localName = "author")
    private List<Author> authors;

    @JacksonXmlProperty(localName = "name")
    private String title;
    private Long year;

    public BookWithAuthors() {
    }

    public BookWithAuthors(List<Author> authors, String title, int year) {
        this.authors = authors;
        this.title = title;
        this.year = (long) year;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public long getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authors='" + authors + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}
