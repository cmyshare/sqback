package com.sqback.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class mysqlTest {
    public static void main(String[] args) {

//        //最多允许10位数
//        String str = "";
//        for (int i = 10000; i < 40000; i++) {
//            str = String.format("2018%07d",i);
//            //str= "201807"+i;
//            System.out.println(str);
//            //System.out.println(Integer.parseInt(str));
//        }

        String score = "[{\"number\":\"1\", \"course\":\"[S1001301]Python数据处理编程\", \"credits\":\"6.0\", \"category\":\"专业课/必修课\", \"assessManner\":\"考试\", \"readType\":\"初修\",\"grades\":\"80.00\",\"earnCredits\":\"6.0\", \"gpa\":\"3.0\", \"creditMarks\":\"18.00\", \"remark\":\" \"},{\"number\":\"2\",\"course\":\"[S1001301]Python数据处理编程\", \"credits\":\"6.0\", \"category\":\"专业课/必修课\", \"assessManner\":\"考试\", \"readType\":\"初修\", \"grades\":\"80.00\", \"earnCredits\":\"6.0\", \"gpa\":\"3.0\", \"creditMarks\":\"18.00\", \"remark\":\" \"},{\"number\":\"3\",\"course\":\"[S1001301]Python数据处理编程\", \"credits\":\"6.0\", \"category\":\"专业课/必修课\", \"assessManner\":\"考试\", \"readType\":\"初修\", \"grades\":\"80.00\", \"earnCredits\":\"6.0\", \"gpa\":\"3.0\", \"creditMarks\":\"18.00\", \"remark\":\" \"},{\"number\":\"4\",\"course\":\"[S1001301]Python数据处理编程\", \"credits\":\"6.0\", \"category\":\"专业课/必修课\", \"assessManner\":\"考试\", \"readType\":\"初修\", \"grades\":\"80.00\", \"earnCredits\":\"6.0\", \"gpa\":\"3.0\", \"creditMarks\":\"18.00\", \"remark\":\" \"},{\"number\":\"5\",\"course\":\"[S1001301]Python数据处理编程\", \"credits\":\"6.0\", \"category\":\"专业课/必修课\", \"assessManner\":\"考试\", \"readType\":\"初修\", \"grades\":\"80.00\", \"earnCredits\":\"6.0\", \"gpa\":\"3.0\", \"creditMarks\":\"18.00\", \"remark\":\" \"},{\"number\":\"6\",\"course\":\"[S1001301]Python数据处理编程\", \"credits\":\"6.0\", \"category\":\"专业课/必修课\", \"assessManner\":\"考试\", \"readType\":\"初修\", \"grades\":\"80.00\", \"earnCredits\":\"6.0\", \"gpa\":\"3.0\", \"creditMarks\":\"18.00\", \"remark\":\" \"}]";
        String str = "";

        Connection conn;
        PreparedStatement stmt;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/score_query?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
        String user = "root";
        String password = "123456";
        String sql = "insert into studentscore values (?,?)";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            stmt = (PreparedStatement) conn.prepareStatement(sql);
            for (int i = 18; i <= 21; i++) {
                for (int j=1; j<=10000; j++) {
                    str = String.format("20%d07%05d",i,j);
                    System.out.println(str);
                    stmt.setString(1, str);
                    stmt.setString(2, score);
                    stmt.executeUpdate();
                }
            }
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

}

