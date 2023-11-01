public class Main1WithGeneric {

    public static void main(String[] args) {
        CustomInteger i = new CustomInteger(5);
        System.out.println(i.add(5));

        CustomDouble d = new CustomDouble(0.05);
        System.out.println(d.add(0.05));
    }
}
