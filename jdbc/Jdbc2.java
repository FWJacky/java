package com.github.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MyFirstJdbcCase
 * @Description   参数化SQL需要使用preparedStatement 以及 ?
 * @Author L
 * @Date 2019/6/24 19:06
 * @Version 1.0
 **/
public class Jdbc2 {

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

    /**
     * @Author L
     * @Description //  解决sql注入
     * @Date 11:50 2019/6/30
     * @Param
     * @return
     **/

    public static void main(String[] args) {
        //C++
        //sql注入
        //name = ' C++ ';
        //name = ' ' or 1=1 or name = ' ';
        //name in (" 'java' , 'C++' ";
        //in 不支持一个?表示多个参数，所以需要使用字符串拼接，但是存在SQL注入，所以又需要参数校验
//        List<Map<String, Object>> data = queryMemoGroupByName("' or 1=1 or name = '");
        List<Map<String, Object>> data = queryMemoGroupByName("java");
        for (Map<String, Object> item : data) {
            System.out.println(item);
        }


    }

    public static List<Map<String, Object>> queryMemoGroupByName(String groupName) {
        //结果集
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            //1.
            Class.forName("com.mysql.jdbc.Driver");

            //2.
            //jdbc协议：
            //jdbc:<databaseType>://<host>:<port>/<databaseName>?user=<your userName>&password=<your password>
            String url = "jdbc:mysql://127.0.0.1:3306/memo";
//            String sql = "delete from memo_group where id = 4";
            String sql = "select id,name,created_time,modify_time from memo_group where name = (in) ? ";

            try (Connection connection = DriverManager.getConnection(url, "root", "072864");
                 //通过Connection对象，根据参数化的SQL获取预编译命令
                 PreparedStatement statement = connection.prepareStatement(sql);
            ) {
                //参数赋值，下标从1开始（切记）
                //？代表占位符，下标从1开始
                statement.setString(1, groupName);
                //预编译命令直接进行查询
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        Timestamp created_time = resultSet.getTimestamp("created_time");
                        Timestamp modify_time = resultSet.getTimestamp("modify_time");
                        Map<String, Object> row = new HashMap<>();
                        row.put("id", id);
                        row.put("name", name);
                        row.put("created_time", created_time);
                        row.put("modify_time", modify_time);
                        list.add(row);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
