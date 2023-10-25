import java.io.FileWriter;
import java.io.IOException;

public class MainFileWriter {

//    public static void main(String[] args) {
//        FileWriter writer = null;
//        try {
//            writer = new FileWriter("1.txt", true);
//            String encoding = writer.getEncoding();
//            System.out.println(encoding);
//
//            writer.write("a b c\n");
//            writer.write("а б в\n");
//
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }

    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("1.txt")) {
            writer.write("a b c\n");
            writer.write("а б в\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
//            String encoding = writer.getEncoding();
//            System.out.println(encoding);
//

//            writer.close();


    }
}
