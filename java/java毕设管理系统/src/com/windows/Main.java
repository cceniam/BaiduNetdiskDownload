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
        jf.setSize(1000, 800);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        大标题
        JLabel titleLabel = new JLabel("毕业设计管理系统");
        Font font = new Font("宋体",Font.BOLD,30);
        titleLabel.setBounds(300,20,700,40);
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
        JPanel panel = new JPanel(new CardLayout(10, 10));


//        职业选择
        // 添加一个标签
        JLabel label = new JLabel("职业：");
        label.setLocation(370,100);

// 创建两个单选按钮
        JRadioButton radioBtn01 = new JRadioButton("男");
        JRadioButton radioBtn02 = new JRadioButton("女");

        // 创建按钮组，把两个单选按钮添加到该组
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(radioBtn01);
        btnGroup.add(radioBtn02);

        radioBtn01.setLocation(100,100);
        radioBtn02.setLocation(150,100);

        // 设置第一个单选按钮选中
        radioBtn01.setSelected(true);






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

        panel.add(label);

        panel.add(passward);
        panel.add(username);

        panel.add(usernameField);
        panel.add(passwordField);

        jf.add(panel);
        jf.setVisible(true);
    }

}