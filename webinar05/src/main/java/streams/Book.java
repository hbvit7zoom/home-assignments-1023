package streams;

public class Book {

    private String author;
    private String title;
    private Long year;

    public Book() {
    }

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
