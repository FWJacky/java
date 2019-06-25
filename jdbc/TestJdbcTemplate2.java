package com.github.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * @ClassName TestJdbcTemplate2
 * @Description TODO
 * @Author L
 * @Date 2019/6/25 15:31
 * @Version 1.0
 **/
public class TestJdbcTemplate2 {

    public static void main(String[] args) {
        JdbcTemplate2 jdbcTemplate2 = new JdbcTemplate2();
        String sql = "select id,name,created_time,modify_time from memo_group";
//        String sql2 = "insert into memo_group (name,created_time) values ('坏日子','2019-6-25 15:42:50')";
        String sql3 = "delete from memo_group where id=5";
//        String effect = jdbcTemplate2.execute(sql2,(JdbcTemplate2.Handler<Integer,String>) Integer ->"修改了"+Integer+"条数据");
        String effect = jdbcTemplate2.execute(sql3, (p) -> "修改了" + p + "条数据");
        System.out.println(effect);
        String rs = jdbcTemplate2.execute(sql, (JdbcTemplate2.Handler<ResultSet, String>) resultSet -> {
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
            return sb.toString();
        });
        System.out.println(rs);
    }
}
