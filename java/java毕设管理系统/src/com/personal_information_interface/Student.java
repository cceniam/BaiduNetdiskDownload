package com.personal_information_interface;

import com.login.Login;

import java.sql.*;

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
    /**
     * 获取学生信息
     */

    public void getInformation(Connection connection, Login login){
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
        }
    }

    /**
     * 修改用户信息
     * @param connection
     * @param login
     * @param info
     */
    public void modifyInfoName(Connection connection, Login login, String info){
        System.out.println("update student" +
                " set student_name = \"".concat(info).concat("\" where student_id = ").concat
                        (login.login_name));

        try (PreparedStatement preparedStatement = connection.prepareStatement("update student set student_name = ? ,student_passward = ?,gender = ?,major = ? where student_id = 1840702011")) {
            // ... add parameters to the SQL query using PreparedStatement methods:
            //     setInt, setString, etc.
            preparedStatement.setString(1,"奥古都");
            preparedStatement.setString(2,"123412156");
            preparedStatement.setString(3,"男");
            preparedStatement.setString(4,"通信学院");
            int res = preparedStatement.executeUpdate();

            if (res > 0 ) {
                System.out.println("更新数据成功");
            }
        } catch (SQLException e) {
            // ... handle SQL exception
            e.printStackTrace();
        }

    }
}
