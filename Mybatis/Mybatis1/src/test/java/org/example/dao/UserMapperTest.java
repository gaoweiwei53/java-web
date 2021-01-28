package org.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.pojo.User;
import org.example.utils.MybatisUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void test(){
        // 第一步：获取sqlSession对象 最新的方式，推荐
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 方式1：getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        // 方式2：不推荐使用
//        List<User> userList = sqlSession.selectList("org.example.dao.UserMapper.getUserList()");

        for (User user : userList) {
            System.out.println(user);
        }

        // 关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        User user = sqlSession.getMapper(UserMapper.class).getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }
    // 增删改需要提交事务
    @Test
    public void testAddUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int i = sqlSession.getMapper(UserMapper.class).addUser(new User(4, "dude", "456"));

        // 提交事务
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
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        sqlSession.getMapper(UserMapper.class).deleteUser(5);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testAddUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();

        // key要和映射文件里配置的一致
        map.put("userId", 5);
//        map.put("userName","Elon");
        map.put("userPassword","567");
        mapper.addUser2(map);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testGetUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<User> users = sqlSession.getMapper(UserMapper.class).getUserLike("a");
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();

    }
}
