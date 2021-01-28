package org.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.pojo.User;
import org.example.utils.MybatisUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        User user = sqlSession.getMapper(UserMapper.class).getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void testAddUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int i = sqlSession.getMapper(UserMapper.class).addUser(new User(4, "dude", "456"));
        sqlSession.commit();
        System.out.println(i);
        sqlSession.close();
    }
    @Test
    public void testUpdateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        sqlSession.getMapper(UserMapper.class).updateUser(new User(4,"dave","456"));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testDeleteUser(){

    }
    @Test
    public void testGetUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex",2);
        map.put("pageSize", 2);
        List<User> users = sqlSession.getMapper(UserMapper.class).getUserByLimit(map);
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
