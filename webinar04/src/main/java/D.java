public class D implements Comparable<D> {

    private int i;
    private String s;

    public D(int i, String s) {
        this.i = i;
        this.s = s;
    }

    @Override
    public int compareTo(D o) {
        return i - o.i;
    }

    public int getI() {
        return i;
    }

    public String getS() {
        return s;
    }

    public static void main(String[] args) {
        D d1 = new D(-5, "Str");
        D d2 = new D(0, "Str");
        D d3 = new D(5, "Str");

        System.out.println(d1.compareTo(d2));
        System.out.println(d2.compareTo(d3));
        System.out.println(d1.compareTo(d3));
    }
}
