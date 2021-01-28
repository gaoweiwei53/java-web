import org.apache.ibatis.session.SqlSession;
import org.example.dao.UserMapper;
import org.example.pojo.User;
import org.example.utils.MybatisUtils;
import org.junit.Test;

import java.util.List;

public class MyTest {
   @Test
    public void testQueryUser(){
       SqlSession sqlSession = MybatisUtils.getSqlSession();
       User user1 = sqlSession.getMapper(UserMapper.class).queryUser(1);
       System.out.println(user1);
       sqlSession.clearCache(); // 手动清理缓存
       User user2 = sqlSession.getMapper(UserMapper.class).queryUser(1);
       System.out.println(user2);
       sqlSession.close();
   }
}
