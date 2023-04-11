package Model;

import java.sql.*;
import java.sql.Connection;

public  class ConnectionFactory {

    public static Connection createConnection()
    {
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/wordguessr",
                    "root", "password");






        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return connection;
    }

    public static  void closeConnection(Connection con)
    {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
