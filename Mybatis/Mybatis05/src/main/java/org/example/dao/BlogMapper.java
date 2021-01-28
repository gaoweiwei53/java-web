package org.example.dao;

import org.example.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int addBlog(Blog blog);

    // 查询博客
    List<Blog> queryBlogByIF(Map map);

    List<Blog> queryBlogByChoose(Map map);

    // 查询第1-2-3号记录的博客
    List<Blog> queryBlogForeach(Map map);


}
