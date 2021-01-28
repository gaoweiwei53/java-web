import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentMapper;
import org.example.dao.TeacherMapper;
import org.example.pojo.Student;
import org.example.pojo.Teacher;
import org.example.utils.MybatisUtils;
import org.junit.Test;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        Teacher teacherStudent = sqlSession.getMapper(TeacherMapper.class).getTeacherStudent(1);
        System.out.println(teacherStudent);
    }
}
