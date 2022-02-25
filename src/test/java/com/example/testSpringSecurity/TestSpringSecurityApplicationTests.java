package com.example.testSpringSecurity;

import com.example.testSpringSecurity.mapper.AuthorityMapper;
import com.example.testSpringSecurity.mapper.UserMapper;
import com.example.testSpringSecurity.model.Role;
import com.example.testSpringSecurity.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
class TestSpringSecurityApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private com.example.testSpringSecurity.mapper.AuthorityMapper authorityMapper;

    @Autowired
    private com.example.testSpringSecurity.mapper.RoleMapper roleMapper;

    @Test
    void contextLoads() {
        User user = userMapper.findByUsername("yang");
        System.out.println(user);
    }

    @Test
    void contextLoads2() {
    }

    @Test
    void contextLoads123() {
        System.out.println(new BCryptPasswordEncoder().encode("123")); ;

    }

}
