package com.yjp.curd.controller;

import com.yjp.curd.dao.UserDao;
import com.yjp.curd.model.UserModel;
import com.yjp.curd.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("增加用户")
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public Object addUser(@RequestBody String user){
        Integer res = userService.add(user);
        Map map = new HashMap();
        if(res>0){
            map.put("code","4000");
            map.put("msg","新增成功");
            map.put("res", res);

        }else{
            map.put("code","4001");
            map.put("msg","新增失败");
        }
        return map;
    }

    @ApiOperation("批量增加用户")
    @RequestMapping(value="/add/batch", method = RequestMethod.POST)
    public Object addUserBatch(@RequestBody String userList){
        Integer res = userService.addBatch(userList);
        Map map = new HashMap();
        if(res>0){
            map.put("code","4000");
            map.put("msg","批量新增成功");
        }else {
            map.put("code","4001");
            map.put("msg","批量新增失败");
        }
        return map;
    }

    @ApiOperation("删除用户")
    @RequestMapping(value="/del", method = RequestMethod.DELETE)
    public String delUser(@RequestBody String args){
        if(userService.del(args)){
            return "删除成功";
        }else{
            return "删除失败！";
        }
    }

    @ApiOperation("修改用户")
    @RequestMapping(value="/update", method = RequestMethod.PUT)
    public Object updateUser(@RequestBody String user){
        Integer res = userService.update(user);
        Map map = new HashMap();
        if(res >0){
            map.put("code","4000");
            map.put("msg","修改成功");
            map.put("res", res);
        }else{
            map.put("code","4001");
            map.put("msg","修改失败");
        }
        return map;
    }

    @ApiOperation("查询用户列表")
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public List<UserDao> getList(){
        return userService.getList();
    }

    @ApiOperation("查询用户详情")
    @RequestMapping(value="/detail", method = RequestMethod.GET)
    public Map<UserModel, Object> getUserById(@RequestParam String id){
        return userService.getUserById(id);
    }
}
