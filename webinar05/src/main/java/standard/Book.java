package standard;

import java.io.Serializable;

public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String author;
    private final String title;
    private final transient Long year;

    public Book(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = (long) year;
    }

    public String getAuthor() {
        return author;
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
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}
