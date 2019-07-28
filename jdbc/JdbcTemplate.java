package com.github.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * @ClassName JdbcTemplate
 * @Description TODO
 * @Author L
 * @Date 2019/6/24 23:10
 * @Version 1.0
 **/
public class JdbcTemplate extends AbstractJdbcTemplate {
    @Override
    public <T> T handlerResult(ResultSet resultSet) {
        StringBuilder sb = new StringBuilder();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Timestamp created_time = resultSet.getTimestamp("created_time");
                Timestamp modify_time = resultSet.getTimestamp("modify_time");
                sb.append(id + " " + name + " " + created_time + " " + modify_time);
                sb.append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (T) sb.toString();
    }

    @Override
    public <T> T handlerResult(int effect) {
        return (T) Integer.valueOf(effect);
    }

    public static void main(String[] args) {
        AbstractJdbcTemplate template = new JdbcTemplate();
        String sql = "select id,name,created_time,modify_time from memo_group";
//        String rs = template.execute(sql);
        Integer rs = template.execute("update memo_group set name='好日子' where id=1");
        String rs2 = template.execute(sql);
        System.out.println(rs);
        System.out.println(rs2);
    }
}
