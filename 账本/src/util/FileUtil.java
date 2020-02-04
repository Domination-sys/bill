package util;

import entity.Login;
import service.LoginService;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
    public static String path  = System.getProperty("user.dir") + "/bill.setting";
    public static File f = new File(path);
    public static void writeSetting(Login login) {
        try (FileWriter fr = new FileWriter(f)) {
            // 以字符流的形式把数据写入到文件中
            String data= login.loginName +"\n"+login.password+"\n"+login.databaseName;
            char[] cs = data.toCharArray();
            fr.write(cs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Login getSetting(){
        if(f.exists())
        try (FileReader fr = new FileReader(f)) {
            // 创建字符数组，其长度就是文件的长度
            char[] all = new char[(int) f.length()];
            // 以字符流的形式读取文件所有内容
            fr.read(all);
            String s = String.copyValueOf(all);
            String[] ss = s.split("\n");
            Login login = new Login();
            login.loginName = ss[0];
            login.password = ss[1];
            login.databaseName = ss[2];
            return login;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
