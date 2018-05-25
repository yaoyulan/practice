package cn.service;

import cn.mapper.GradeMapper;
import cn.pojo.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("gradeService")
public class GradeServiceImpl implements  GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public List<Grade> getGrades() {
        List<Grade> grades =  gradeMapper.getGrades();
        return grades;
    }
}
