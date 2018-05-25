package cn.service;

import cn.mapper.StudentMapper;
import cn.pojo.Student;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="StudentService")
public class StudentServiceImpl  implements  StudentService {

    @Autowired
    public StudentMapper studentMapper;

    @Override
    public List<Student> getStus(int pageIndex , int pageSize , Student student) {
        PageHelper.startPage(pageIndex, pageSize);
        List<Student> lists =   studentMapper.getStus(student);
        return lists;
    }

    @Override
    public boolean delStuById(int stuId) {
        int row = studentMapper.delStuById(stuId );
        if(row > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean addStu(Student student) {
        int row = studentMapper.addStu(student);
        if(row > 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Student getStuByStuId(int stuId) {
       return studentMapper.getStuByStuId(stuId);
    }

    @Override
    public boolean updateStu(Student student) {
        if(studentMapper.updateStu(student) == 1){
            return true;
        }else {
            return false;
        }
    }
}
