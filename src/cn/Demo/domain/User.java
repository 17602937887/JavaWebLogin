package cn.Demo.domain;

import java.util.Date;

/**
 * 用户的实体类
 */
public class User {
    private Integer id;
    private String user;
    private String password;
    private String gender;
    private String name;
    private Date join_date;
    private Date lastTime;

    public User() {
    }

    public User(Integer id, String user, String password, String gender, String name, Date join_date, Date lastTime) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.gender = gender;
        this.name = name;
        this.join_date = join_date;
        this.lastTime = lastTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", join_date=" + join_date +
                ", lastTime=" + lastTime +
                '}';
    }
}
