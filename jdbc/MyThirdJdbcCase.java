package com.github.jdbc;

import java.sql.*;

/**
 * @ClassName MyFirstJdbcCase
 * @Description TODO
 * @Author L
 * @Date 2019/6/24 19:06
 * @Version 1.0
 **/
public class MyThirdJdbcCase {

    /*
        1.加载数据库的JDBC驱动
        2.创建连接
        3.创建命令
        4.准备SQL语句
        5.执行SQL
        6.处理结果
        7.关闭结果
        8.关闭命令
        9.关闭连接
     */

    public static void main(String[] args) {


        try {
            //1.
            Class.forName("com.mysql.jdbc.Driver");

            //2.
            //jdbc协议：
            //jdbc:<databaseType>://<host>:<port>/<databaseName>?user=<your userName>&password=<your password>
            String url = "jdbc:mysql://127.0.0.1:3306/memo";
//            String sql = "delete from memo_group where id = 4";
            String sql = "select id,name,created_time,modify_time from memo_group";

            try(Connection connection = DriverManager.getConnection(url,"root","072864");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
            ){
                while(resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    Timestamp created_time = resultSet.getTimestamp("created_time");
                    Timestamp modify_time = resultSet.getTimestamp("modify_time");
                    System.out.println(id+" "+name+" "+created_time+" "+modify_time);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
