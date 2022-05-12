import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    Connection databaseLink;

    public Connection getConnection() {
        String databaseName = "users";
        String databaseUser = "root";
        String databasePassword = "root";
        String url = "jdbc:mysql://localhost/" + databaseName;
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return databaseLink;

    }
}
