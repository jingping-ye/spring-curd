package com.yjp.curd.dao;

import com.yjp.curd.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {
    //  增加
    int add(UserModel user);

    boolean addBatch(List<UserModel> userList);

    //  删除
    boolean del(String id);

    //  修改
    int update(UserModel user);

    //  查-列表
    List<UserDao> getList();

    Map<UserModel, Object> getUserById(Integer id);
}
