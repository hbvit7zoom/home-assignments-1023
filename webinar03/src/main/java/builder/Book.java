package builder;

public class Book {

    public String author;
    public String title;

    private Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    static class BookBuilder {

        public String author;
        public String title;

        BookBuilder author(String author) {
            this.author = author;
            return this;
        }

        BookBuilder title(String title) {
            this.title = title;
            return this;
        }

        Book toBook() {
            return new Book(this.author, this.title);
        }
    }


}
