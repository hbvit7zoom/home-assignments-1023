import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MainObjectOutputStream {

    public static void main(String[] args) {


//        String str = new String("Вася");
        String str = "Вася";

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("1.serialized"));

            oos.writeObject(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
