import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class E implements Comparator<D> {

    @Override
    public int compare(D o1, D o2) {
        return o1.getI() - o2.getI();
    }

    public static void main(String[] args) {
        D d1 = new D(-5, "Str22");
        D d2 = new D(0, "Str1");
        D d3 = new D(5, "Str");

        E comparator = new E();

        System.out.println(comparator.compare(d1, d2));
        System.out.println(comparator.compare(d2, d3));
        System.out.println(comparator.compare(d1, d3));

        List<D> list = new ArrayList<>();
        list.add(d1);
        list.add(d2);
        list.add(d3);

        System.out.println(list);

        // 5, 0, -5
        // 1, -1

//        list.sort(comparator);
//        list.sort((o1, o2) -> (o1.getI() + o2.getI()) % 2);

        list.sort((o1, o2) -> (o1.getS().length() - o2.getS().length()));

        System.out.println(list);
    }
}
