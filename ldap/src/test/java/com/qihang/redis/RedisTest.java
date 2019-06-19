package com.qihang.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: RedisTest
 * @Author: HZ
 * @Description: TODO:
 * @Date: 2019/5/14 9:16
 * @Version: 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedisSet() {
        stringRedisTemplate.opsForValue().set("aaa", "1");
    }

}
