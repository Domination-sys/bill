package service;

import util.DBUtil;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginService {
    private static String getPath(){
        String path = "";
        try(Connection c= DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "show global variables like \"%datadir%\";";
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            path = rs.getString(2);
            path = path.substring(0,path.length()-5)+"bin/mysql";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return path;
    }
    public static boolean isWindows(){
        String os = System.getProperties().getProperty("os.name");
        if (os.startsWith("Win"))
            return true;
        return false;
    }
    public static String getMysql(){
        if(isWindows())
            return getPath()+".exe";
        else
            return getPath();
    }
    public static String getMysqldump(){
        if(isWindows())
            return getPath()+"dump.exe";
        else
            return getPath()+"dump";
    }
    public static void main(String[] args) {
        System.out.println(isWindows());
        System.out.println(getMysql());
        System.out.println(getMysqldump());
    }
}
