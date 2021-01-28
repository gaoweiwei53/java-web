package org.example.dao;

import org.example.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 获取全部user
    List<User> getUserList();

    // 根据id查询
    User getUserById(int id);

    // insert
    int addUser(User user);

    // update
    int updateUser(User user);

    // delete
    int deleteUser(int id);
    // 使用Map
    int addUser2(Map<String, Object> map);

    List<User> getUserLike(String value);
}
