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
        Teacher teacher = sqlSession.getMapper(TeacherMapper.class).getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }
    @Test
    public void testStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<Student> students = sqlSession.getMapper(StudentMapper.class).getAllStudent2();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

}
