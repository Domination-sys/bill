package util;

import entity.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    static String ip = "127.0.0.1";
    static int port = 3306;
    public static Login login = null;;
    static String encoding = "UTF-8";
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            login = FileUtil.getSetting();
        } catch (ClassNotFoundException  e) {
            System.out.println("连接no成功");
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, login.databaseName, encoding);
        return DriverManager.getConnection(url, login.loginName, login.password);
    }
}