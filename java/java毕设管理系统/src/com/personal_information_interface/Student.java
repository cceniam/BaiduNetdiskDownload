package com.personal_information_interface;

import com.login.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {
    public  String student_name;
    public  String student_password;
    public  String gender;
    public  String major;

    @Override
    public String toString() {
        return "student{" +
                "student_name='" + student_name + '\'' +
                ", student_password='" + student_password + '\'' +
                ", gender='" + gender + '\'' +
                ", major='" + major + '\'' +
                '}';
    }

    public Student getInformation(Connection connection, Login login){
        try {
            Statement stmt = connection.createStatement();
            ResultSet studentResult = stmt.executeQuery("select * from student where student_id = \"".concat
                    (login.login_name).concat("\""));
            if(studentResult.next()){
                System.out.println("查找到对应用户");
                //获取用户信息
                 student_name= studentResult.getString("student_name");
                 student_password = studentResult.getString("student_passward");
                 gender = studentResult.getString("gender");
                 major = studentResult.getString("major");
                 toString();
            } else{
                System.out.println("未找到信息或信息已丢失");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            return this;
        }
    }
}
