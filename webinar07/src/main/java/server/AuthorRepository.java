package server;

import java.util.HashMap;
import java.util.Map;

public class AuthorRepository {

    private Map<Integer, Author> authorMap = new HashMap<>();

    public Author create(Author author) {
        int id = authorMap.size() + 1;

        author.setId(id);

        authorMap.put(id, author);

        return author;
    }
}
