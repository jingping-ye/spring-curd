package com.yjp.curd.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yjp.curd.dao.UserDao;
import com.yjp.curd.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;


    public int add(String user) {
        //  提取用户输入信息
        JSONObject jsonObject = JSONObject.parseObject(user);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");

        //  注入实体 对象
        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        userModel.setPassword(password);

        //  返回新增id
        if(userDao.add(userModel)>0){
            return userModel.getId();
        }else{
            return 0;
        }
    }

    public int addBatch(String userList){
        //  提取输入的用户信息

        List<UserModel> addUserlist = new ArrayList<>();

        List<HashMap> list = JSON.parseArray(userList, HashMap.class);
        for(Map<String, Object> userItem:list){
            String username = (String) userItem.get("username");
            String password = (String) userItem.get("password");

            UserModel userModel = new UserModel();
            userModel.setUsername(username);
            userModel.setPassword(password);

            addUserlist.add(userModel);
        }



        //  返回新增信息
        Boolean res = userDao.addBatch(addUserlist);

        if(res){
            return 1;
        }else{
            return 0;
        }

    }



    public boolean del(String args) {
        JSONObject jsonObject = JSONObject.parseObject(args);
        String id = jsonObject.getString("id");
        return userDao.del(id);
    }


    public int update(String user) {
        //  提取用户输入信息
        JSONObject jsonObject = JSONObject.parseObject(user);
        Integer id = Integer.valueOf(jsonObject.getString("id"));
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");

        //  注入实体 对象
        UserModel userModel = new UserModel();
        userModel.setId(id);
        userModel.setUsername(username);
        userModel.setPassword(password);

        //  返回新增id
        if(userDao.update(userModel)>0){
            return userModel.getId();
        }else{
            return 0;
        }
    }

    public List<UserDao> getList() {
        return userDao.getList();
    }

    public Map<UserModel, Object> getUserById(String id){
        Integer _id = Integer.valueOf(id);
        Map<UserModel, Object> userInfo = userDao.getUserById(_id);
        return userInfo;
    }
}
