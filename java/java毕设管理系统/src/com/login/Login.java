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
    private  boolean sta;

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

    public boolean login(String name, String passward, String DBName){
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
            if(rs.next()){
                System.out.println("查找到对应用户");
                sta = rs.getString(status.concat("_passward")).equals(passward);
                System.out.println(rs.getString(status.concat("_passward")).equals(passward));
            }else{
                System.out.println("未查找到对应用户");
            }

        } catch (Exception e) {
            System.out.print("get data error!");
            e.printStackTrace();
        }finally {
            return sta;
        }
    }

    public static void main(String[] args) {
        String name = new String("1840701011");
        String passward = new String("123456");

        Login login = new Login("teacher",name,passward);
        login.login(name,passward,"mydata");

    }
}
