package com.github.jdbc;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Jdbc3
 * @Description TODO
 * @Author L
 * @Date 2019/6/30 12:54
 * @Version 1.0
 **/
public class Jdbc3 {

    public static void main(String[] args) {
        Integer id = 7;
        String name = "java";
        List<MemoGroup> memoGroups = queryMemoGroup(id, name);
        for (MemoGroup memoGroup : memoGroups) {
            System.out.println(memoGroup);
        }

        MemoGroup  memoGroup = new MemoGroup();
        memoGroup.setName("个人笔记");
        memoGroup.setCreated_time(LocalDateTime.now());

        boolean rs = createMemoGroup(memoGroup);
        if(rs) {
            System.out.println("创建便签组成功");
        }else {
            System.out.println("创建便签组失败");
        }
    }

    public static List<MemoGroup> queryMemoGroup(Integer id, String name) {
        List<MemoGroup> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memo", "root", "072864");
                 PreparedStatement statement = connection.prepareStatement("select id,name,created_time,modify_time from memo_group " + " where name = ? and id = ?")) {
                //参数赋值
                statement.setString(1, name);
                statement.setInt(2, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        MemoGroup memoGroup = new MemoGroup();
                        memoGroup.setId(resultSet.getInt("id"));
                        memoGroup.setName(resultSet.getString("name"));
                        memoGroup.setCreated_time(resultSet.getTimestamp("created_time").toLocalDateTime());
                        memoGroup.setModify_time(resultSet.getTimestamp("modify_time").toLocalDateTime());
                        //将结果包装成对象，添加到集合中
                        list.add(memoGroup);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean createMemoGroup(MemoGroup memoGroup) {
        List<MemoGroup> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/memo", "root", "072864");
                 PreparedStatement statement = connection.prepareStatement("insert into memo_group (name,created_time) values(?,?)")) {
                //参数赋值
                statement.setString(1, memoGroup.getName());
                statement.setTimestamp(2, Timestamp.valueOf(memoGroup.getCreated_time()));
                int effect = statement.executeUpdate();
                return effect == 1;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}

//跟数据库表关联的Java类称之为Entity类
class MemoGroup {

    private Integer id;
    private String name;
    private LocalDateTime created_time;
    private LocalDateTime modify_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated_time() {
        return created_time;
    }

    public void setCreated_time(LocalDateTime created_time) {
        this.created_time = created_time;
    }

    public LocalDateTime getModify_time() {
        return modify_time;
    }

    public void setModify_time(LocalDateTime modify_time) {
        this.modify_time = modify_time;
    }

    @Override
    public String toString() {
        return "MemoGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created_time=" + created_time +
                ", modify_time=" + modify_time +
                '}';
    }
}
