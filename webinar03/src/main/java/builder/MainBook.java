package builder;

public class MainBook {
    public static void main(String[] args) {
        Book book = new Book.BookBuilder()
                .title("Евгений Онегин")
                .author("Пушкин")
                .toBook();
    }
}
