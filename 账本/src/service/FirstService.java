package service;

import entity.Login;
import util.DBUtil;
import util.FileUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstService {
    public static boolean isLanded(){
        if (FileUtil.f.exists()&isConnect())
            return true;
        return false;
    }
    private static boolean isConnect(){
        if(isConnect(FileUtil.getSetting()))
            return true;
        return false;
    }
    public static boolean isConnect(Login login){
        if(null==login)
            return false;
        String url = "jdbc:mysql://127.0.0.1:3306/"+login.databaseName+"?characterEncoding=UTF-8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection(url, login.loginName, login.password);
            c.close();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void createTable(){
        try(Connection c = DBUtil.getConnection(); Statement s = c.createStatement()){
            String sql = "CREATE TABLE config (\n" +
                    "  id int AUTO_INCREMENT,\n" +
                    "  key_ varchar(255) ,\n" +
                    "  value varchar(255) ,\n" +
                    "  PRIMARY KEY (id)\n" +
                    ")  DEFAULT CHARSET=utf8;";
            s.execute(sql);
            sql = " CREATE TABLE category (\n" +
                    "  id int AUTO_INCREMENT,\n" +
                    "  name varchar(255) ,\n" +
                    "  PRIMARY KEY (id)\n" +
                    ")  DEFAULT CHARSET=utf8;";
            s.execute(sql);
            sql = "CREATE TABLE record (\n" +
                    "  id int AUTO_INCREMENT,\n" +
                    "  spend int,\n" +
                    "  cid int,\n" +
                    "  comment varchar(255) ,\n" +
                    "  date Date,\n" +
                    "  PRIMARY KEY (id),\n" +
                    "  CONSTRAINT `fk_record_category` FOREIGN KEY (`cid`) REFERENCES `category` (`id`)\n" +
                    ")  DEFAULT CHARSET=utf8; ";
            s.execute(sql);
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
