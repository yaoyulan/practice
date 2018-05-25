package cn.service;

import cn.pojo.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getStus(int pageIndex , int pageSize , Student student);

    public boolean delStuById(int stuId);

    public boolean addStu(Student student);

    public Student getStuByStuId(int stuId);

    public boolean updateStu(Student student);
}
