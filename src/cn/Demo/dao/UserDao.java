package cn.Demo.dao;

import cn.Demo.JdbcUtils.JDBCUtils;
import cn.Demo.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    public static User login(User user){
        try {
            JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDatasource());
            User loginUser = template.queryForObject("select * from user where user = ? and password = ?", new BeanPropertyRowMapper<>(user.getClass()), user.getUser(), user.getPassword());
            return loginUser;
        } catch (DataAccessException e) {
            return null;
        }
    }
}
