package server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class RequestProcessor {

    private ObjectMapper objectMapper = new ObjectMapper();
    private AuthorRepository authorRepository = new AuthorRepository();

    public void process(String method, String resource, String body, OutputStream outputStream) {

        String response = "";

        switch (method) {
            case "GET":
                response = doGet(resource);
                break;
            case "POST":
                response = doPost(resource, body);
                break;
            default:
                throw new UnsupportedOperationException();
        }

        try {
            outputStream.write(response.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String doPost(String resource, String body) {
        String response = "";

        if ("/author".equals(resource)) {
            try {
                Author author = objectMapper.readValue(body, Author.class);
                Author savedAuthor = authorRepository.create(author);
                String responseBody = objectMapper.writeValueAsString(savedAuthor);

                response = new StringBuilder()
                        .append("HTTP/1.1 200 OK").append("\n")
                        .append("Content-Type: application/json").append("\n")
                        .append("Content-Length: ").append(responseBody.length()).append("\n")
                        .append("\n")
                        .append(responseBody)
                        .toString();
            } catch (JsonProcessingException e) {
                return new StringBuilder()
                        .append("HTTP/1.1 400 BAD REQUEST").append("\n")
                        .append("\n")
                        .append("\n")
                        .toString();
            }
        } else {
            response = notFoundResponse();
        }

        return response;
    }

    private String doGet(String resource) {
        String response = "";

        if ("/".equals(resource)) {
            String responseBody = "<html><body><h1>HELLO</h1></body></html>";
            response = new StringBuilder()
                    .append("HTTP/1.1 200 OK").append("\n")
                    .append("Content-Type: text/html").append("\n")
                    .append("Content-Length: ").append(responseBody.length()).append("\n")
                    .append("\n")
                    .append(responseBody)
                    .toString();
        } else {
            response = notFoundResponse();
        }

        return response;
    }

    private String notFoundResponse() {

        return new StringBuilder()
                .append("HTTP/1.1 404 NOT FOUND").append("\n")
                .append("\n")
                .append("\n")
                .toString();
    }
}
