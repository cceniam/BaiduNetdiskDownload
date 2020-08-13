package com.windows;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Main {

    public static void main(String[] args) {
        // 此处处于 主线程，提交任务到 事件调度线程 创建窗口
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        // 此处处于 事件调度线程
                        createGUI();
                    }
                }
        );
    }

    public static void createGUI() {
        // 此处处于 事件调度线程
        JFrame jf = new JFrame("测试窗口");
        jf.setSize(800, 600);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        大标题
        JLabel titleLabel = new JLabel("毕业设计管理系统");
        Font font = new Font("宋体",Font.BOLD,50);
        titleLabel.setBounds(250,30,700,80);
        titleLabel.setFont(font);

//        用户名，密码输入框
        JLabel username = new JLabel("用户名");
        JLabel passward = new JLabel("密码");
        username.setBounds(300,200,70,40);
        passward.setBounds(300,230,70,40);

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        usernameField.setBounds(370,200,140,40);
        passwordField.setBounds(370,230,140,40);

//        登录按钮
        JPanel panel = new JPanel(null);
        panel.setSize(800,600);


//        职业选择


// 创建两个单选按钮
        JRadioButton radioBtn01 = new JRadioButton("教师");
        JRadioButton radioBtn02 = new JRadioButton("学生");
        JRadioButton radioBtn03 = new JRadioButton("学科办公室");

        // 创建按钮组，把两个单选按钮添加到该组
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(radioBtn01);
        btnGroup.add(radioBtn02);
        btnGroup.add(radioBtn03);

        radioBtn01.setLocation(400,100);
        radioBtn02.setLocation(450,100);
        radioBtn03.setLocation(300,100);
        radioBtn01.setSize(50,20);
        radioBtn02.setSize(50,20);
        radioBtn03.setSize(100,20);

        // 设置第一个单选按钮选中
        radioBtn01.setSelected(true);

        radioBtn01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioBtn01.isSelected()){
                    System.out.println("1被选中");
                }
            }
        });
        radioBtn02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioBtn02.isSelected()){
                    System.out.println("2被选中");
                }
            }
        });
        radioBtn03.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioBtn03.isSelected()){
                    System.out.println("3被选中");
                }
            }
        });






        JButton btn = new JButton("登录");
        btn.setBounds(370,350,80,25);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 此处处于 事件调度线程（所有监听器的回调都在 事件调度线程 中回调）、
                System.out.println("登录按钮被点击");
            }
        });



//        添加组件
        panel.add(titleLabel);
        panel.add(btn);

        panel.add(radioBtn01);
        panel.add(radioBtn02);
        panel.add(radioBtn03);


        panel.add(passward);
        panel.add(username);

        panel.add(usernameField);
        panel.add(passwordField);

        jf.add(panel);
        jf.setVisible(true);
    }

}