package util;

import entity.Login;
import service.LoginService;

import java.io.*;

public class MysqlUtil {
    static Login login = FileUtil.getSetting();
    public static void backup(String selectFile){
        String command = String.format("%s -u %s -p%s %s > %s",
                LoginService.getMysqldump(), login.loginName, login.password, login.databaseName, selectFile);
        runCommand(command);
    }
    public static void restore(String selectFile){
        String command = String.format("%s -u %s -p%s %s < %s",
                LoginService.getMysql(), login.loginName, login.password, login.databaseName, selectFile);
        runCommand(command);
    }
    private static void runCommand(String command) {
        String[] cmd = new String[3];
        String os = System.getProperties().getProperty("os.name");
        System.out.println(os);
        if (os.startsWith("Win")) {
            cmd[0] = "cmd.exe";
            cmd[1] = "/c";
        } else {
            cmd[0] = "/bin/sh";
            cmd[1] = "-c";
        }
        cmd[2] = command;
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) throws IOException {
        String file = "/Users/wangbotao/Desktop/ttt/m.sql";
        restore(file);
    }

}