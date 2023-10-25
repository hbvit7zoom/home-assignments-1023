import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainFileReader {

    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("1.txt")) {

            int ch = 0;
            while ((ch = fileReader.read()) != -1) {
                System.out.println("" + ch + ", " + (char) ch);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
