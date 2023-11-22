import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testcontainers.containers.PostgreSQLContainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertTest {

    static PostgreSQLContainer container;
    static Connection connection;

    @BeforeClass
    public static void init() throws SQLException, LiquibaseException {
        container = new PostgreSQLContainer("postgres:13.8-alpine");

        container.start();

        String jdbcUrl = container.getJdbcUrl().replace("?loggerLevel=OFF", "");
        String host = container.getHost();
        int port = container.getMappedPort(5432 );
        String username = container.getUsername();
        String password = container.getPassword();

        System.out.println(jdbcUrl);
        System.out.println(host);
        System.out.println(port);
        System.out.println(username);
        System.out.println(password);

        connection = DriverManager.getConnection(jdbcUrl, username, password);

        Database database = DatabaseFactory.getInstance()
                .findCorrectDatabaseImplementation(new JdbcConnection(connection));

        new Liquibase("db/changelog.xml", new ClassLoaderResourceAccessor(), database).update();
    }

    @Test
    public void test() {

        System.out.println("Test finished");
    }

    @AfterClass
    public static void down() throws SQLException {
//        container.stop();
//
//        connection.close();
    }
}
