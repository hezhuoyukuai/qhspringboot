package com.qihang.pojo;

import com.qihang.repository.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: MybatisTest
 * @Author: HZ
 * @Description: TODO:
 * @Date: 2019/5/13 14:15
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testMGet(){
        List<User> userList = userMapper.getUserList();
        System.out.println(userList);
    }

    @Test
    public void testMadd(){
        User user = new User();
        user.setName("xiaomeimei");
        user.setAge(12);
        userMapper.addUser(user);
    }
}
