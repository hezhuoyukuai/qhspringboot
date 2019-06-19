package com.qihang.controller;

import com.qihang.commons.CommonResult;
import com.qihang.pojo.User;
import com.qihang.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;


/**
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * @param
     * @return java.lang.String
     * @Description //TODO
     * @author HZ
     * @date 2019/5/13 13:36
     */
    @GetMapping("/")
    @ApiOperation(value="获取用户列表", notes="")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    public String getUser(HttpServletRequest request) {
        String remoteHost = request.getRemoteHost();
        MDC.put("clientIp",remoteHost);
        MDC.put("operateResult", "success");
        return "user-info";
    }

    @GetMapping("/fileTest")
    public void testFile(){
            File file = null;
            boolean b = file.canWrite();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    public CommonResult getUserList(){
        return userService.findUserList();
    }

    @GetMapping(value = "/findUserById/{id}")
    public CommonResult getUserById(@PathVariable String id){
        return userService.findUserById(id);
    }

    @GetMapping(value = "/findUserByName/{name}")
    public CommonResult getUserByName(@PathVariable String name){
        return userService.findUserByName(name);
    }


    @PostMapping("/addUser")
    public CommonResult addUser(User user){
        return userService.addUser(user);
    }

    @DeleteMapping("/deleteUserById/{id}")
    public CommonResult addUser(@PathVariable String id){
        return userService.deleteUserById(id);
    }

    @PutMapping("/updateUser")
    public CommonResult updateUser(User user){
        return userService.updateUserById(user);
    }
}
