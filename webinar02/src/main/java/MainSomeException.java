public class MainSomeException {

    public static void main(String[] args) {
        try {
            throw new SomeException("message");
        } catch (SomeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally");
        }
    }
}
