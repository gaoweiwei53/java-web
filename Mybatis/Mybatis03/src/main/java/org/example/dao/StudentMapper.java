package org.example.dao;

import org.example.pojo.Student;
import org.example.pojo.Teacher;

import java.util.List;

public interface StudentMapper {
    // 查询所有的学生信息和对应的老师的信息
    public List<Student> getAllStudent();
    public List<Student> getAllStudent2();
}
