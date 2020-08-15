package com.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {
    /*
    occupation 连接类型
    login_name 账号
    login_passward密码
     */
    public String occupation;
    public String login_name;
    private String login_passward;

    public Login(String occupation, String login_name, String login_passward) {
        this.occupation = occupation;
        this.login_name = login_name;
        this.login_passward = login_passward;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getLogin_passward() {
        return login_passward;
    }

    public void setLogin_passward(String login_passward) {
        this.login_passward = login_passward;
    }

    public void login(String name, String passward, String DBName){
//        加载驱动
        Sqllogin.lodingDriver();
//        连接数据库
        Connection connect = Sqllogin.loginSql(DBName);
        Statement stmt = null;
        try {
            stmt = connect.createStatement();
            String status ;
            if(occupation.equals("teacher")){
                status = "teacher";
            }else if(occupation.equals("student")){
                status = "student";
            }else{
                status = "off";
            }
            ResultSet rs = stmt.executeQuery("select * from  ".concat(occupation).concat(" where ").concat(status).concat("_id=\"").concat(name).concat("\""));
            //user 为你表的名称，可以在MySQL命令行用show tables；显示
            while (rs.next()) {
                System.out.println(rs.getString(status.concat("_passward")).equals(passward));
            }
        } catch (Exception e) {
            System.out.print("get data error!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String name = new String("1840701011");
        String passward = new String("123456");

        Login login = new Login("teacher",name,passward);
        login.login(name,passward,"mydata");

    }
}
