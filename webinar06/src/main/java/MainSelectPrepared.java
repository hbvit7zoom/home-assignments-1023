import java.sql.*;

public class MainSelectPrepared {

    public static void main(String[] args) {
        Connection connection = ConnectionUtil.getConnection();

        try (PreparedStatement statement = connection.prepareStatement("select * from newtable;")) {
            ResultSet resultSet = statement.executeQuery();

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
