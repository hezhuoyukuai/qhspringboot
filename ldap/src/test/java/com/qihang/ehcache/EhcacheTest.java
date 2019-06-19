package com.qihang.ehcache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @ClassName: EhcacheTest
 * @Description:
 * @Author: HZ
 * @Date: 2019/6/6 11:44
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EhcacheTest {
    @Resource
    private CacheManager cacheManager;

    @Test
    public void testEhcache(){
        Cache userCache = cacheManager.getCache("userCache");
        userCache.put("key", "123");
        System.out.println("缓存成功");
        String res = userCache.get("key", String.class);
        System.out.println(res);
    }

}
