package cn.Demo.JdbcUtils;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

public class JdbcUtilsTest {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDatasource());
        int count = template.update("insert into user value(?, ?, ?, ?, ?, ?)", 2, "176029378871", "chh980929", "男", "陈航", new Date());
        System.out.println(count);
    }
}

