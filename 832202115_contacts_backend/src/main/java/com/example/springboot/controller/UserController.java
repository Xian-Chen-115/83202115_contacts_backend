package com.example.springboot.controller;


import com.example.springboot.common.Page;
import com.example.springboot.common.Result;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //新增
    @PostMapping("/add")

    public Result add(@RequestBody User user){
        userService.insertUser(user);
        return Result.success();
    }

    @PutMapping("/update")

    public Result update(@RequestBody User user){
        userService.updateUser(user);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")

    public Result delete(@PathVariable Integer id){
        userService.deleteUser(id);
        return Result.success();
    }

    @DeleteMapping("/delete/batch")

    public Result batchdelete(@RequestBody  List<Integer> ids){
        userService.batchDeleteUser(ids);
        return Result.success();
    }

    @GetMapping("/selectAll")

    public Result selectAll(){
        List<User> userList = userService.selectAll();
        return Result.success(userList);
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id){
        User user = userService.selectById(id);
        return Result.success(user);
    }

    @GetMapping("/selectByName/{name}")
    public Result selectByName(@PathVariable String name){
        List<User> userList = userService.selectByName(name);
        return Result.success(userList);
    }

    /**
     * 多条件模糊查询用户信息
     * pageNum 当前的页码
     * pageSize 每页查询的个数
     */
    @GetMapping("/selectByPage")

    public Result selectByPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam String username,
                               @RequestParam String name) {
        Page<User> page = userService.selectByPage(pageNum, pageSize, username, name);
        return Result.success(page);
    }

}
