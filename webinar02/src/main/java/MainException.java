public class MainException {

    public static void main(String[] args) {
        try {
            throw new Exception("Что-то не так");
        } catch (Exception e) {
            throw new RuntimeException("Здесь что то не так", e);
        }
    }
}
