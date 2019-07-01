package com.github.jdbc;

import java.sql.*;

/**
 * @ClassName JdbcTemplate2
 * @Description TODO
 * @Author L
 * @Date 2019/6/25 15:02
 * @Version 1.0
 **/
public class JdbcTemplate2{

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;


    //执行流程
    public <P,R> R execute(String  sql,Handler<P,R> handler){

        this.loadDriver();
        this.createConnection();
        this.createStatement();
        Object t;
        if(sql.trim().toUpperCase().startsWith("SELECT")) {
                this.resultSet = executeQuery(sql);
                t =  handler.handler((P) this.resultSet);
        }else {
                Integer effect = executeUpdate(sql);
                t = handler.handler((P) effect);
        }
        this.close();
        return (R)t;
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
    private void loadDriver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //2.
    private void createConnection(){
        String url = "jdbc:mysql://127.0.0.1:3306/memo";
        try {
            this.connection = DriverManager.getConnection(url,"root","072864");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //3.
    private void createStatement(){
        try {
            this.statement = this.connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //4.
    private ResultSet executeQuery(String sql){
            try {
                return this.statement.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
    }

    private int executeUpdate(String sql) {
        try {
            return this.statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @FunctionalInterface
    interface Handler<P,R>{
        R handler(P p);
    }

    //7.
    private void close(){
        if(this.resultSet!=null) {
            try {
                this.resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(this.statement!=null) {
            try {
                this.statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(this.connection!=null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        /**不能这么写，这种方式存在，一旦一个close()出现异常，后面的代码将不执行
        try {
            if(this.resultSet!=null) {
                    this.resultSet.close();
            }
            if(this.statement!=null) {
                    this.statement.close();
            }
            if(this.connection!=null) {
                    this.connection.close();
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
         */
    }

}
