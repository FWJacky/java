package com.github.jdbc;

import java.io.ObjectInputStream;
import java.sql.*;

/**
 * @ClassName AbstractJdbcTemplate
 * @Description TODO
 * @Author L
 * @Date 2019/6/24 22:48
 * @Version 1.0
 **/
public abstract class AbstractJdbcTemplate {

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    //执行流程
    private Object t;
    public <T> T execute(String sql) {
        this.loadDriver();
        this.createConnection();
        this.createStatement();
        //5.
        if (sql.trim().toUpperCase().startsWith("SELECT")) {
            resultSet = this.executeQuery(sql);
            t = this.handlerResult(resultSet);
        } else {
            int effect = this.executeUpdate(sql);
            t = this.handlerResult(effect);
        }

        //6.
        this.close();
        return (T) t;
    }

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

    //1.
    private void loadDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //2.
    private void createConnection() {
        String url = "jdbc:mysql://127.0.0.1:3306/memo";
        try {
            this.connection = DriverManager.getConnection(url, "root", "072864");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //3.
    private void createStatement() {
        try {
            this.statement = this.connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //5.
    /*如果是查看数据库，则用executeQuery()*/
    private ResultSet executeQuery(String sql) {
        try {
            return this.statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*对数据库进行增添、修改、删除等操作时，用executeUpdate*/
    private int executeUpdate(String sql) {
        try {
            return this.statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //6.
    public abstract <T> T handlerResult(ResultSet resultSet);
    public abstract <T> T handlerResult(int effect);

    //7.
    private void close() {
        if (this.resultSet != null) {
            try {
                this.resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (this.statement != null) {
            try {
                this.statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
