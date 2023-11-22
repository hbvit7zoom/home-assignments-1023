import java.sql.*;

public class MainInsertPrepared {

    public static void main(String[] args) {
        Connection connection = ConnectionUtil.getConnection();

        try (PreparedStatement statement = connection.prepareStatement("UPDATE public.newtable SET name='Вася' WHERE id=?;")) {

            statement.setLong(1, 2L);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
