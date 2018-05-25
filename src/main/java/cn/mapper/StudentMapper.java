package cn.mapper;

import cn.pojo.Student;

import java.util.List;

public interface StudentMapper {

    public List<Student> getStus(Student student);

    public int delStuById(int stuId);

    public  int addStu(Student student);

    public Student getStuByStuId(int stuId);

    public int updateStu(Student student);
}
