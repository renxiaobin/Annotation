package dao;

import java.sql.*;

/**
 * Created by rxb14 on 2016/3/7.
 */
public class JdbcConn {
    private static String url = "jdbc:mysql://localhost/chart";
    private static String user = "root";
    private static String password = "root";

    public static Connection conn;
    public static PreparedStatement ps;
    public static ResultSet rs;
    public static Statement st;

    public static Connection getConn(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
