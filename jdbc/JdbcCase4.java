package com.github.jdbc;

import com.github.jdbc.MemoGroup;

import java.awt.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JdbcCase4
 * @Description TODO
 * @Author L
 * @Date 2019/6/30 13:42
 * @Version 1.0
 **/
public class JdbcCase4 {

    public static boolean createMemoInfo(MemoGroup memoGroup, MemoInfo memoInfo) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //写入useSSL=false就会关闭安全认证
            String url = "jdbc:mysql://127.0.0.1:3306/memo?useSSL=false";
            connection = DriverManager.getConnection(url, "root", "072864");
            //事务控制
            //setAutoCommit()默认为true，改为false后才可以进行事务控制
            connection.setAutoCommit(false);
            //一组DML要么成功，要么失败
            String memoGroupInsertSql = "insert into memo_group (id,name,created_time) values (?,?,?)";
            String memoInfoInsertSql = "insert into memo_info (id,group_id,title,content,created_time) values (?,?,?,?,?)";
            int effectA = -1;
            int effectB = -1;
            try (PreparedStatement statement = connection.prepareStatement(memoGroupInsertSql)) {
                statement.setInt(1, memoGroup.getId());
                statement.setString(2, memoGroup.getName());
                statement.setTimestamp(3, Timestamp.valueOf(memoGroup.getCreated_time()));
                effectA = statement.executeUpdate();
            }

            try (PreparedStatement statement1 = connection.prepareStatement(memoInfoInsertSql)) {
                statement1.setInt(1, memoInfo.getId());
                statement1.setInt(2, memoInfo.getGroupId());
                statement1.setString(3, memoInfo.getTitle());
                statement1.setString(4, memoInfo.getContent());
                statement1.setTimestamp(5, Timestamp.valueOf(memoInfo.getCreatedTime()));
                effectB = statement1.executeUpdate();
            }

            //正常执行完成之后，根据结果确定是否提交或者回滚
            if (effectA == 1 && effectB == 1) {
                connection.commit();
                return true;
            } else {
                connection.rollback();
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            //执行失败
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MemoGroup memoGroup = new MemoGroup();
        memoGroup.setId(666);
        memoGroup.setName("测试组");
        memoGroup.setCreated_time(LocalDateTime.now());

        MemoInfo memoInfo = new MemoInfo();
        memoInfo.setId(555);
        memoInfo.setGroupId(memoGroup.getId());
        memoInfo.setTitle("今天是个好日子");
        memoInfo.setContent("~~~~~~");
        memoInfo.setCreatedTime(LocalDateTime.now());

        boolean rs = createMemoInfo(memoGroup, memoInfo);
        if (rs) {
            System.out.println("创建便签成功");
        } else {
            System.out.println("创建便签失败");
        }
    }
}

class MemoInfo {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 组编号
     */
    private Integer groupId;
    private String title;
    private String content;
    private String isProtected;
    private Color backGround;
    private String isRemind;
    private LocalDateTime remindTime;
    private LocalDateTime createdTime;
    private LocalDateTime modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsProtected() {
        return isProtected;
    }

    public void setIsProtected(String isProtected) {
        this.isProtected = isProtected;
    }

    public Color getBackGround() {
        return backGround;
    }

    public void setBackGround(Color backGround) {
        this.backGround = backGround;
    }

    public String getIsRemind() {
        return isRemind;
    }

    public void setIsRemind(String isRemind) {
        this.isRemind = isRemind;
    }

    public LocalDateTime getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(LocalDateTime remindTime) {
        this.remindTime = remindTime;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "MemoInfo{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", isProtected='" + isProtected + '\'' +
                ", backGround=" + backGround +
                ", isRemind='" + isRemind + '\'' +
                ", remindTime=" + remindTime +
                ", createdTime=" + createdTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
enum Color {
    WHITE, BLUE, GREEN, RED;
}
