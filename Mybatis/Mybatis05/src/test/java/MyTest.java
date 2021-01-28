import org.apache.ibatis.session.SqlSession;
import org.example.dao.BlogMapper;
import org.example.pojo.Blog;
import org.example.utils.IdUtils;
import org.example.utils.MybatisUtils;
import org.junit.Test;

import java.util.*;

public class MyTest {
    @Test
    public void testId(){
        System.out.println(IdUtils.getID());
        System.out.println(IdUtils.getID());
        System.out.println(IdUtils.getID());
    }
    @Test
    public void testAddBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IdUtils.getID());
        blog.setTitle("Alex Introduction");
        blog.setAuthor("alex");
        blog.setCreateTime(new Date());
        blog.setViews(666);
        mapper.addBlog(blog);

        blog.setId(IdUtils.getID());
        blog.setTitle("Mybatis is easy");
        mapper.addBlog(blog);

        blog.setId(IdUtils.getID());
        blog.setTitle("Spring is easy");
        mapper.addBlog(blog);

        blog.setId(IdUtils.getID());
        blog.setTitle("BigData is easy");
        mapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void testQueryByIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("views",666);
//        map.put("title","Alex Introduction");
        List<Blog> blogs = mapper.queryBlogByChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blogs);
        }
        sqlSession.close();
    }

    @Test
    public void testQueryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        map.put("ids", ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }


}
