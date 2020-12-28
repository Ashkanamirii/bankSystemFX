package sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Ashkan Amiri
 * Date:  2020-12-28
 * Time:  11:42
 * Project: bankSystemFX
 * Copyright: MIT
 */
public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "bank_system";
        String databaseUsername = "Ashkan";
        String databasePassword = "Ashkan1885A!";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUsername,databasePassword);

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return databaseLink;
    }
}
