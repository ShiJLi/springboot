package com.shijl;

import com.shijl.bean.User;
import com.shijl.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
class SpringbootAdminApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<Map<String, Object>> lists = jdbcTemplate.queryForList("select  *  from user");
        log.info("用户表:{}",lists.toString());

        log.info("数据类型：{}",dataSource.getClass());
    }


    @Test
    void testUserMapper(){
        User user = userMapper.selectById(1);
        log.info("用户信息:{}",user);
    }

}
