package json;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
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

    @JsonProperty(value = "name")
    private String title;

    @JsonIgnore
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
