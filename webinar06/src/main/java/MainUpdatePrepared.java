import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainUpdatePrepared {

    public static void main(String[] args) {
        Connection connection = ConnectionUtil.getConnection();

        try (PreparedStatement statement = connection.prepareStatement("insert into newtable (id, name) values (?, ?);")) {

            statement.setLong(1, 2L);
            statement.setString(2, "; DROP TABLE public.newtable");

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
