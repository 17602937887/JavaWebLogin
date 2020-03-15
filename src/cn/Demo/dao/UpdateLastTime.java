package cn.Demo.dao;

import cn.Demo.JdbcUtils.JDBCUtils;
import cn.Demo.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

public class UpdateLastTime {
    public static void updateLastTime(User user){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDatasource());
        template.update("update user set lastTime = ? where id = ?", new Date(), user.getId());
    }
}
