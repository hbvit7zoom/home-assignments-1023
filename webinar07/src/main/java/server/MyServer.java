package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class MyServer {

    private RequestProcessor requestProcessor = new RequestProcessor();

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                Socket socket = serverSocket.accept();

                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);

                String startLine = dataInputStream.readLine();
                System.out.println(startLine);

                String[] s = startLine.split(" ");
                String method = s[0];
                String resource = s[1];

                String line = null;
                while (!(line = dataInputStream.readLine()).isEmpty()) {
                    System.out.println(line);
                }

                String body = "";
                while (true) {
                    if (dataInputStream.available() == 0) {
                        break;
                    }
                    line = dataInputStream.readLine();
                    System.out.println(line);
                    body += line;
                }

                OutputStream outputStream = socket.getOutputStream();

                String s1 = new String(body);

                Thread thread = new Thread(() -> requestProcessor.process(method, resource, s1, outputStream));
                thread.start();




                System.out.println("====");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
