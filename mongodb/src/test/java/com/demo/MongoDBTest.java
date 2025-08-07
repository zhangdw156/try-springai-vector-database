package com.demo;

import com.demo.entity.User;
import com.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@Slf4j
@SpringBootTest
public class MongoDBTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSaveAndFindUser() {
        log.info("测试保存和查询用户");
        // 创建用户
        User user = new User("Alice", 30, "alice@example.com");
        userService.saveUser(user);
        log.info("用户保存成功, {}", user);
        // 查询用户
        List<User> users = userService.findByName("Alice");
        Assert.isTrue(!users.isEmpty(), "用户不存在");
        ;
        Assert.isTrue(!users.isEmpty(), "用户数量不唯一");
        User foundUser = users.get(0);
        Assert.isTrue(foundUser.getName().equals("Alice"), "用户名不匹配");

        log.info("测试通过");

    }
}
