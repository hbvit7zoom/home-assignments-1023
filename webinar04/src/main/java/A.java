public class A extends Object {

    private int i;
    private String s;

    public A(int i, String s) {
        this.i = i;
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        A a = (A) o;

        if (i != a.i) return false;
        return s.equals(a.s);
    }

    @Override
    public int hashCode() {
        int result = i;
        result = 31 * result + s.hashCode();
        return result;
    }

    public static void main(String[] args) {
        A a1 = new A(1, "1");
        A a2 = new A(2, "2");
        A a3 = new A(1, "1");
        A a4 = a1;

        System.out.println(a1 == a2);
        System.out.println(a1 == a4);

        System.out.println(a1.equals(a3));
    }
}
