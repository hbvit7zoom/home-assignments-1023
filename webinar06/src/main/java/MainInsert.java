import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainInsert {

    public static void main(String[] args) {
        Connection connection = ConnectionUtil.getConnection();

        try {
            Statement statement = connection.createStatement();

            statement.execute("CREATE TABLE public.newtable ( id bigint NOT NULL, name varchar NOT NULL, CONSTRAINT newtable_pk PRIMARY KEY (id) );");

//            statement.execute("insert into newtable (id, name) values (1, 'Антон');");
//            statement.execute("insert into newtable (id, name) values (2, 'Миша');");
//            statement.execute("insert into newtable (id, name) values (3, 'Иван');");

//            Long id = 3L;
//            String query = "UPDATE public.newtable\n" +
//                    "SET \"name\"='Вася'\n" +
//                    "WHERE id=" + id + ";";
//            System.out.println(query);

//            String id1 = "3; DROP TABLE public.newtable";
//            String query1 = "UPDATE public.newtable\n" +
//                    "SET \"name\"='Вася'\n" +
//                    "WHERE id=" + id1 + ";";
////            System.out.println(query1);
//            statement.execute(query1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
