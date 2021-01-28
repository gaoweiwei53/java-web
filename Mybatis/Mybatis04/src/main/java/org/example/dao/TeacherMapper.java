package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {
    @Select("select * from teacher")
    List<Teacher> getTeacher();

    // 获取指定老师及其所有学生
    Teacher getTeacherStudent(@Param("tid") int id);
}
