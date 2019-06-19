package com.qihang.service;

import com.qihang.commons.CommonResult;
import com.qihang.dao.UserRepository;
import com.qihang.pojo.User;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommonResult commonResult;

    public CommonResult addUser(User user) {

        return saveUser(user);
    }

    public CommonResult updateUserById(User user) {
        return saveUser(user);
    }

    private CommonResult saveUser(User user) {
        try {
            userRepository.save(user);
            return commonResult.setSuccess();
        } catch (Exception e) {
            commonResult.setData(e);
            return commonResult.setDefault();
        }
    }

    public CommonResult findUserById(String id) {
        try {
            if (!StringUtil.isNullOrEmpty(id)) {
                User user = userRepository.findById(id).get();
                commonResult.setData(user);
                return commonResult.setSuccess();
            } else {
                return commonResult.userDefined("false", "500", "id不能为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            commonResult.setData(e);
            return commonResult.setDefault();
        }
    }

    public CommonResult findUserByName(String name) {
        List<User> userList = null;
        try {
            userList = userRepository.findByName(name);
            commonResult.setData(userList);
            return commonResult.setSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            commonResult.setData(e);
            return commonResult.setDefault();
        }
    }

    public CommonResult deleteUserById(String id) {
        try {
            if (!StringUtil.isNullOrEmpty(id)) {
               userRepository.deleteById(id);
                return commonResult.setSuccess();
            } else {
                commonResult.setResultMsg("id不能为空");
                return commonResult.setDefault();
            }
        } catch (Exception e) {
            e.printStackTrace();
            commonResult.setData(e);
            return commonResult.setDefault();
        }
    }

    public CommonResult findUserList(){
        try {
            List<User> userList = userRepository.findAll();
            commonResult.setData(userList);
            return commonResult.setSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            commonResult.setData(e);
            return commonResult.setDefault();
        }
    }
}
