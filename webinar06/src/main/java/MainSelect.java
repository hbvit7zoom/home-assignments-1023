import java.sql.*;

public class MainSelect {

    public static void main(String[] args) {
        Connection connection = ConnectionUtil.getConnection();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from newtable;");

            while (resultSet.next()) {
                System.out.println(resultSet.getLong("id") + " " + resultSet.getString("name"));
            }
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
