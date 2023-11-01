import java.util.ArrayList;
import java.util.List;

public class MainWithList {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();

        list.add("String");
        list.add(1);

        System.out.println(list);

        for (Object o : list) {
            if (o instanceof String) {
                String o1 = (String) o;
                System.out.println(o1 + o1);
            } else if (o instanceof Integer) {
                Integer o1 = (Integer) o;
                System.out.println(o1 + o1);
            }
        }

    }
}
