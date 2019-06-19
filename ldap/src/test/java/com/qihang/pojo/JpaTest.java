package com.qihang.pojo;


import com.qihang.dao.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testJpaAddUser() {
        User user = new User();
        user.setName("xiaohe22");
        user.setAge(122);
        userRepository.save(user);
    }

    @Test
    public void testJpaDeleteUser(){
        userRepository.deleteById("1");
    }

    @Test
    public void testJpaUpdateUser(){
//        userRepository.updateUser("1","xiaohua");
    }

    @Test
    public void testJpa2() {
        Optional<User> user =  userRepository.findById("1");
        List<User> all = userRepository.findAll();

        User user1 = user.get();
        System.out.println("查询结果：" + user1);

        Iterator<User> iterator = all.iterator();
        while (iterator.hasNext()){
            User next = iterator.next();
            System.out.println("遍历的user：" + next.getName());
        }
    }

}
